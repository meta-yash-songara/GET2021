package com.metacube.DetectLoop;

public class DetectLoop {
	
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
	
	public boolean detectLoop(){
		
		Node slow_p = head;
		Node fast_p = head;
		
		while(slow_p != null && fast_p != null && fast_p.next != null){
			
			slow_p = slow_p.next;
			fast_p = fast_p.next.next;
			
			if(slow_p == fast_p)
				return true;
			
		}
		
		return false;
	}
	
	public void createLoopAt(int i){
		
		Node temp = head;
		int count = 0;
		
		while(count != i){
			
			if(temp == null)
				System.out.println("Range Extended Than Number Of Items.");
			
			temp = temp.next;
			count++;
			
		}
		
		last.next = temp;
		
	}

}
