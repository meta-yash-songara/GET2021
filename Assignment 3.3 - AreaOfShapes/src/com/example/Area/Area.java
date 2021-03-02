package com.example.Area;

public class Area {
	
	public double triangleArea(double base, double height){
		try{
			double area = (base * height) / 2;
			return area;
		}catch(ArithmeticException e){
			System.out.println("Arithmetic Exception Caught !!!");
		}
		
		return 0.0;
	}
	
	public double rectangleArea(double width, double height){
		try{
			double area = width * height;
			return area;
		}catch(ArithmeticException e){
			System.out.println("Arithmetic Exception Caught !!!");
		}
		
		return 0.0;
	}
	
	public double squareArea(double side){
		try{
			double area = Math.pow(side, 2);
			return area;
		}catch(ArithmeticException e){
			System.out.println("Arithmetic Exception Caught !!!");
		}
		
		return 0.0;
	}

	public double circleArea(double radius){
		try{
			double area = 3.14 * radius * radius;
			return area;
		}catch(ArithmeticException e){
			System.out.println("Arithmetic Exception Caught !!!");
		}
		
		return 0.0;
	}

}
