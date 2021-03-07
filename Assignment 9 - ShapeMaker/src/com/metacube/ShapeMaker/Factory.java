package com.metacube.ShapeMaker;

import java.util.List;

import com.metacube.ShapeMaker.Shape.ShapeType;

public class Factory {
	
	static int id = 0;
	
	public Shape createShape(String shapeType, Point point, List<Integer> list){
		
		Enum ShapeName = Enum.valueOf(ShapeType.class, shapeType.toUpperCase());
		
		if(ShapeName == null)
			return null;
		
		if(ShapeName == ShapeType.CIRCLE)
			return new Circle(list.get(0), point, id++);
		else if(ShapeName == ShapeType.RECTANGLE)
			return new Rectangle(list.get(0), list.get(1), point, id++);
		else if(ShapeName == ShapeType.TRIANGLE)
			return new Triangle(list.get(0), list.get(1), list.get(2), point, id++);
		
		return null;
		
	}

}
