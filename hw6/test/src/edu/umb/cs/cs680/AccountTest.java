package edu.umb.cs.cs680;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
public class AccountTest 
{
	@Test
	public void testBalance()
	{
		Account a = new Account();
		float expected = 0;
		float actual = a.getBalance();
		assertThat(actual, is(expected));
	}
	@Test
	public void testDeposit()
	{
		Account b = new Account();
		float expected = 8000;
		float actual = b.deposite(8000);
		assertThat(actual, is(expected));
	}
	@Test 
	public void testWithdrawl()
	{
		Account c = new Account();
		float expected = 0;
		float actual = c.withdrawl(0);
		assertThat(actual, is(expected));
	}
}

