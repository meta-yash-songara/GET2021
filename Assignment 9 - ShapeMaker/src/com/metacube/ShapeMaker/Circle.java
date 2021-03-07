package com.metacube.ShapeMaker;

public class Circle implements Shape {

	private int radius;
	private Point point;
	private int shapeId;

	public Circle(int radius, Point point, int id) {
		// TODO Auto-generated constructor stub
		this.point = point;
		this.radius = radius;
		shapeId = id;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub

		double area = (22 * radius * radius) / 7;

		return area;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub

		double perimeter = (22 * 2 * radius) / 7;

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
		
		int[] centerPointCoordinates = getCircleCenter();
		
		int length = (int) (Math.sqrt((centerPointCoordinates[0] - p.x) * (centerPointCoordinates[0] - p.x)
				+ (centerPointCoordinates[1] - p.y) * (centerPointCoordinates[1] - p.y)));
		
		if(length <= radius)
			return true;
		
		return false;
	}
	
	public int[] getCircleCenter(){
		
		int originLength = (int) (Math.sqrt(point.x * point.x + point.y * point.y));
		int centerLength = originLength + radius;
		int[] centerCoordinates = new int[2];
		
		centerCoordinates[0] = (centerLength * point.x) / originLength;
		centerCoordinates[1] = (centerLength * point.y) / originLength;
		
		return centerCoordinates;
	}

	@Override
	public int getShapeId() {
		// TODO Auto-generated method stub
		return shapeId;
	}

	@Override
	public ShapeType getShapeType() {
		// TODO Auto-generated method stub
		return ShapeType.CIRCLE;
	}

}
