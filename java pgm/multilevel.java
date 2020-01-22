
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
class third extends derived
{
	int c1=b+1;
	int c2=c1+1;
	

    void display2()
    {
    	System.out.println("\nyou are in third class:"+c1);
    	System.out.println("\nyou are in third class:"+c2);
    }	
}
public class multilevel
{
    public static void main(String args[])
    {
    	third t=new third();
    	t.display();
    	t.display1();
    	t.display2();
    }
}
