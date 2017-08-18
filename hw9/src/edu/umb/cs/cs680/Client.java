package edu.umb.cs.cs680;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Client {
		
	public static void main(String args[])
	{		
		ArrayList<Car> usedCars = new ArrayList<Car>();
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
		
		Collections.sort(usedCars, new MilageComparator());
		Iterator<Car> iterator = usedCars.iterator();
		System.out.println("This is Milage Comparator");
		while(iterator.hasNext())
		{
			System.out.println(iterator.next().getMilage());
		}

		Collections.sort(usedCars,new PriceComparator());
		System.out.println("This is Price Comparator in descending order");
		for(int i=0;i<usedCars.size();i++)
		{
			System.out.println(usedCars.get(i).getPrice());
		}
	
		Collections.sort(usedCars, new YearComparator());
		System.out.println("This is Year Comparator");
		for(Car u:usedCars)
		{
			System.out.println(u.getYear());
		}
	}
}
	/*//private MilageComparator milageComparator;

public Client(){
	//milageComparator = new MilageComparator();

}

public static void main(String args[])
{
	Client c = new Client();		
	ArrayList<Car> usedCars = new ArrayList<Car>();
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
	Collections.sort(usedCars, c.milageComparator);
Iterator<Car> iterator = usedCars.iterator();
while(iterator.hasNext())
{
	System.out.println(iterator.next().getMilage());
}
	 */