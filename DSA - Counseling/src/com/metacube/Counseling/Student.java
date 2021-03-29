package com.metacube.Counseling;

public class Student {
	
	private String student_name;
	private String[] program_list;
	
	public Student(){};
	
	public Student(String name, String[] programs){
		student_name = name;
		program_list = programs;
	}

	public String getStudent_name() {
		return student_name;
	}

	public String[] getProgram_list() {
		return program_list;
	}

}
