package com.example.CustomString;

import java.util.Arrays;

public class MyString {
	
	public int isEqual(String string1, String string2){
		
		if(string1.length() == string2.length()){
			for(int i = 0; i < string1.length(); i++){
				
				if(string1.charAt(i) == string2.charAt(i)){
					continue;
				}else
					return 0;
				
			}
			return 1;
		}
		
		return 0;
		
	}
	
	public String reverseString(String str){
		String reversedString = "";
		
		for(int i = str.length() - 1; i >=0; i--){
			reversedString += str.charAt(i);
		}
		
		return reversedString;
	}
	
	public String toUpperCase(String str){
		String resultString = "";
		
		for(int i = 0; i < str.length(); i++){
			
			int alphabetASCII = str.charAt(i);
			
			if(alphabetASCII >= 97 && alphabetASCII <= 122){
				alphabetASCII -= 32;
				resultString += ((char) alphabetASCII);
			}else{
				resultString += str.charAt(i);
			}
			
		}
		
		return resultString;
	}
	
	public String toLowerCase(String str){
		String resultString = "";
		
		for(int i = 0; i < str.length(); i++){
			
			int alphabetASCII = str.charAt(i);
			
			if(alphabetASCII >= 65 && alphabetASCII <= 90){
				alphabetASCII += 32;
				resultString += ((char) alphabetASCII);
			}else{
				resultString += str.charAt(i);
			}
			
		}
		
		return resultString;
	}
	
	public String getLargestWord(String str){
		
		String largest = "";
		String[] words = Arrays.stream(str.split(" ")).toArray(String[]::new);
		
		largest = words[0];
		
		for(int i = 1; i < words.length; i++){
			if(words[i].length() >= largest.length())
				largest = words[i];
		}
		
		return largest;
	}
	
}
