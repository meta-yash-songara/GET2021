package com.metacube.dictionary;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class DictionaryTest{
	
	@Test
	public void testDictionaryMethods() throws Exception{
		Object object = new JSONParser().parse(
				new FileReader("C:\\Users\\yash.songara_metacub\\workspace\\Dictionary\\src\\com\\metacube\\dictionary\\data.json")
				);
		
		JSONObject jsonObject = (JSONObject) object;
		
		Dictionary dictionary = new Dictionary(jsonObject);

		// Test add Method & get all data method
		dictionary.addData("1", "one");
		
		String expextedRes = "1 : one," +
								"2 : two," +
								"3 : three," +
								"4 : four," +
								"5 : five," +
								"6 : six," +
								"7 : seven," +
								"8 : eight,";
		
		assertEquals(expextedRes, dictionary.getDataAsString(dictionary.getAllData()));
		
		// Test Delete method & get all data method
		dictionary.deleteData("6");
		expextedRes = "1 : one," +
				"2 : two," +
				"3 : three," +
				"4 : four," +
				"5 : five," +
				"7 : seven," +
				"8 : eight,";
		
		assertEquals(expextedRes, dictionary.getDataAsString(dictionary.getAllData()));
		
		// Test get Data at method
		assertEquals("eight", dictionary.getDataAt("8"));
		
		// Test get data between method & get all data method
		expextedRes = "3 : three," +
				"4 : four,";
		
		assertEquals(expextedRes, dictionary.getDataAsString(dictionary.getFromAndTo("2", "5")));
		
	}

}
















