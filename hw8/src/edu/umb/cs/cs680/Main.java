package edu.umb.cs.cs680;
import java.awt.Point;
import java.util.ArrayList;

public class Main {
	public static void main(String args[])
	{
		ArrayList<Point> al = new ArrayList<Point>();
		al.add(new Point(2,2));
		al.add(new Point(2,5));
		al.add(new Point(5,5));
		
		Polygon p = new Polygon(al,new TriangleAreaCalculator());
		System.out.println("Area of traingle is");
		System.out.println(p.getArea());
		
		p.addPoint(new Point(5,2));
		p.setAreaCalc(new RectangleAreaCalculator());
		System.out.println("Area of rectangle is");
		System.out.println(p.getArea());
	}
	
	

}
