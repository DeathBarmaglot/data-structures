package com.luxoft.datastructures.queue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayQueueTest {
	ArrayQueue arrayQueue = new ArrayQueue();

	@DisplayName("test Queue Enqueue And Dequeue Is Empty Return True")
	@Test
	public void testEnqueueAndDequeueAndCheckSize(){
		arrayQueue.enqueue("A");
		arrayQueue.enqueue("B");
		assertEquals(2, arrayQueue.size());
		assertEquals("B", arrayQueue.dequeue());
		assertEquals("A", arrayQueue.dequeue());
		assertEquals(0, arrayQueue.size());
		assertTrue(arrayQueue.isEmpty());
	}

	@DisplayName("test Queue Enqueue And Peek Check Size")
	@Test
	public void testEnqueueAndPeek(){
		arrayQueue.enqueue("a");
		arrayQueue.enqueue("b");
		assertEquals(2, arrayQueue.size());
		assertEquals("a", arrayQueue.peek());
		assertEquals(2, arrayQueue.size());
	}

	@DisplayName("test Empty new Queue Return True")
	@Test
	public void testIsEmptyInNewQueueReturnTrue(){
		assertTrue(arrayQueue.isEmpty());
	}

	@DisplayName("test is Empty After Enqueue Return False")
	@Test
	public void testIsEmptyInNewQueueReturnFalse(){
		arrayQueue.enqueue("C");
		assertFalse(arrayQueue.isEmpty());
	}
	@DisplayName("test Empty After Clear Return True")
	@Test
	public void testIsEmptyAfterClearReturnTrue(){
		arrayQueue.enqueue("C");
		arrayQueue.enqueue("D");
		arrayQueue.clear();
		assertTrue(arrayQueue.isEmpty());
	}

	@DisplayName("test Contains Queue Return True")
	@Test
	public void testContainsReturnTrue(){
		arrayQueue.enqueue("C");
		arrayQueue.enqueue("D");
		assertTrue(arrayQueue.contains("C"));
	}

	@DisplayName("test Contains Queue Return False")
	@Test
	public void testContainsReturnFalse(){
		arrayQueue.enqueue("C");
		arrayQueue.enqueue("D");
		assertFalse(arrayQueue.contains("A"));
	}

	@DisplayName("test Contain Empty Queue Return True")
	@Test
	public void testContainsOnEmptyQueueReturnTrue(){
		assertEquals(0, arrayQueue.size());
		arrayQueue.clear();
		assertTrue(arrayQueue.isEmpty());
	}

	@DisplayName("test Multiply Enqueue And Dequeue Return True")
	@Test
	public void testMultiplyEnqueueAndDequeue(){
		
		for (int i = 0; i < 5; i++) {
			arrayQueue.enqueue(i);
		}
		for (int i = 0; i < 5; i++) {
			arrayQueue.dequeue();
		}
		for (int i = 0; i < 5; i++) {
			arrayQueue.enqueue(i);
		}
		for (int i = 0; i < 5; i++) {
			arrayQueue.dequeue();
		}
		assertTrue(arrayQueue.isEmpty());
	}
}
