

interface vehical 
{ 
	
	void change(int bit);
	void speed1(int inc);
	void break1(int dec);
	
} 
class motor implements vehical
{
	int speed,gear;
	motor()
	{
		speed=50;
		gear=3;
		
	}
	public void change(int bit)
	{
		if(bit==0)
		{
			gear--;
		}
		else if(bit==1)
		{
			gear++;
		}
	}
	public void speed1(int inc)
	{
		speed +=inc;
	}
	public void break1(int dec)
	{
		speed -=dec;
	}
	void print()
	{
		System.out.println("speed:"+speed + "\ngear:"+gear);
	}
}


class car implements vehical
{
	int speed,gear;
	car()
	{
		speed=80;
		gear=4;
		
	}
	public void change(int bit)
	{
		if(bit==0)
		{
			gear--;
		}
		else if(bit==1)
		{
			gear++;
		}
	}
	public void speed1(int inc)
	{
		speed +=inc;
	}
	public void break1(int dec)
	{
		speed -=dec;
	}
	void print()
	{
		System.out.println("speed:"+speed + "\ngear:"+gear);
	}
}




public class interfaceeg 
{ 
	public static void main(String[] args) 
	{ 
		motor m=new motor();
		System.out.println("Bike:");
		m.print();
		System.out.println("Bike after speedUp :");
		m.speed1(20);
		m.change(1);
		//m.break1(15);
		m.print();
		
		car c=new car();
		System.out.println("Car:");		
		c.print();
		//c.speed1(30);
		c.change(0);
		c.break1(11);
		System.out.println("Car after break :");	
		c.print();
	} 
} 

