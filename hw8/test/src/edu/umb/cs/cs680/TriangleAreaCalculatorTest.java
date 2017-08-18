package edu.umb.cs.cs680;
import java.awt.Point;
import java.util.ArrayList;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class TriangleAreaCalculatorTest {

	private ArrayList<Point> points;
	
	@Test
	public void testGetArea()
	{
		points = new ArrayList<Point>();
		points.add(new Point(2,2));
		points.add(new Point(2,5));
		points.add(new Point(5,5));
		
		TriangleAreaCalculator t = new TriangleAreaCalculator();
		//Polygon p = new Polygon(points, t);
		double expected = 4.5;
		double actual = t.getArea(points);
		assertThat(actual, is(expected));
	}
}
