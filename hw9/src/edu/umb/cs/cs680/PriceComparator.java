package edu.umb.cs.cs680;
import java.util.Comparator;

public class PriceComparator implements Comparator<Car>{

	@Override
	public int compare(Car car1, Car car2) 
	{
		return car2.getPrice() - car1.getPrice();
	}

}
