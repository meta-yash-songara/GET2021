package com.example.search;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SearchTest {
	
	@Test
	public void performLinearSearch(){
		Search search = new Search();
		
		int[] arr = new int[]{12, 78, 56, 98, 34, 67};
		
		search.start = 0;
		search.end = arr.length - 1;
		
		int res = search.linearSearch(arr, 56);
		assertEquals(2, res);
	}
	
	@Test
	public void performBinarySearch(){
		Search search = new Search();
		
		int[] arr = new int[]{12, 23, 34, 45, 56, 67, 78, 89, 90};
		
		search.start = 0;
		search.end = arr.length - 1;
		
		int res = search.linearSearch(arr, 56);
		assertEquals(4, res);
	}
}
