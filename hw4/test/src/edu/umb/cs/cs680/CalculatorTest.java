package edu.umb.cs.cs680;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class CalculatorTest 
{
	
	@Test
	public void multiply3By4()
	{
	  Calculator cut = new Calculator();
	  float expected = 12;
	  float actual = cut.multiply(3,4);
	  assertThat(actual, is(expected));
	}
	
	@Test
	public void multiply2_5by2_5()
	{
		Calculator cut = new Calculator();
		float expected = 6_25;
		float actual = cut.multiply(2_5,2_5);
		assertThat(actual, is(expected));
	}
	
	@Test
	public void divide3By2()
	{
		Calculator cut = new Calculator();
		float expected = 1.5f;
		float actual = cut.divide(3,2);
		assertThat(actual, is(expected)); 
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void divide5By0()
	{
		Calculator cut = new Calculator();
		cut.divide(5,0); 
	}
	
	@Test
	public void divide6_25by2_5()
	{
		Calculator cut = new Calculator();
		float expected = 2_5;
		float actual = cut.divide(6_25, 2_5);
		assertThat(actual, is(expected));
	}
	
	@Test
	public void multiply2_5by8_0divideby5_0() 
	{
		Calculator cut = new Calculator();
		float expected = 4_0;
		float partial = cut.multiply(2_5, 8_0);
		float actual = cut.divide(partial, 5_0);
		assertThat(actual, is(expected));
	}
}
