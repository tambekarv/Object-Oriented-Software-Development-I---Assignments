package edu.umb.cs.cs680;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;

public class RectangleAreaCalculatorTest {
	 
	private ArrayList<Point> points;
	
	@Test
	public void testGetArea()
	{
		points = new ArrayList<Point>();
		points.add(new Point(2,2));
		points.add(new Point(2,5));
		points.add(new Point(5,5));
		points.add(new Point(5,2));
		
		RectangleAreaCalculator r = new RectangleAreaCalculator();
		//Polygon p = new Polygon(points, r);
		double expected = 9;
		double actual = r.getArea(points);
		assertThat(actual, is(expected));
	}
	
}
