package edu.umb.cs.cs680;
import java.lang.IllegalArgumentException;
public class Account
{
	protected float balance;
	
	public float getBalance()
	{
		return this.balance;
	}
	
	public float deposite(float d)
	{
		return this.balance += d;
		
	}
	
	public float withdrawl(float w)
	{
		return 0;
	
	}
	
	public static void main(String args[])
	{
		SavingsAccount s = new SavingsAccount(5000);
		s.withdrawl(2000);
		System.out.println(s.getBalance());
		
		SavingsAccount s1 = new SavingsAccount(5000);
		s1.withdrawl(7000);
		System.out.println(s1.getBalance());
		
		CheckingAccount a = new CheckingAccount(8000);
		a.withdrawl(2000);
		System.out.println("normal case");
		System.out.println(a.getBalance());
	
		CheckingAccount b = new CheckingAccount(8000);
		b.withdrawl(9000);
		System.out.println("penalty 50$");
		System.out.println(b.getBalance());
	
		CheckingAccount c = new CheckingAccount(8000);
		c.withdrawl(14000);
		System.out.println("no funds");
		System.out.println(c.getBalance());
	
	}
	
}
