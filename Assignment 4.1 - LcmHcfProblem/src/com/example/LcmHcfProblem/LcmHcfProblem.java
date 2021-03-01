package com.example.LcmHcfProblem;

public class LcmHcfProblem {
	
	public int findGcm(int num1, int num2){
		
		if(num1 == 0)
			return num2;
		
		return findGcm(num2 % num1, num1);
		
	}
	
	public int findLcm(int num1, int num2){
		
		return (num1 / findGcm(num1, num2)) * num2;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
	}

}
