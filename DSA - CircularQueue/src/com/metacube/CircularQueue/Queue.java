package com.metacube.CircularQueue;

public interface Queue {
	
	public void enqueue(int data);
	public int dequeue();
	public boolean isEmpty();
	public boolean isFull();

}
