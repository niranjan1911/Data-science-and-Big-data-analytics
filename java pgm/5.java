

class Student
{  
	 int bal;
	 String name;
	 int acc;
	 Student(int a,String b,int c)
	 {
		 acc=a;
		 name=b;
		 bal=c;
		 
	 }
	 void withdraw(int remove)
	 {
		 if(remove<=bal)
		 {
			 bal=bal-remove;
		 }
		 else
		 {
			 System.out.println("\nBalence is less");
		 }
	 }
	 void deposite(int add)
	 {
			 bal=bal+add;
	 }
	 void check()
	 {
		 System.out.println("\nBalence is :"+bal);
	 }
}  
class Sample
{  
	 public static void main(String args[])
	 {  
		

		 Student s1 = new Student(1,"Niranjan",1000),s2 = new Student(2,"Swapnil",2000);
		
		 s1.check();
		 s2.check();
		 
		 System.out.println("\nBalence after deposite");
		 s1.deposite(1111);
		 s2.deposite(2222);
		 s1.check();
		 s2.check();
		 
		 System.out.println("\nBalence after withdraw");
		 s1.withdraw(888);
		 s2.withdraw(999);
		 s1.check();
		 s2.check();
	 }  
}  
