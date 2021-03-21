package com.metacube.CompoundMassFinder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MassFinderTest {

	@Test
	public void testMassFinderMethod(){
		
		CompoundMassFinder massFinder = new CompoundMassFinder();
		
		assertEquals(46, massFinder.getCompoundMass("C(OH)2"));
		
		assertEquals(86, massFinder.getCompoundMass("CHOC(CH3)3"));
		
	}
	
}
