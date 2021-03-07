package com.metacube.ShapeMaker;

public class Triangle implements Shape{
	
	private int a, b, c; // three sides of triangle
	private Point point;
	private int shapeId;
	
	public Triangle(int a, int b, int c, Point p, int id) {
		// TODO Auto-generated constructor stub
		this.a = a;
		this.b = b;
		this.c = c;
		point = p;
		shapeId = id;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		
		double perimeter = getPerimeter();
		
		double area = perimeter * (perimeter - a) * (perimeter - b) * (perimeter - c);
		
		return Math.pow(area, 0.5);
	}	

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		double perimeter = a + b + c;
		
		return perimeter;
	}

	@Override
	public Point getOrigin() {
		// TODO Auto-generated method stub
		return point;
	}

	@Override
	public boolean isPointEnclosed(Point p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getShapeId() {
		// TODO Auto-generated method stub
		return shapeId;
	}

	@Override
	public ShapeType getShapeType() {
		// TODO Auto-generated method stub
		return ShapeType.TRIANGLE;
	}

}
