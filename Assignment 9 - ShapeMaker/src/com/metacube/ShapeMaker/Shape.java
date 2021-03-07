package com.metacube.ShapeMaker;

public interface Shape {
	
	public static int shapeId = 0;
	
	enum ShapeType{
		CIRCLE, TRIANGLE, RECTANGLE;
	}
	
	public double getArea();
	public double getPerimeter();
	public Point getOrigin();
	public boolean isPointEnclosed(Point p);
	public int getShapeId();
	public ShapeType getShapeType();

}
