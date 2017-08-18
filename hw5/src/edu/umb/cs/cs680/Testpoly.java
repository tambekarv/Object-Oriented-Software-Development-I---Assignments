package edu.umb.cs.cs680;

import java.awt.Point;
import java.util.*;
public class Testpoly {

	public static void main(String args[]){
	
		ArrayList<Polygon> p = new ArrayList<Polygon>();
		p.add(new Triangle(new Point(10,10),
						   new Point(15,35),
						   new Point(30,20)));
		
		p.add(new Triangle(new Point(15,15),
				   new Point(15,30),
				   new Point(30,30)));
		
		p.add(new Rectangle(new Point(5,5), 
			                new Point(5,30),
			                new Point(25,30),
			                new Point(25,5)));
		
		p.add(new Rectangle(new Point(10,10), 
                new Point(10,25),
                new Point(35,25),
                new Point(35,10)));
		
		Iterator<Polygon>it = p.iterator();
		
		while(it.hasNext())
		{
		Polygon NextP = it.next();
		System.out.println(NextP.getPoints());
		System.out.println( NextP.getArea() );
		}
	
	}

}
