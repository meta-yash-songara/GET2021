package com.example.Marksheet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Marksheet {
	
	static float findAverage(List<Float> grades){
		
		if(!grades.isEmpty()){
			float totalGradeSum = 0.0f;
			
			for(float grade: grades)
				totalGradeSum += grade;
			
			return totalGradeSum / grades.size();
		}
		
		return 0.0f;
	}

	static float getMaxGrade(List<Float> grades){
		if(!grades.isEmpty()){
			Collections.sort(grades);
			return grades.get(grades.size() - 1);
		}
		
		return 0.0f;
	}
	
	static float getMinGrade(List<Float> grades){
		if(!grades.isEmpty()){
			Collections.sort(grades);
			return grades.get(0);
		}
		
		return 0.0f;
	}
	
	static float getPercStudentPassed(List<Float> grades){
		if(!grades.isEmpty()){
			Collections.sort(grades);
			
			int pos = 0;
			while(grades.get(pos) < 40.0){
				pos++;
			}
			
			int studentsPassed = grades.size() - pos;
			
			return ((float) studentsPassed / (float) grades.size()) * 100;
		}
		
		return 0.0f;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		System.out.print("Enter number of students : ");
		
		int classSize = scn.nextInt();
		List<Float> grades = new ArrayList<Float>();
		
		for(int i = 0; i < classSize; i++){
			System.out.print("Enter grades of student " + (i + 1) + " : ");
			float grade = scn.nextFloat();
			grades.add(grade);
		}
		
		System.out.println("----------------------------------");
		System.out.println("Average Grades : " + findAverage(grades));
		System.out.println("Max Grade : " + getMaxGrade(grades));
		System.out.println("Min Grade : " + getMinGrade(grades));
		System.out.println(getPercStudentPassed(grades) + " % Students are passed.");

	}

}
