package com.metacube.ZooManagment;

public class Peacock extends Bird{
	
	public Peacock(int id, String name) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
	}

	@Override
	public String getAnimalSound() {
		// TODO Auto-generated method stub
		return "Chirp";
	}

}
