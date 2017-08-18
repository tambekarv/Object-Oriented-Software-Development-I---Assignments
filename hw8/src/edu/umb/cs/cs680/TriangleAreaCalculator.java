package edu.umb.cs.cs680;
import java.awt.Point;
import java.util.ArrayList;

public class TriangleAreaCalculator implements AreaCalculator {

	@Override
	public float getArea(ArrayList<Point> points) {
	
		double side1 = (double) Math.sqrt((Math.pow(points.get(0).getX()-points.get(1).getX(),2))+(Math.pow(points.get(0).getY()-points.get(1).getY(), 2)));
		double side2 = (double) Math.sqrt((Math.pow(points.get(1).getX()-points.get(2).getX(),2))+(Math.pow(points.get(1).getY()-points.get(2).getY(), 2)));
		double side3 = (double) Math.sqrt((Math.pow(points.get(0).getX()-points.get(2).getX(),2))+(Math.pow(points.get(0).getY()-points.get(2).getY(), 2)));
				
		double S = (side1+side2+side3)/2;
	    return (float) Math.sqrt(S*(S-side1)*(S-side2)*(S-side3));
	
	}



}
