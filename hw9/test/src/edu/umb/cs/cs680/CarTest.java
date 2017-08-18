package edu.umb.cs.cs680;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class CarTest {

	@Test
	public void testConstructor()
	{
		Car c1 = new Car(3000, 4, 14);
		int expectedPrice = 3000;
		int actualPrice = c1.getPrice();
		
		int expectedYear = 4;
		int actualYear = c1.getYear();
		
		float expectedMilage = 14;
		float actualMilage = c1.getMilage();
	
		assertThat(actualPrice, is(expectedPrice));
		assertThat(actualYear, is(expectedYear));
		assertThat(actualMilage, is(expectedMilage));
	}
}
