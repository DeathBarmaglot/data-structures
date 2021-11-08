package com.luxoft.datastructures.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedQueueTest {

    @Test
    public void testQueueOverQueueCapacity() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        arrayQueue.enqueue("C");

        assertEquals(3, arrayQueue.size());
        assertEquals("C", arrayQueue.dequeue());
        assertEquals("B", arrayQueue.dequeue());
        assertEquals("A", arrayQueue.dequeue());
        assertEquals(0, arrayQueue.size());
        assertTrue(arrayQueue.isEmpty());

    }


    @Test
    public void testEnqueueAndDequeueAndCheckSize() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");

        assertEquals(2, arrayQueue.size());
        assertEquals("B", arrayQueue.dequeue());
        assertEquals("A", arrayQueue.dequeue());
        assertEquals(0, arrayQueue.size());
        assertTrue(arrayQueue.isEmpty());
    }

    @Test
    public void testEnqueueAndPeek() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("a");
        arrayQueue.enqueue("b");

        assertEquals(2, arrayQueue.size());
        assertEquals("a", arrayQueue.peek());
        assertEquals(2, arrayQueue.size());
    }

    @DisplayName("test Empty new Queue true")
    @Test
    public void testIsEmptyInNewQueueReturnTrue() {
        ArrayQueue arrayQueue = new ArrayQueue();

        assertTrue(arrayQueue.isEmpty());
        assertEquals(0, arrayQueue.size());
    }

    @DisplayName("test Empty After Clear false")
    @Test
    public void testIsEmptyInNewQueueReturnFalse() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("C");

        assertFalse(arrayQueue.isEmpty());
    }

    @DisplayName("test Empty After Clear true")
    @Test
    public void testIsEmptyAfterClearReturnTrue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        assertTrue(arrayQueue.isEmpty());

        arrayQueue.enqueue("C");
        arrayQueue.enqueue("D");

        assertFalse(arrayQueue.isEmpty());

        arrayQueue.clear();
        assertTrue(arrayQueue.isEmpty());
    }

    @DisplayName("test Contains Queue true")
    @Test
    public void testContainsReturnTrue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("C");
        arrayQueue.enqueue("D");

        assertTrue(arrayQueue.contains("C"));
		assertFalse(arrayQueue.contains("A"));
    }

    @DisplayName("test Contains Queue false")
    @Test
    public void testContainsReturnFalse() {
        ArrayQueue arrayQueue = new ArrayQueue();
		arrayQueue.enqueue("B");
        arrayQueue.enqueue("C");
        arrayQueue.enqueue("D");

        assertFalse(arrayQueue.contains("A"));
        Object b = arrayQueue.dequeue();
        assertTrue("B".equals(b));
		assertTrue(arrayQueue.contains("C"));

    }


    @DisplayName("test Contain Queue is Empty")
    @Test
    public void testContainsOnEmptyQueueReturnFalse() {
        ArrayQueue arrayQueue = new ArrayQueue();
        assertFalse(arrayQueue.contains("A"));
        assertEquals(0, arrayQueue.size());
    }

    @Test
    public void testMultiplyEnqueueAndDequeue() {
        ArrayQueue arrayQueue = new ArrayQueue();
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
    }

    @Test
    public void testStringOutput() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        arrayQueue.enqueue("C");

        String expected = "[A, B, C]";
        String actual = arrayQueue.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testDequeueEmptyQueue() {
		ArrayQueue arrayQueue = new ArrayQueue();
        assertTrue(arrayQueue.isEmpty());
        Assertions.assertThrows(IllegalStateException.class, () -> arrayQueue.dequeue());
    }

}






