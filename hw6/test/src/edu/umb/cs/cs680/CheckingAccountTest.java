package edu.umb.cs.cs680;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class CheckingAccountTest 
{
	@Test
	public void testCheckingAccount()
	{
		float balance = 8000;
		CheckingAccount check = new CheckingAccount(balance);
		float expected = 8000;
		float actual = check.getBalance();
		assertThat(actual, is(expected));
	}
	@Test
	public void testWithdrawl_Normal()
	{
		float balance = 8000;
		CheckingAccount c = new CheckingAccount(balance);
		float expected = 6000;
		float actual = c.withdrawl(2000);
		assertThat(actual, is(expected));
	}
	@Test
	public void testWithdrawl_WithPenalty()
	{
		float balance = 8000;
		CheckingAccount c1 = new CheckingAccount(balance);
	//	SavingsAccount s1 = new SavingsAccount(5000);
		float expected = -2050;
		float actual = c1.withdrawl(10000);
		assertThat(actual, is(expected));
	}
	@Test
	public void testWithdrawl_NoFunds()
	{
		float balance = 8000;
		CheckingAccount c2 = new CheckingAccount(balance);
	//	SavingsAccount s2 = new SavingsAccount(5000);
		float expected = 0;
		float actual = c2.withdrawl(15000);
		assertThat(actual, is(expected));
	}
}
