package com.example.cart;
import java.util.*;

public class Cart {
	private ArrayList<Product> cartItemsList;
	private Scanner scn;
	
	public Cart(){
		cartItemsList = new ArrayList<>();
		scn = new Scanner(System.in);
	}
	
	public void insertItem(Product p){
		if(p != null){
			cartItemsList.add(p);
			System.out.println("Item Added Succesfully.");
			System.out.println("------------------------------------");
		}
			
	}
	
	public void removeItem(int itemId){
		if(itemId > cartItemsList.size()){
			System.out.println("This Item Doesn't Exists.");
		}else{
			cartItemsList.remove(itemId - 1);
			System.out.println("Order Removed Succesfully.");
		}
	}
	
	public void updateItem(int itemId){
		int menuOption;
		
		if(cartItemsList.isEmpty()){
			System.out.println("Cart is empty.");
		}else if(cartItemsList.size() <= itemId){
			System.out.println("Which option you want to update ?");
			System.out.println("1. Product Name");
			System.out.println("2. Product Quantity");
			System.out.println("3. Product Price");
			System.out.println("4. Exit");
			
			System.out.println("Please Choose Your Option (1/2/3/4) : ");
			
			menuOption = scn.nextInt();
			
			switch(menuOption){
				case 1: System.out.print("Enter new product name : ");
						String newProductName = scn.next();
						
						cartItemsList.get(itemId - 1).setProductName(newProductName);
						break;
				case 2: System.out.print("Enter new product quantity : ");
						int newProductQuantity = scn.nextInt();
				
						cartItemsList.get(itemId - 1).setQuantity(newProductQuantity);
						break;
				case 3: System.out.print("Enter new product price : ");
						double newProductPrice = scn.nextInt();
				
						cartItemsList.get(itemId - 1).setProductPrice(newProductPrice);
						break;
				case 4: break;
				default: System.out.println("Please Choose a correct option.");
			}
			
			if(menuOption > 0 && menuOption < 4){
				System.out.println("Item Updated Succesfully.");
			}
		}else if(cartItemsList.isEmpty()){
			System.out.println("This item doesn't exists in your cart.");
		}
		
		
	}

	public void showBill(){
		if(!cartItemsList.isEmpty()){
			double grandTotal = 0.0;
			
			for(Product p: cartItemsList){
				double itemTotal = p.getProductPrice() * p.getQuantity();
				System.out.println(p.getProductName() + " : " + p.getProductPrice()
						+ " x " + p.getQuantity() + " = " + itemTotal);
				System.out.println("-------------------------------------");
				grandTotal += itemTotal;
			}
			
			System.out.println("GRAND TOTAL : " + grandTotal);
			System.out.println("--------------------------------------");
		}else{
			System.out.println("Please add some items in your cart first.");
		}
	}
	
	public void displayCartItems(){
		if(!cartItemsList.isEmpty()){
			for(Product p: cartItemsList){
				System.out.println("Product Details -----------\n" +
						"1. Product Id : " + (cartItemsList.indexOf(p) + 1) + "\n" +
						"2. Name : " + p.getProductName() + "\n" +
						"3. Quantity : " + p.getQuantity() + "\n" +
						"4. Price : " + p.getProductPrice() + "\n");
			}
		}else{
			System.out.println("Your cart is empty at the moment."
					+ "\nTry Adding some items into your cart.");
		}
	}
	
}
