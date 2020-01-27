package Log;
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

public class active {

public static void main(String [] args) throws Exception

{

Configuration c=new Configuration();



Path input=new Path(args[0]);

Path output=new Path(args[1]);

Job j=new Job(c,"wordcount");

j.setJarByClass(active.class);

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

	String[] words=line.split(",");

	String prv = null;
	int flag = 0;
	int yes;
	Text opkey = null;



	for(String word  : words)
	{
		 //System.out.println(word);
		 //flag = 0;
		 boolean number = false,alpha = false;
		 
		 
		 for (char c : word.toCharArray()) 
		 {
	            if (Character.isLetter(c)) 
	            {
	                alpha = true;
	            }
	            else
	            {
	            	alpha = false;
	            	
	            }
		 } 
		 for (char c : word.toCharArray()) 
		 {
	            if (Character.isDigit(c)) 
	            {
	                number = true;
	            }
	            else
	            {
	            	number = false;
	            	//break;
	            }
		 }
		 
		
		 
		 if(alpha)
		 {
			 opkey = new Text(word.toUpperCase().trim());
		 }
		 if(number == true && flag == 0)
		 {
			 prv = word;
			 flag = 1;
			 continue;
		 }
		 if(number == true && flag == 1)
		 {
			 if(flag == 1)
			 {
				int a = Integer.parseInt(prv);
				int b = Integer.parseInt(word);
				yes = b - a;
				//System.out.println(prv);
				//System.out.println(word);
				IntWritable opvalue = new IntWritable(yes);
				con.write(opkey,opvalue);
				flag = 0;
			 }
		 }
		
	}


}
}
public static class ReduceForWordCount extends Reducer<Text, IntWritable, Text, IntWritable>

{
	int sum = 0,max= 0;
	Text temp = new Text();
	public void reduce(Text word, Iterable<IntWritable> values, Context con) throws IOException, InterruptedException
	
	{
	
	
	
	   for(IntWritable value : values)
	
	   {
	
	   sum += value.get();
	
	   }
	   
	  
	   if(sum >= max)
	   {
		   max = sum;
		   temp.set(word);
	   }
	
	   sum = 0;
	   
	
	}
	//cleanup
	protected void cleanup(Context con) throws IOException,InterruptedException 
	{
		Text opkey = new Text("USER\tTIME");
		   con.write(opkey, new IntWritable());
		   con.write(temp, new IntWritable(max));
	}

}

}