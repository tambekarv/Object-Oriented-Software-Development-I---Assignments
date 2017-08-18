package edu.umb.cs.cs680;
import java.util.Comparator;

public class MilageComparator implements Comparator<Car>{

	@Override
	public int compare(Car car1, Car car2) 
	{
		return (int) (car2.getMilage() - car1.getMilage());
	}

}
