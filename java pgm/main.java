
class base 
{
	
	int a=10;
	void display()
	{
		System.out.println("\nyou are in base class:"+a);
		
	}
}
class derived extends base
{
	int b=a+1;
    void display1()
    {
    	System.out.println("\nyou are in derived class:"+b);
    }
}
public class main 
{
    public static void main(String args[])
    {
    	derived d= new derived();
    	d.display();
    	d.display1();
    }
}

