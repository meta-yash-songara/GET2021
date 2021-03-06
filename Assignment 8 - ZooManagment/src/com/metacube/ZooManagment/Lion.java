package com.metacube.ZooManagment;

public class Lion extends Mammal{
	
	public Lion(int id, String name) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
	}

	@Override
	public String getAnimalSound() {
		// TODO Auto-generated method stub
		return "Roar";
	}

}
