package com.example.hexCalc;

import java.util.*;

public class HexCalc {
	
	private Map<Character, Integer> hexToDecVal;
	
	public HexCalc(){
		hexToDecVal = new HashMap<>();
		hexToDecVal.put('0', 0);
		hexToDecVal.put('1', 1);
		hexToDecVal.put('2', 2);
		hexToDecVal.put('3', 3);
		hexToDecVal.put('4', 4);
		hexToDecVal.put('5', 5);
		hexToDecVal.put('6', 6);
		hexToDecVal.put('7', 7);
		hexToDecVal.put('8', 8);
		hexToDecVal.put('9', 9);
		hexToDecVal.put('A', 10);
		hexToDecVal.put('B', 11);
		hexToDecVal.put('C', 12);
		hexToDecVal.put('D', 13);
		hexToDecVal.put('E', 14);
		hexToDecVal.put('F', 15);
	}
	
	public String hexAdd(String num1, String num2){
		return decToHex(hexToDec(num1) + hexToDec(num2));
	}
	
	public String hexSub(String num1, String num2){
		return decToHex(hexToDec(num1) - hexToDec(num2));
	}
	
	public String hexMult(String num1, String num2){
		return decToHex(hexToDec(num1) * hexToDec(num2));
	}
	
	public String hexDiv(String num1, String num2){
		return decToHex(hexToDec(num1) / hexToDec(num2));
	}
	
	public boolean hexIsEqual(String num1, String num2){
		return num1.equals(num2);
	}
	
	public boolean hexIsGreater(String num1, String num2){
		return hexToDec(num1) > hexToDec(num2);
	}
	
	public boolean hexIsSmaller(String num1, String num2){
		return hexToDec(num1) > hexToDec(num2);
	}
	
	public int hexToDec(String hexNum){
		int len = hexNum.length();
		int result = 0;
		int pow = 0;
		
		if(hexNum.length() == 1){
			return hexToDecVal.get(hexNum.charAt(0));
		}else{
			for(int i = len - 1; i >= 0; --i, ++pow){
				char hexDigit = hexNum.charAt(i);
				result += (((int)(Math.pow(16, pow)) * hexToDecVal.get(Character.toUpperCase(hexDigit)))); 
			}
			
			return result;
		}
	}
	
	public String decToHex(int decNum){
		return Integer.toHexString(decNum);
	}

}
