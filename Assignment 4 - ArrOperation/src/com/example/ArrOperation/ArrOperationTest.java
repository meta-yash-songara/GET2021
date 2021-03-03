package com.example.ArrOperation;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class ArrOperationTest {

	@Test
	public void checkMaxMirrorFunction(){
		ArrOperation arrOperation = new ArrOperation();
		int result = arrOperation.maxMirror(new int[] {1, 2, 3, 8, 9, 3, 2, 1});
		assertEquals(3, result);
	}
	
	@Test
	public void checkCountClumpsFunction(){
		ArrOperation arrOperation = new ArrOperation();
		int result = arrOperation.countClumps(new int[] {1, 2, 2, 3, 4, 4});
		assertEquals(2, result);
	}
	
	@Test
	public void checkFixXYFunction(){
		ArrOperation arrOperation = new ArrOperation();
		int[] result = arrOperation.fixXY(new int[] {5, 4, 9, 4, 9, 5}, 4, 5);
		assertEquals(Arrays.toString(new int[] {9, 4, 5, 4, 5, 9}), Arrays.toString(result));
	}
	
	@Test
	public void checkSplitArrayFunction(){
		ArrOperation arrOperation = new ArrOperation();
		int result = arrOperation.splitArray(new int[] {1, 1, 1, 2, 1});
		assertEquals(3, result);
	}
	
}
