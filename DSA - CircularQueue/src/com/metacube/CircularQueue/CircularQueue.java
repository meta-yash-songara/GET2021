package com.metacube.CircularQueue;

public class CircularQueue implements Queue{
	
	int[] queueData = new int[30];
	int rear, front;
	int size;
	
	public CircularQueue(int size) {
		// TODO Auto-generated constructor stub
		this.size = size;
		rear = -1;
		front = -1;
	}

	@Override
	public void enqueue(int data) {
		// TODO Auto-generated method stub
		if(!isFull()){
			rear = (rear + 1) % size;
			queueData[rear] = data;
		}else{
			System.out.println("Overflow !!!");
		}
	}

	@Override
	public int dequeue() {
		// TODO Auto-generated method stub
		if(!isEmpty()){
			front = (front + 1) % size;
			return queueData[front];
		}else{
			System.out.println("Underflow !!!");
			return -1;
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(rear == front)
			return true;
		
		return false;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		rear = (rear + 1) % size;
		if(front == rear){
			if(rear == 0){
				rear = size - 1;
			}else{
				rear = rear - 1;
			}
			
			return true;
		}
		
		rear = rear - 1;
		return false;
	}
	
	public String getQueueData(){
		String res = "";
		
		for(int i = 0; i < size; i++)
			res += queueData[i];
		
		System.out.println(res);
		return res;
	}

}
