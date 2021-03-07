package com.metacube.ShapeMaker;

public class Rectangle implements Shape{
	
	private int lenght, width;
	private Point point;
	private int shapeId;
	
	public Rectangle(int l, int w, Point p, int id) {
		// TODO Auto-generated constructor stub
		lenght = l;
		width = w;
		point = p;
		shapeId = id;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		
		double area = lenght * width;
		
		return area;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		
		double perimeter = 2 * (lenght + width);
		
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
		
		if(p.x >= point.x && p.x <= (point.x + width) &&
				p.y >= point.y && p.y <= (point.y + lenght))
			return true;
		
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
		return ShapeType.RECTANGLE;
	}

	

}
