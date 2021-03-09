package com.metacube.LinkedListRotation;

public class Rotation extends Node{
	
	Node head;
	Node last;
	
	public void insertNewData(int data){
		
		Node newData = new Node(data);
		
		if(head ==  null){
			head = newData;
			last = head;
			return;
		}
		
		last.next = newData;
		last = newData;
	}
	
	public String getList(){
		Node temp = head;
		String result = "";
		
		while(temp != null){
			result += String.valueOf(temp.data) + ", ";
			temp = temp.next;
		}
		
		System.out.println(result);
		
		return result;
	}
	
	public void rotateSubList(int L, int R, int rotationCount){
		
		Node tempL = new Node();
		Node tempR = new Node();			
		Node tempNode = new Node();
		Node prev = new Node();
		
		int count = 0;
		
		if(head == null){
			System.out.println("Empty Linked List !!!");
			return;
		}else{
			
			while(count != rotationCount){
				
				tempL = head;
				tempR = head;
				prev = head;
				
				int countL  = 1;
				int countR = 1;
				
				while(countL != L){
					if(tempL != null){
						prev = tempL;
						tempL = tempL.next;
						countL++;
					}else{
						return;
					}
				}
				
				while(countR != R){
					if(tempR != null){
						tempR = tempR.next;
						countR++;
					}else{
						return;
					}
				}
				
				tempNode = tempL.next;
				tempL.next = tempR.next;
				tempR.next = tempL;
				prev.next = tempNode;
				
				count++;
				
			}
			
		}
		
	}
	
	

}
