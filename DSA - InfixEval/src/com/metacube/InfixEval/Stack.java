package com.metacube.InfixEval;

public class Stack implements StackMethods{
	
	private Node head;
	
	public Stack(){
		head = null;
	}
	
	public boolean isEmpty(){
		if(head == null)
			return true;
		
		return false;
	}

	@Override
	public void push(String data) {
		// TODO Auto-generated method stub
		
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
		
	}

	@Override
	public String pop() {
		// TODO Auto-generated method stub
		
		if(head == null){
			System.out.println("Empty Stack !!!");
			return "0";
		}else{
			String data = head.data;
			head = head.next;
			return data;
		}
	}

	@Override
	public String peek() {
		// TODO Auto-generated method stub
		
		if(head == null)
			return "0";
		
		return head.data;
	}

	@Override
	public void printStack() {
		// TODO Auto-generated method stub
		
		if(head == null){
			System.out.println("Empty Stack !!!");
		}else{
			Node temp = head;
			
			while(temp != null){
				System.out.println(temp.data);
				temp = temp.next;
			}
		}
		
	}

}
