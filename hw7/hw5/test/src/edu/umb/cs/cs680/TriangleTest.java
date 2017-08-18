package edu.umb.cs.cs680;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TriangleTest {
private List<Point>Tpoints;
	@Test
	public void testPoints()
	{
		this.Tpoints = new ArrayList<Point>();
		
		Point point1 = new Point(10,10);
		Point point2 = new Point(15,35);
		Point point3 = new Point(30,20);
		
		Tpoints.add(0, point1);
		Tpoints.add(1, point2);
		Tpoints.add(2, point3);
		
		Triangle triangle = new Triangle(point1, point2, point3);
		List<Point> expected = Tpoints;
		List<Point> actual = triangle.getPoints();
		assertThat(actual, is(expected));
		
	}
	
	@Test
	public void testArea()
	{
		Point point1 = new Point(10,10);
		Point point2 = new Point(15,35);
		Point point3 = new Point(30,20);
	
		Triangle tr = new Triangle(point1,point2,point3);
		double expected = 225.00000000000014;
		double actual = tr.getArea();
		assertThat(actual, is(expected));
	
	}
	
	
}
