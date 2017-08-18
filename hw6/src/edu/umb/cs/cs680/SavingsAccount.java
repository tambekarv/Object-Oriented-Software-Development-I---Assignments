package edu.umb.cs.cs680;

public class SavingsAccount extends Account
{
	private float balance;

	public SavingsAccount(float balance) 
	{
		this.balance = balance;
	}

	public float getBalance()
	{
		return balance;
	}
	public float withdrawl(float w)
	{
		if ((this.getBalance()) - w < 0)
		{
			return 0;
		}
		
		return (balance - w); 
		/*if(this.getBalance()-w >= 0)
		{
			balance = balance - w;
			return balance;
		}
	//	if(this.getBalance() < w)
		else
		{
			System.out.println("Insufficient funds in savings account");	
			return 0;
		}*/
	//return balance;
	}
}