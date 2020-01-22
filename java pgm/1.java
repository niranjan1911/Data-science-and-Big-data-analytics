import java.io.*;
import java.io.IOException;

class test
{
	int id;
    String name;
    void getdata()
    {
    	System.out.println("Enter the id and the name");
    	//Enter data using BufferReader 
        BufferedReader br =  
                   new BufferedReader(new InputStreamReader(System.in));
       
    	try {
			id=br.read();
			name=br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception....");
		}
//---------------------------------------------------------
    	//Please do it with scanner instead of buffered reader
//------------------------------------------------------------
    }
    void putdata()
    {
    	System.out.println("\nID:" + id + " "+"\nName" + name);
    }
}
class Sample{
  public static void main(String args[])
  {
	 test t=new test();
	 t.getdata();
 	
 	
 	
	 t.putdata();
  }
}

