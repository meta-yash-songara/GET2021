package com.example.Area;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AreaTest {

	@Test
	public void testTriangleArea(){
		Area area = new Area();
		double result = area.triangleArea(8.7, 5.9);
		assertEquals(25.665, result, 1);
	}

	@Test
	public void testRectangleArea(){
		Area area = new Area();
		double result = area.rectangleArea(7, 10);
		assertEquals(70.0, result, 1);
	}

	@Test
	public void testSquareArea(){
		Area area = new Area();
		double result = area.squareArea(8);
		assertEquals(64.0, result, 1);
	}

	@Test
	public void testCircleArea(){
		Area area = new Area();
		double result = area.circleArea(5);
		assertEquals(78.5, result, 1);
	}

}
