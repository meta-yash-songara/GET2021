package com.metacube.MultivariatePoly;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MultivariatePolyTest {

	@Test
	public void testGetDegreeMethod(){
		
		MultivariatePoly poly = new MultivariatePoly();
		
		poly.createTerm(3, new int[] {2, 4});
		poly.createTerm(-5, new int[] {2});
		poly.createTerm(1, new int[] {1});
		poly.createTerm(-1, new int[] {1});
		poly.createTerm(20, new int[] {});
		
		assertEquals(6, poly.getDegree());
	}
	
}
