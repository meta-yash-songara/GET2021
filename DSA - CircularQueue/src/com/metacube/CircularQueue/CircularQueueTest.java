package com.metacube.CircularQueue;

import static org.junit.Assert.*;

import org.junit.Test;

public class CircularQueueTest {

	@Test
	public void checkCircularQueueMethods(){
		
		CircularQueue circularQueue = new CircularQueue(6);
		
		assertEquals(true, circularQueue.isEmpty());
		
		circularQueue.enqueue(3);
		circularQueue.enqueue(6);
		circularQueue.enqueue(1);
		circularQueue.enqueue(9);
		circularQueue.enqueue(7);
		circularQueue.enqueue(2);
		
		assertEquals("361972", circularQueue.getQueueData());
		
		assertEquals(3, circularQueue.dequeue());
		
		circularQueue.getQueueData();
	}
	
}
