package weather;
import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class coolhot {

public static void main(String [] args) throws Exception

{

Configuration c=new Configuration();



Path input=new Path(args[0]);

Path output=new Path(args[1]);

Job j=new Job(c,"weather");

j.setJarByClass(coolhot.class);

j.setMapperClass(MapForWordCount.class);

j.setReducerClass(ReduceForWordCount.class);

j.setOutputKeyClass(Text.class);

j.setOutputValueClass(IntWritable.class);

FileInputFormat.addInputPath(j, input);

FileOutputFormat.setOutputPath(j, output);

System.exit(j.waitForCompletion(true)?0:1);

}

public static class MapForWordCount extends Mapper<LongWritable, Text, Text, IntWritable>{

public void map(LongWritable key, Text value, Context con) throws IOException, InterruptedException

{

	String line = value.toString();

	String temp = line.substring(87,92);
	
	int t = Integer.parseInt(temp);
	
	String year = line.substring(15,19);
	
	Text op = new Text(year.trim());
	
	con.write(op,new IntWritable(t));

	


}
}
public static class ReduceForWordCount extends Reducer<Text, IntWritable, Text, IntWritable>

{
	int sum = 0,count=0;
	public void reduce(Text word, Iterable<IntWritable> values, Context con) throws IOException, InterruptedException
	
	{
	
		 for(IntWritable value : values)
				 {
			 		sum += value.get();
			 		count++;
				 }
		 
	   int avg = sum/count;
	   
	   con.write(word, new IntWritable(avg));
	}
	//cleanup
	

}

}