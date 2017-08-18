package edu.umb.cs.cs680;
import java.awt.Point;
import java.util.ArrayList;

public class RectangleAreaCalculator implements AreaCalculator {

	@Override
	public float getArea(ArrayList<Point> points) {
		
		double width = (double) Math.sqrt((Math.pow(points.get(0).getX()-points.get(1).getX(),2))+(Math.pow(points.get(0).getY()-points.get(1).getY(), 2)));	
		double height = (double) Math.sqrt((Math.pow(points.get(1).getX()-points.get(2).getX(),2))+(Math.pow(points.get(1).getY()-points.get(2).getY(), 2)));
	
		return (float) (width * height);
	}

}
