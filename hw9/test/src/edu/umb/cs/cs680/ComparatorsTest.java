package edu.umb.cs.cs680;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class ComparatorsTest {

	ArrayList<Car>usedCars = new ArrayList<Car>();
	
	public void setup()
	{
		Car c1 = new Car(1000, 1, 20);
		Car c2 = new Car(2000, 3, 15);
		Car c3 = new Car(1500, 2, 18);
		Car c4 = new Car(800, 5, 13);
		Car c5 = new Car(2500, 1, 17);

		usedCars.add(c1);
		usedCars.add(c2);
		usedCars.add(c3);
		usedCars.add(c4);
		usedCars.add(c5);
	}
	
	@Test
	public void testMilageComparator()
	{
		setup();
		ByteArrayOutputStream bOutput = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bOutput));
		Collections.sort(usedCars, new MilageComparator());
		System.out.println("This is Milage Comparator\n");
		for(int i=0;i<usedCars.size();i++)
		{
			System.out.println(usedCars.get(i).getMilage());
		}
		String expected = "This is Milage Comparator\n\n"
		+"20.0\n"
				+"18.0\n"
		+"17.0\n"
				+"15.0\n"
		+"13.0\n"; 
		assertThat(bOutput.toString(),is(notNullValue()));
	}
	
	@Test
	public void testPriceComparator()
	{
		setup();
		ByteArrayOutputStream bOutput = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bOutput));
		Collections.sort(usedCars, new PriceComparator());
		System.out.println("This is Price Comparator in descending order\n");
		for(int i=0;i<usedCars.size();i++)
		{
			System.out.println(usedCars.get(i).getPrice());
		}
		String expected = "This is Price Comparator in descending order\n\n"
		+"2500\n"
				+"2000\n"
		+"1500\n"
				+"1000\n"
		+"800\n"; 
		assertThat(bOutput.toString(),is(notNullValue()));
	}
	
	@Test
	public void testYearComparator()
	{
		setup();
		ByteArrayOutputStream bOutput = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bOutput));
		Collections.sort(usedCars, new YearComparator());
		System.out.println("This is Year Comparator\n");
		for(int i=0;i<usedCars.size();i++)
		{
			System.out.println(usedCars.get(i).getYear());
		}
		String expected = "This is Year Comparator\n\n"
		+"1\n"
				+"1\n"
		+"2\n"
				+"3\n"
		+"5\n"; 
		assertThat(bOutput.toString(),is(notNullValue()));
	}


}
