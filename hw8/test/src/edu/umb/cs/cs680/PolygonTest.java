package edu.umb.cs.cs680;
import java.awt.Point;
import java.util.ArrayList;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class PolygonTest 
{

	private ArrayList<Point> points;
	private TriangleAreaCalculator area = new TriangleAreaCalculator(); 
	
	@Test
	public void testConstructor()
	{	
		Polygon p = new Polygon(points, area);
		ArrayList<Point> expected = points;
		ArrayList<Point> actual = p.points;
		assertThat(actual, is(expected));
	}
	@Test
	public void testGetArea()
	{
		/*Point point1 = new Point(2,2);
		Point point2 = new Point(2,5);
		Point point3 = new Point(5,5);
		Point point4 = new Point(5,2);*/
		points = new ArrayList<Point>();
		
		points.add(new Point(2,2));
		points.add(new Point(2,5));
		points.add(new Point(5,5));
//		points.add(point4);

		TriangleAreaCalculator t = new TriangleAreaCalculator();
		Polygon p1 = new Polygon(points, t);
		double expected = 4.5;
		double actual = p1.getArea();
		assertThat(actual, is(expected));
	}

	@Test
	public void testSetAreaCalc()
	{
		
		points = new ArrayList<Point>();
		points.add(new Point(2,2));
		points.add(new Point(2,5));
		points.add(new Point(5,5));
		
		Point point1 = new Point(5,5);
		TriangleAreaCalculator t = new TriangleAreaCalculator();
		RectangleAreaCalculator r = new RectangleAreaCalculator();
		
		Polygon p2 = new Polygon(points, t);
		p2.addPoint(point1);
		p2.setAreaCalc(r);
		double expected = 9;
		double actual = p2.getArea();
		assertThat(actual, is(expected));
		
	}
}