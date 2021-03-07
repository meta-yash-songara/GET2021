package com.metacube.ShapeMaker;

import java.util.ArrayList;
import java.util.List;

public class Screen {
	
	List<Shape> shapes = new ArrayList<Shape>();
	
	public void addShape(Shape shape){
		shapes.add(shape);
	}
	
	public void removeShape(int shapeId){
		
		if(shapes.size() == 0)
			System.out.println("No shapes available to delete.");
		
		for(int i = 0; i < shapes.size(); i++)
			if(shapes.get(i).getShapeId() == shapeId){
				shapes.remove(i);
			}
		
	}
	
	public void removeAllShapesOf(String shapeName){
		
		shapeName = shapeName.toUpperCase();
		Shape.ShapeType shapeType = Shape.ShapeType.valueOf(shapeName);
		
		if(shapes.size() == 0)
			System.out.println("No shapes available to delete.");
		
		for(int i = 0; i < shapes.size(); i++)
			if(shapes.get(i).getShapeType() == shapeType){
				shapes.remove(i);
			}
		
	}
	
	public List<Shape> accendingArea(){
		
		for(int i = 0; i < shapes.size(); i++)
			for(int j = 0; j < (shapes.size() - i - 1); j++)
				if(shapes.get(j).getArea() > shapes.get(j + 1).getArea()){
					
					Shape tempShape = shapes.get(j);
					shapes.set(j, shapes.get(j + 1));
					shapes.set(j + 1, tempShape);	
					
				}
		
		return shapes;
		
	}
	
	public List<Shape> accendingPeri(){
		
		for(int i = 0; i < shapes.size(); i++)
			for(int j = 1; j < (shapes.size() - i); j++)
				if(shapes.get(j - 1).getPerimeter() > shapes.get(j).getPerimeter()){
					
					Shape tempShape = shapes.get(j - 1);
					shapes.set(j - 1, shapes.get(j));
					shapes.set(j, tempShape);	
					
				}
		
		return shapes;
		
	}
	
	public List<Shape> isEnclosingPoint(Point p){
		
		List<Shape> result = new ArrayList<Shape>();
		
		for(int i = 0; i < shapes.size(); i++){
			Shape shape = shapes.get(i);
			
			if(shape.isPointEnclosed(p))
				result.add(shape);
		}
		
		return result;
		
	}

}
