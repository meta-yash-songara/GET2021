package com.example.hexCalc;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
	
	public static void print(String result){
		System.out.println("Result : " + result);
	}
	
	public static void print(int result){
		System.out.println("Result : " + result);
	}
	
	public static void print(boolean result, String num1, String num2, int operation){
		// operation = 1, greater than
		// operation = 2, less than
		if(operation == 1){
			System.out.println("Result : " + (result?num1:num2) 
					+ " is greater than " 
					+ (result?num2:num1));
		}else if(operation == 2){
			System.out.println("Result : " + (result?num2:num1) 
					+ " is Less than " 
					+ (result?num1:num2));
		}else{
			System.out.println("Result : " + result);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn = new Scanner(System.in);
		
		HexCalc calc = new HexCalc();
		int option = 0;
		
		System.out.println("Shopping Menu ----------------------");
		System.out.println("1. Hexadecimal Addition (+)");
		System.out.println("2. Hexadecimal Substraction (-)");
		System.out.println("3. Hexadecimal Multiplication (x)");
		System.out.println("4. Hexadecimal Division (/)");
		System.out.println("5. Check Equality (=)");
		System.out.println("6. Check Greater (>)");
		System.out.println("7. Check Smaller (<)");
		System.out.println("8. Hexadecimal To Decimal");
		System.out.println("9. Decimal To Hexadecimal");
		System.out.println("10. Exit");
		System.out.println("------------------------------------");
		
		do{
			System.out.print("Enter your option (1/2/3/4/5/6/7/8/9/10) : ");
			
			try{
				option = scn.nextInt();
			}catch(InputMismatchException e){
				
			}
			scn.nextLine();
			
			System.out.println("------------------------------------");
			
			String num1 = "";
			String num2 = "";
			
			if(option != 8 && option != 9 && option != 10){
				System.out.print("Enter First Value : ");
				num1 = scn.next();

				System.out.print("Enter Second Value : ");
				num2 = scn.next();
			}else if(option == 8 || option == 9){
				System.out.print("Enter Value : ");
				num1 = scn.next();
			}
			
			switch(option){
			case 1: print(calc.hexAdd(num1, num2));
					break;
			case 2: print(calc.hexSub(num1, num2));
					break;
			case 3: print(calc.hexMult(num1, num2));
					break;
			case 4: print(calc.hexDiv(num1, num2));
					break;
			case 5: print(calc.hexIsEqual(num1, num2),"","",0);
					break;
			case 6: print(calc.hexIsGreater(num1, num2), num1, num2, 1);
					break;
			case 7: print(calc.hexIsSmaller(num1, num2), num1, num2, 2);
					break;
			case 8: print(calc.hexToDec(num1));
					break;
			case 9:	try{
						print(calc.decToHex(Integer.valueOf(num1)));
					}catch(NumberFormatException e){
						System.out.println("Please enter a decimal number !!!!");
					}
					break;
			case 10: option = 10;
					break;
			default: System.out.println("Please enter correct input !!!");
			}
			
		}while(option != 10);
		
		System.out.print("Thank you for using hex calculator :)");
		
	}

}
