package com.metacube.UniqueChar;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UniqueCharTest {

	@Test
	public void testUniqueCharacterCount(){
		
		UniqueChar uniqueChar = new UniqueChar();
		
		assertEquals(11, uniqueChar.getUniqueCharCount("metacube jaipur"));
		
	}
	
}
