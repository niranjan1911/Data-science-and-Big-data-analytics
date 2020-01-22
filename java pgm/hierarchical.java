
class base 
{
	void display()
	{
		System.out.println("\nyou are calculating the area");
		
	}
}
class derived extends base
{
	void area(int s)
	{
		System.out.println("\nSquare:");
		System.out.println(s*s);
		
	}
}
class third extends base
{
	void area(int l,int b)
	{
		System.out.println("\nRectangle:");
		System.out.println(l*b);
		
	}
}
public class hierarchical
{
    public static void main(String args[])
    {
    	derived d=new derived();
    	d.area(4);
    	
    	third t=new third();
    	t.area(3,5);
    	
    	
    }
}
