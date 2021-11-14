package com.luxoft.datastructures.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayStackTest {
    ArrayStack arrayStack = new ArrayStack();
    Iterator<Object> iterator = arrayStack.iterator();

    @DisplayName("Test Has Next Return True")
    @Test
    public void testHasNextTrue() {
        arrayStack.push("A");
        assertTrue(iterator.hasNext());
        assertEquals(1, arrayStack.size());
    }

    @DisplayName("Test Has Next Return False")
    @Test
    public void testHasNextFalse() {
        assertFalse(iterator.hasNext());
        assertTrue(arrayStack.isEmpty());
    }

    @DisplayName("Test Push And Next Iterator")
    @Test
    public void testPushAndIterator() {
        arrayStack.push("A");
        assertEquals(arrayStack.peek(), iterator.next());
    }

    @DisplayName("Test Push And Pop Is Empty Return True")
    @Test
    public void testPushAndPopCheckIsEmptyReturnTrue() {
        arrayStack.push("A");
        arrayStack.push("B");
        arrayStack.push("C");
        assertEquals(3, arrayStack.size());
        assertEquals("C", arrayStack.pop());
        assertEquals("B", arrayStack.pop());
        assertEquals("A", arrayStack.pop());
        assertEquals(0, arrayStack.size());
        assertTrue(arrayStack.isEmpty());
    }

    @DisplayName("Test Push And Peek In Stack Assert Size")
    @Test
    public void testPushAndPeek() {
        arrayStack.push("a");
        arrayStack.push("b");
        assertEquals(2, arrayStack.size());
        assertEquals("b", arrayStack.peek());
        assertEquals("b", arrayStack.peek());
        assertEquals(2, arrayStack.size());
    }

    @DisplayName("Test Is Empty In New Stack Return True")
    @Test
    public void testIsEmptyInNewStackReturnTrue() {
        ArrayStack arrayStack = new ArrayStack(0);
        assertTrue(arrayStack.isEmpty());
    }

    @DisplayName("Test Is Empty After Push Return False")
    @Test
    public void testIsEmptyInNewStackReturnFalse() {
        arrayStack.push("C");
        assertFalse(arrayStack.isEmpty());
    }

    @DisplayName("Test Empty After Clear Return True")
    @Test
    public void testIsEmptyAfterClearReturnTrue() {
        arrayStack.push("C");
        arrayStack.push("D");
        arrayStack.clear();
        assertTrue(arrayStack.isEmpty());
    }

    @DisplayName("Test Contains Return True")
    @Test
    public void testContainsReturnTrue() {
        arrayStack.push("C");
        arrayStack.push("D");
        assertTrue(arrayStack.contain("C"));
    }

    @DisplayName("Test Contains Return False")
    @Test
    public void testContainsReturnFalse() {
        arrayStack.push("C");
        arrayStack.push("D");
        assertFalse(arrayStack.contain("A"));
    }

    @DisplayName("Test Contains on Empty Stack Return False")
    @Test
    public void testContainsOnEmptyStackReturnFalse() {
        assertFalse(arrayStack.contain("A"));
    }

    @DisplayName("Throw Illegal State Exception On Pop Stack")
    @Test
    public void testThrowIllegalStateExceptionOnPopStack() {
        Assertions.assertThrows(IllegalStateException.class, arrayStack::pop);
    }
}
