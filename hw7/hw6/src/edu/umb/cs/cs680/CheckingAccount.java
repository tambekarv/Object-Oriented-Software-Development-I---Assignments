package edu.umb.cs.cs680;
import java.lang.IllegalArgumentException;
public class CheckingAccount extends Account 
{
	private float balance;
	SavingsAccount s = new SavingsAccount(5000);

	public CheckingAccount(float balance)
	{
		this.balance = balance;
	}
	public float getBalance()
	{
		return balance;
	}
	public float withdrawl(float w)
	{
		if(this.getBalance() > w)
		{
			balance = balance - w;
			return balance;
		}
		if(/*this.getBalance() < w  && */  s.getBalance() + this.getBalance() >= w)
		{
			balance = balance - (50 + w);
			return balance;
		}
	//	if(s.getBalance() + this.getBalance() < w)
		else
		{
			System.out.println("Insufficient funds in checking account");
			//String str = "Insufficient funds in checking account";
			return 0;
		}
		//return balance;
	}
}