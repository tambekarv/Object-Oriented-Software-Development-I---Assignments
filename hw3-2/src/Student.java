
/*Vinit R. Tambekar
 *Std ID 01574978
 * CS680 Homework 3
 * solution alternative design 2 */
public class Student {

	private String name;
	private StudentStatus status;

	public Student(StudentStatus status, String name)
	{
		this.status = status;
		this.name = name;
		
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
	Student s1 = new Student(new InState(1000),"Kirk");
	System.out.println(s1.getTuition());
	System.out.println(s1.getName());
	
	Student s2 = new Student(new OutState(2000),"James");
	System.out.println(s2.getTuition());
	System.out.println(s2.getName());

	Student s3 = new Student(new Intl(3000),"Vinit");
	System.out.println(s3.getTuition());
	System.out.println(s3.getName());


}

}
