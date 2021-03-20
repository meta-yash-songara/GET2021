package com.metacube.Cmd;

import java.util.Scanner;

public class Cmd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		
		try{
			
			Tree directories = new Tree();
			String[] commands;
			boolean isExist = false;
			
			do{
				System.out.println(directories.rootIndicator);
				String str = scn.nextLine();
				commands = str.split(" ");
				
				switch(commands[0]){
				case "mkdir": directories.addFolder(commands[1]);
							break;
				
				case "cd": directories.changeCur(commands[1]);
							break;
							
				case "bk": directories.backToParentDirectory();
							break;
				
				case "ls": directories.childrenList();
							break;
							
				case "find": directories.findFolder(commands[1]);
							break;
							
				case "tree": directories.BFS(directories.root);
							break;
							
				case "exit": System.exit(0);
							break;
							
				default: System.out.println("Invalid Command !!!");
				}
			}while(!isExist);
			
		}catch(Exception e){
			System.out.println(e);
		} finally{
			scn.close();
		}
		
	}

}














