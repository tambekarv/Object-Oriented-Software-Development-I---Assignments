package edu.umb.cs.cs680;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class Triangle implements Polygon {
private double side1,side2,side3;
private List<Point> points;
	
	

	public Triangle(Point point1, Point point2, Point point3) 
	{
	
	this.points = new ArrayList<Point>(3);
	
	points.add(point1);
	points.add(point2);
	points.add(point3);
	
	}

	public List<Point> getPoints() {
		
		System.out.println("Points of Triangle are");	
		return this.points; 
	}

	public double getArea() 
	{
		
	//Calculating sides using distance formula
		
		
		side1 = (double) Math.sqrt((Math.pow(points.get(0).getX()-points.get(1).getX(),2))+(Math.pow(points.get(0).getY()-points.get(1).getY(), 2)));
		side2 = (double) Math.sqrt((Math.pow(points.get(1).getX()-points.get(2).getX(),2))+(Math.pow(points.get(1).getY()-points.get(2).getY(), 2)));
		side3 = (double) Math.sqrt((Math.pow(points.get(0).getX()-points.get(2).getX(),2))+(Math.pow(points.get(0).getY()-points.get(2).getY(), 2)));
		
		System.out.println("Area of Triangle is");
		
		//calculating area using Heron's formula 
		
		double S = (side1+side2+side3)/2;
	    return (double) Math.sqrt(S*(S-side1)*(S-side2)*(S-side3));
	
	}


	
	}
	