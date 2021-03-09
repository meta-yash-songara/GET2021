package com.metacube.LinkedListRotation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RotationTest {
	
	@Test
	public void testRotationMethod(){
		
		Rotation rotation = new Rotation();
		
		for(int i = 2; i <=7; i++)
			rotation.insertNewData(i);
		
		rotation.getList();
		
		rotation.rotateSubList(2, 5, 2);
		
		String res = rotation.getList();
		
		assertEquals("2, 5, 6, 3, 4, 7, ", res);
		
	}

}
