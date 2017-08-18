package edu.umb.cs.cs680;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class SavingsAccountTest {
	@Test
	public void testSavingsAccount()
	{
		float balance = 5000;
		SavingsAccount s1 = new SavingsAccount(balance);
		float expected = 5000;
		float actual = s1.getBalance();
		assertThat(actual, is(expected));
	}
	@Test
	public void testSavingsWithdrawl()
	{
		float balance = 5000;
		SavingsAccount s2 = new SavingsAccount(balance);
		float expected = 2000;
		float actual = s2.withdrawl(3000);
		assertThat(actual, is(expected));
	}
	@Test
	public void testInsufficientFunds()
	{
		float balance = 5000;
		SavingsAccount s3 = new SavingsAccount(balance);
		float expected = 0;
		float actual = s3.withdrawl(15000);
		assertThat(actual, is(expected));
	}	


}
