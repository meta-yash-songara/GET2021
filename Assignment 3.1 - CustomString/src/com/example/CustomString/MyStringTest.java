package com.example.CustomString;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyStringTest {

	@Test
	public void testIsEqualMethod(){
		MyString myString = new MyString();
		int result = myString.isEqual("Metacube", "MetaCube");
		assertEquals(0, result);
	}
	
	@Test
	public void testReverseStringMethod(){
		MyString myString = new MyString();
		String result = myString.reverseString("Metacube");
		assertEquals("ebucateM", result);
	}
	
	@Test
	public void testToUpperCaseMethod(){
		MyString myString = new MyString();
		String result = myString.toUpperCase("Metacube");
		assertEquals("METACUBE", result);
	}
	
	@Test
	public void testToLowerCaseMethod(){
		MyString myString = new MyString();
		String result = myString.toLowerCase("mETAcUBE");
		assertEquals("metacube", result);
	}
	
	@Test
	public void testGetLargestWordMethod(){
		MyString myString = new MyString();
		String result = myString.getLargestWord("Metacube programmed for excellence");
		assertEquals("excellence", result);
	}

}
