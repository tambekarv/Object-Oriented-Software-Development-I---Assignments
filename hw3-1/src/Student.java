/*Vinit R. Tambekar
 *Std ID 01574978
 * CS680 Homework 3
 * solution alternative design 1 */

public class Student {

	float tuition;
	String name;
	private StudentStatus status;
	//private StudentStatus status;

public Student (StudentStatus status, String name){
	
	this.name = name;
	this.status = status;
}

public float getTuition()
{
	return status.getTuition();
}

public String getName()
{
	return name;
}


public static void main(String args[])
{
   
   Student s1 = new Student(StudentStatus.INSTATE, "Kirk");
   System.out.println(s1.getName());
   System.out.println( s1.getTuition());
   
   Student s2 = new Student(StudentStatus.OUTSTATE, "James");
   System.out.println(s2.getName());
   System.out.println( s2.getTuition());
   
   Student s3 = new Student(StudentStatus.INTL, "Vinit");
   System.out.println(s3.getName());
   System.out.println( s3.getTuition());
   
}


}
