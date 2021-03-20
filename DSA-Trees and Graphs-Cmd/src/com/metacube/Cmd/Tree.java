package com.metacube.Cmd;

import java.util.*;
import java.sql.Timestamp;

public class Tree {
	
	String rootIndicator = "R:";
	
	Node root = new Node("R");
	Node cur = root;
	Node searchedNode;
	
	public boolean search(Node node, String folder_name){
		try{
			if(node.child == null){
				return false;
			}
			
			for(Node n: node.child){
				if(folder_name.equals(n.folder_name)){
					searchedNode = n;
					return true;
				}else{
					if(search(n, folder_name))
						return true;
				}
			}
			
		}catch(Exception e){
			System.out.println(e.getStackTrace());
		}
		
		return false;
	}
	
	public void addFolder(String folder_name){
		
		try{
			if(search(root, folder_name)){
				System.out.println("Directory Exists !!!");
			}else{
				Node n = new Node(folder_name);
				cur.child.add(n);
				n.root = cur;
				n.ts = new Timestamp(new Date().getTime());
			}
		}catch(Exception e){
			System.out.println(e.getStackTrace());
		}
		
	}
	
	public void changeCur(String folder_name){
		try{
			
			if(search(root, folder_name)){
				rootIndicator += "\\" + folder_name;
				cur = searchedNode;
			}else{
				System.out.println("Directory not exists !!!!");
			}
			
		}catch(Exception e){
			System.out.println(e.getStackTrace());
		}
	}
	
	public void findFolder(String folder_name){
		try{
			Node temp = cur;
			
			if(search(temp, folder_name)){
				String str = searchedNode.folder_name;
				searchedNode = searchedNode.root;
				str = searchedNode.folder_name + "\\" + str;
				System.out.println(str);
			}else{
				System.out.println("Directory not exists !!!!");
			}
			
		}catch(Exception e){
			System.out.println(e.getStackTrace());
		}
	}
	
	public void BFS(Node n){
		try{
			System.out.println(" ");
			
			if(n.child == null){
				System.out.println();
				return;
			}
			
			for(Node node: n.child){
				System.out.println("\u2514" + node.folder_name);
				BFS(node);
			}
		}catch(Exception e){
			System.out.println(e.getStackTrace());
		}
	}
	
	public void backToParentDirectory(){
		try{
			rootIndicator = rootIndicator.replaceFirst(cur.folder_name, " ");
			cur = cur.root;
		}catch(Exception e){
			System.out.println(e.getStackTrace());
		}
	}
	
	public void childrenList(){
		try{
			if(cur.child == null){
				System.out.println(0);
			}
			
			System.out.println(cur.child.size());
			
			for(Node n: cur.child)
				System.out.println(n.folder_name + " " + n.ts);
			
		}catch(Exception e){
			System.out.println(e.getStackTrace());
		}
	}

}

















