package com.metacube.ZooManagment;

public class Zone {
	
	String category;
	int capacity;
	int count;
	
	public Zone(int capacity, String category) {
		// TODO Auto-generated constructor stub
		this.capacity = capacity;
		this.category = category;
	}
	
	public int getCount(){
		return count;
	}

}
