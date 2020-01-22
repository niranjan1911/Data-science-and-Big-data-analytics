class Student
{  
	 int rollno;  
	 String name;  
	 void insertRecord(int r, String n){  
	  rollno=r;  
	  name=n;  
	 }  
	 void displayInformation(){System.out.println(rollno+" "+name);}  
}  
class Sample
{  
	 public static void main(String args[])
	 {  
		  Student s1=new Student(),s2=new Student();//two objects in one tape  
	
		  s1.insertRecord(111,"Karan");
		  s2.insertRecord(222,"Aryan");  
		  s1.displayInformation();  
		  s2.displayInformation();  
	 }  
}  
