package com.metacube.DetectLoop;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DetectLoopTest {

	@Test
	public void testDetectLoopMethod(){
		
		DetectLoop detectLoop = new DetectLoop();
		
		for(int i = 2; i <=9; i++)
			detectLoop.insertNewData(i);
		
		detectLoop.createLoopAt(4);
		
		assertEquals(true, detectLoop.detectLoop());
		
	}
	
}
