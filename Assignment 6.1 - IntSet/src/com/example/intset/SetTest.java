package com.example.intset;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class SetTest {

	@Test
	public void checkIsMemberFunction(){
		IntSet intSet = new IntSet(new int[] {2,4,6,8,90});
		boolean result = intSet.isMember(3);
		assertEquals(false, result);
	}
	
	@Test
	public void checkSizeFunction(){
		IntSet intSet = new IntSet(new int[] {2,4,6,8,90});
		int result = intSet.size();
		assertEquals(5, result);
	}
	
	@Test
	public void checkIsSubSetFunction(){
		IntSet intSet = new IntSet(new int[] {2,4,6,8,90});
		boolean result = intSet.isSubSet(new IntSet(new int[]{4,8}));
		assertEquals(true, result);
	}

	@Test
	public void checkGetComplementFunction(){
		int[] evenSet = new int[500];
		for(int i = 2, j = 0; j < 500; i += 2, j++)
			evenSet[j] = i;
		
		int[] oddSet = new int[500];
		for(int i = 1, j = 0; j < 500; i += 2, j++)
			oddSet[j] = i;
		
		IntSet intSet = new IntSet(evenSet);
		int[] result = intSet.getComplement();
		assertEquals(Arrays.toString(oddSet), Arrays.toString(result));
	}

	@Test
	public void checkUnionFunction(){
		IntSet intSet = new IntSet();
		
		IntSet set1 = new IntSet(new int[] {2,4,6,8});
		IntSet set2 = new IntSet(new int[] {4,8,12,16});
		
		int[] expectedOutput = new int[] {2,4,6,8,12,16};
		
		int[] result = intSet.union(set1, set2);
		assertEquals(Arrays.toString(result), Arrays.toString(expectedOutput));
	}
}
