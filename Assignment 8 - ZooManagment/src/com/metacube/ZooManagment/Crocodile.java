package com.metacube.ZooManagment;

public class Crocodile extends Reptile{
	
	public Crocodile(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String getAnimalSound() {
		return "Hissssss";
	};
	
}
