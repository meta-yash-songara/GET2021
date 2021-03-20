package com.metacube.PriorityQueue;

public interface PriorityQueue {

	public void enqueue(int data, int priority);
	public int dequeue();
	public int getHighestPrior();
	public boolean isEmpty();
	public boolean isFull();
	
}
