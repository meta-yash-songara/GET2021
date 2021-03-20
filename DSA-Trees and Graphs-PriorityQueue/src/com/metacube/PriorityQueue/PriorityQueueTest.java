package com.metacube.PriorityQueue;

import static org.junit.Assert.*;

import org.junit.Test;

public class PriorityQueueTest {

	@Test
	public void testPriorityQueue(){
		QueueImplementation priorityQueue = new QueueImplementation(3);
		
		// Test is Empty Method
		assertEquals(true, priorityQueue.isEmpty());
		
		// Test is Full Method
		assertEquals(false, priorityQueue.isFull());
		
		// Inserting Items into queue
		priorityQueue.enqueue(2, 9);
		priorityQueue.enqueue(3, 5);
		priorityQueue.enqueue(6, 7);
		
		// Testing is full method again
		assertEquals(true, priorityQueue.isFull());
		
		// creating final result string
		String res = "2,9" + "\n"
					+ "3,5" + "\n"
					+ "6,7" + "\n";
		
		// checking queue
		assertEquals(res, priorityQueue.getQueue());
		
		// testing get highest priority method
		assertEquals(2, priorityQueue.getHighestPrior());
	}
	
}
