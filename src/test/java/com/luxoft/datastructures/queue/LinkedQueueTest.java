package com.luxoft.datastructures.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedQueueTest {
    LinkedQueue linkedQueue = new LinkedQueue();

    @DisplayName("test Queue Enqueue And Dequeue Is Empty Return True")
    @Test
    public void testQueueEnqueueAndDequeue() {
        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B");
        assertEquals(2, linkedQueue.size());
        assertEquals("A", linkedQueue.dequeue());
        assertEquals("B", linkedQueue.dequeue());
        assertEquals(0, linkedQueue.size());
        assertTrue(linkedQueue.isEmpty());
    }

    @DisplayName("test Queue Enqueue And Peek Check Size")
    @Test
    public void testEnqueueAndPeek() {
        linkedQueue.enqueue("a");
        linkedQueue.enqueue("b");
        assertEquals(2, linkedQueue.size());
        assertEquals("a", linkedQueue.peek());
        assertEquals(2, linkedQueue.size());
    }

    @DisplayName("test Empty new Queue Return True")
    @Test
    public void testIsEmptyInNewQueueReturnTrue() {
        assertTrue(linkedQueue.isEmpty());
        assertEquals(0, linkedQueue.size());
    }

    @DisplayName("test is Empty After Enqueue Return False")
    @Test
    public void testIsEmptyAfterEnqueueReturnFalse() {
        linkedQueue.enqueue("C");
        assertFalse(linkedQueue.isEmpty());
    }

    @DisplayName("test Empty After Clear Return True")
    @Test
    public void testIsEmptyAfterClearReturnTrue() {
        assertTrue(linkedQueue.isEmpty());
        linkedQueue.enqueue("C");
        linkedQueue.enqueue("D");
        assertFalse(linkedQueue.isEmpty());
        linkedQueue.clear();
        assertTrue(linkedQueue.isEmpty());
    }

    @DisplayName("test Contains Return True")
    @Test
    public void testContainsReturnTrue() {
        linkedQueue.enqueue("C");
        linkedQueue.enqueue("D");
        assertTrue(linkedQueue.contains("C"));
        assertFalse(linkedQueue.contains("A"));
    }

    @DisplayName("test Contains Queue After Dequeue Return False")
    @Test
    public void testContainsReturnFalse() {
        linkedQueue.enqueue("B");
        linkedQueue.enqueue("C");
        linkedQueue.enqueue("D");
        assertFalse(linkedQueue.contains("A"));
        assertEquals("B", linkedQueue.dequeue());
        assertTrue(linkedQueue.contains("C"));
    }

    @DisplayName("test Contains Empty Queue Return False")
    @Test
    public void testContainsOnEmptyQueueReturnFalse() {
        assertFalse(linkedQueue.contains("A"));
        assertEquals(0, linkedQueue.size());
        linkedQueue.clear();
        assertTrue(linkedQueue.isEmpty());
    }

    @DisplayName("test Multiply Enqueue And Dequeue Return True")
    @Test
    public void testMultiplyEnqueueAndDequeue() {

        for (int i = 0; i < 5; i++) {
            linkedQueue.enqueue(i);
        }

        for (int i = 0; i < 5; i++) {
            linkedQueue.dequeue();
        }

        for (int i = 0; i < 5; i++) {
            linkedQueue.enqueue(i);
        }

        for (int i = 0; i < 5; i++) {
            linkedQueue.dequeue();
        }
        assertTrue(linkedQueue.isEmpty());
    }

    @DisplayName("test String Output")
    @Test
    public void testStringOutput() {

        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B");
        linkedQueue.enqueue("C");

        String expected = "[A, B, C]";
        String actual = linkedQueue.toString();

        assertEquals(expected, actual);
    }

    @DisplayName("test is Empty Throws Illegal State Exception")
    @Test
    public void testDequeueEmptyQueue() {

        assertTrue(linkedQueue.isEmpty());
        Assertions.assertThrows(IllegalStateException.class, linkedQueue::dequeue);
    }
}
