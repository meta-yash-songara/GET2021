package com.example.cart;
import java.util.*;

public class ShoppingCart {
	
	public static void addItemInCart(Scanner scn, Cart c){
		Product p = new Product();
		
		System.out.print("Enter Item Name : ");
		p.setProductName(scn.next());
		
		System.out.print("Enter Item Quantity : ");
		p.setQuantity(scn.nextInt());
		
		System.out.print("Enter Item Price : ");
		p.setProductPrice(scn.nextDouble());
		
		c.insertItem(p);
	}
	
	public static void removeItemFromCart(Scanner scn, Cart c){
		int itemId;
		
		System.out.print("Please enter item id : ");
		itemId = scn.nextInt();
		
		c.removeItem(itemId);
		
	}
	
	public static void updateItemFromCart(Scanner scn, Cart c){
		int itemId;
		
		System.out.print("Please enter item id : ");
		itemId = scn.nextInt();
		
		c.updateItem(itemId);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		
		Cart myCart = new Cart();
		int option = 0;
	
		System.out.println("Shopping Menu ----------------------");
		System.out.println("1. Add Item In Cart");
		System.out.println("2. Remove Item From Cart");
		System.out.println("3. Update Item From Cart");
		System.out.println("4. Show My Cart Item");
		System.out.println("5. Show My Bill");
		System.out.println("6. Exit");
		System.out.println("------------------------------------");
		
		do{
			System.out.print("Enter your option (1/2/3/4/5/6) : ");
			
			try{
				option = scn.nextInt();
			}catch(InputMismatchException e){
				
			}
			scn.nextLine();
			
			System.out.println("------------------------------------");
			
			switch(option){
			case 1: addItemInCart(scn, myCart);
					break;
			case 2: removeItemFromCart(scn, myCart);
					break;
			case 3: updateItemFromCart(scn, myCart);
					break;
			case 4: myCart.displayCartItems();
					break;
			case 5: myCart.showBill();
					break;
			case 6: option = 6;
					break;
			default: System.out.println("Please enter correct input !!!!");
			}
		}while(option != 6);
		
		System.out.println("Thank you for shopping with us :)");
		
	}

}
