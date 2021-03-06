package com.metacube.ZooManagment;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Zoo {

	static int id = 0;
	static ArrayList<Zone> zoneList = new ArrayList<Zone>();
	static ArrayList<Cage> cageList = new ArrayList<Cage>();
	static ArrayList<Animal> animalList = new ArrayList<Animal>();

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		boolean isExit = false;
		Zone zone1;	
		
		try {
			do {
				System.out.println("----------------------------");
				System.out.println("1.Ädd Zone");
				System.out.println("2.Add Cage");
				System.out.println("3.Add Animal");
				System.out.println("4.Remove Animal");
				System.out.println("5.Show Animal");
				System.out.println("6.Exit");
				System.out.println("----------------------------");
				System.out.print("Enter your choice (1/2/3/4/5/6) : ");
				
				int choice = sc.nextInt();
				sc.nextLine();
				
				switch (choice) {
				case 1: {
					if (zoneList.size() < 3) {
						System.out.println("----------------------------");
						System.out.print("Enter Catergory of Zone (i.e Reptile/Mammal/Bird) : ");
						String category = sc.nextLine();
						category = category.toUpperCase();
						System.out.print("Enter Cage Capacity of Zone : ");
						int cageCapacity = sc.nextInt();
						sc.nextLine();
						System.out.println("-----------------------");
						
						switch(category) {
						case "MAMMAL":
							zone1 = createZone("Mammal", cageCapacity);
							zoneList.add(zone1);
							System.out.println("Zone added !!!");
							break;
						case "REPTILE":
							zone1 = createZone("Reptile", cageCapacity);
							zoneList.add(zone1);
							System.out.println("Zone added !!!");
							break;
						case "BIRD":
							zone1 = createZone("Bird", cageCapacity);
							zoneList.add(zone1);
							System.out.println("Zone added !!!");
							break;
						}
					} else {
						System.out.println("Zone Fully Occupied !!!!!!");
					}
					break;
				}

				case 2: {
					if (zoneList.size() == 0) {
						System.out.println("-----------------------");
						System.out.println("No Zone Available !!!!");
						System.out.println("-----------------------");
					} else {
						System.out.println("-----------------------");
						System.out.print("Enter Cage Type : ");
						String type = sc.nextLine();
						type = type.toUpperCase();	
						System.out.print("Enter Cage Capacity : ");
						int capacity = sc.nextInt();	
						System.out.println("-----------------------");
						if ("LION".equals(type)) {
							String zoneType = Lion.class.getSuperclass().getSimpleName();
							insertCage(zoneType, capacity,type);
						} else if ("CROCODILE".equals(type)) {
							String zoneType = Crocodile.class.getSuperclass().getSimpleName();
							insertCage(zoneType, capacity,type);
						} else if ("PEACOCK".equals(type)) {
							String zoneType = Peacock.class.getSuperclass().getSimpleName();
							insertCage(zoneType, capacity,type);
						} else {
							System.out.println("-----------------------");
							System.out.println("Animal Not Available !!!!!!");
							System.out.println("-----------------------");
						}
					}
					break;
				}

				case 3:
					if (zoneList.size() == 0) {
						System.out.println("-----------------------");
						System.out.println("No Zone Available !!!!");
						System.out.println("-----------------------");
					} else if (cageList.size() == 0) {
						System.out.println("-----------------------");
						System.out.println("No Cage Available !!!!!!!");
						System.out.println("-----------------------");
					} else {
						System.out.println("-----------------------");
						System.out.print("Enter Animal Type : ");
						String animalType = sc.nextLine();
						animalType = animalType.toUpperCase();
						System.out.print("Enter Animal Name : ");
						String animalName = sc.nextLine();
						System.out.println("-----------------------");
						for (int i = 0; i < cageList.size(); i++) {
							Cage cage = cageList.get(i);
							if (animalType.equals(cage.type)) {	
								if (cage.capacity > 0) {
									cage.capacity = cage.capacity - 1;
									Animal animal1 = addAnimal(id++, animalName,animalType);
									animalList.add(animal1);
									System.out.println("-----------------------");
									System.out.println("Animal Added !!!!");
									System.out.println("-----------------------");
								} else {
									System.out.println("-----------------------");
									System.out.println("Cage Fullllll !!!!!!");
									System.out.println("-----------------------");
								}
							}
						}
					}
					break;
				case 4:
					System.out.println("-----------------------");
					System.out.println("Enter Animal Name : ");
					String animalName = sc.nextLine();	
					System.out.println("-----------------------");
					for (int i = 0; i < animalList.size(); i++) {
						Animal animal1 = animalList.get(i);
						if (animalName.equals(animal1.name)) {
							animalList.remove(i);
							System.out.println("-----------------------");
							System.out.println("Animal Removed !!!!!");
							System.out.println("-----------------------");
						}
					}
					break;

				case 5:
					System.out.println("-----------------------");
					System.out.println("Enter Animal Name : ");
					String animalName1 = sc.nextLine();	
					System.out.println("-----------------------");
					
					for (int i = 0; i < animalList.size(); i++) {
						
						Animal animal1 = animalList.get(i);
						
						if (animalName1.equals(animal1.name)) {
							System.out.println("-----------------------");
							System.out.println("Animal Name : " + animal1.name);
							System.out.println("Animal Id : " + animal1.id);
							System.out.println("Animal Sound : " + animal1.getAnimalSound());
							System.out.println("-----------------------");
						} else {
							System.out.println("-----------------------");
							System.out.println("Animal Not Available !!!!!!!");
							System.out.println("-----------------------");
						}
					}
					break;
				case 6:
					isExit = true;
					System.out.println("-----------------------");
					System.out.println("Thank you for using Zoo Managment System :)");
					System.out.println("-----------------------");
					break;
				default:
					System.out.println("-----------------------");
					System.out.println("Please enter a valid input (1/2/3/4/5/6)");
					System.out.println("-----------------------");

				}
			} while (!isExit);
			
		} catch (InputMismatchException e) {
			
			System.out.println("Please enter a valid input");
			
		} catch (NullPointerException e) {
			
			System.out.println("Null Exception Found !!!!");
			
		}
	}

	private static void insertCage(String type, int capacity, String cageType) {
		
		for (int i = 0; i < zoneList.size(); i++) {
			
			Zone zoneListObj = zoneList.get(i);
			
			if (type.equals(zoneListObj.category)) {
				
				if (zoneListObj.capacity > 0) {
					zoneListObj.capacity = zoneListObj.capacity - 1;
					Cage c1 = createCage(cageType, capacity);
					cageList.add(c1);
					System.out.println("Cage added !!!");	

				} else {
					System.out.println("-----------------------");
					System.out.println("Cage Fully Occupied !!!");	
					System.out.println("-----------------------");
				}
				break;
				
			} else {
				
				System.out.println("-----------------------");
				System.out.println("ZoneType and cageType mismatched !!!");
				System.out.println("-----------------------");
				
			}
		}

	}

	private static Zone createZone(String zoneType, int cageCapacity) {
		return new Zone(cageCapacity, zoneType);
	}

	private static Cage createCage(String CageType, int animalCapacity) {
		return new Cage(CageType, animalCapacity);
	}

	private static Animal addAnimal(int id, String name, String type) {
		
		if ("LION".equals(type)) {
			return new Lion(id, name);
		} else if ("CROCODILE".equals(type)) {
			return new Crocodile(id, name);
		} else if ("PEACOCK".equals(type)) {
			return new Peacock(id, name);
		} else {
			System.out.println("Animal Not Found");
			return null;
		}
		
	}

}
