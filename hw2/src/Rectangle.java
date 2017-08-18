import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class Rectangle implements Polygon{
private double width,height;
private List<Point> points;
	
public Rectangle(Point point1, Point point2, Point point3,Point point4)
{
	
	this.points = new ArrayList<Point>(4);

	points.add(point1);
	points.add(point2);
	points.add(point3);
	points.add(point4);


}


public List<Point> getPoints() 
		{
	System.out.println("Points of Rectangle are");	
	return this.points;
		
		}

	public double getArea() 
	
	{
	
		//Calculating sides using distance formula
		
		width = (double) Math.sqrt((Math.pow(points.get(0).getX()-points.get(1).getX(),2))+(Math.pow(points.get(0).getY()-points.get(1).getY(), 2)));	
		height = (double) Math.sqrt((Math.pow(points.get(1).getX()-points.get(2).getX(),2))+(Math.pow(points.get(1).getY()-points.get(2).getY(), 2)));
	
		System.out.println("Area of Rectangle is");
		
		//calculating area of rectangle
	    
		return width * height;
		
		
	}

}
