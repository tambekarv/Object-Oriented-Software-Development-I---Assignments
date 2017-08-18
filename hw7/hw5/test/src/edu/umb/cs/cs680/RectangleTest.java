package edu.umb.cs.cs680;
import static org.junit.Assert.*;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.CoreMatchers.*;
import java.lang.IllegalArgumentException;
import org.junit.Test;

public class RectangleTest{
private List<Point> points;
	
	@Test
	public void testPoints()
	{
		this.points = new ArrayList<Point>();
		
		Point point1 = new Point(10, 10);
		Point point2 = new Point(10, 25);
		Point point3 = new Point(35, 25);
		Point point4 = new Point(35, 10);
		
	    points.add(0, point1);
	    points.add(1, point2);
	    points.add(2, point3);
	    points.add(3, point4);

	    /*points.add(0, new Point(5,5));
		points.add(1, new Point(5,30));
		points.add(2, new Point(25,30));
		points.add(3, new Point(25,5));
		*/
				
		Rectangle rec1 = new Rectangle(point1,point2,point3,point4);
		List<Point> expected = points;  
		List<Point> actual = rec1.getPoints();
		assertThat(actual, is(expected));
		
	}
	
	@Test
	public void testArea()
	{   
		Point point1 = new Point(5, 5);
		Point point2 = new Point(5, 30);
		Point point3 = new Point(25, 30);
		Point point4 = new Point(25, 5);
		
		Rectangle rec = new Rectangle(point1, point2, point3, point4);
		double expected = 500;
		double actual = rec.getArea();
		assertThat(actual, is(expected));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testArea_nullPoint()
	{
		Point point2 = new Point(5, 30);
		Point point3 = new Point(25, 30);
		Point point4 = new Point(25, 5);
		
		Rectangle rectangle = new Rectangle(null, point2, point3, point4);
		double expected = 500;
		double actual = rectangle.getArea();
		assertThat(actual, is(expected));
	}	
}
