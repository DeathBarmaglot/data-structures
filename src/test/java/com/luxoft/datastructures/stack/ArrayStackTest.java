package com.luxoft.datastructures.stack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayStackTest {
    @Test
    public void testPushAndPopAndCheckSize(){
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push("A");
        arrayStack.push("B");
        assertEquals(2, arrayStack.size());
        assertEquals("B", arrayStack.pop());
        assertEquals("A", arrayStack.pop());
        assertEquals(0, arrayStack.size());
        assertTrue(arrayStack.isEmpty());
    }

    @Test
    public void testPushAndPeek(){
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push("a");
        arrayStack.push("b");
        assertEquals(2, arrayStack.size());
        assertEquals("b", arrayStack.peek());
        assertEquals("b", arrayStack.peek());
        assertEquals(2, arrayStack.size());
    }

    @Test
    public void testIsEmptyInNewStackReturnTrue(){
        ArrayStack arrayStack = new ArrayStack();
        assertTrue(arrayStack.isEmpty());
    }

    @Test
    public void testIsEmptyInNewStackReturnFalse(){
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push("C");
        assertFalse(arrayStack.isEmpty());
    }

    @Test
    public void testIsEmptyAfterClearReturnTrue(){
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push("C");
        arrayStack.push("D");
        arrayStack.clear();
        assertTrue(arrayStack.isEmpty());
    }

    @Test
    public void testContainsReturnTrue(){
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push("C");
        arrayStack.push("D");

        assertTrue(arrayStack.contain("C"));
    }

    @Test
    public void testContainsReturnFalse(){
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push("C");
        arrayStack.push("D");
        assertFalse(arrayStack.contain("A"));
    }

    @Test
    public void testContainsOnEmptyStackReturnFalse(){
        ArrayStack arrayStack = new ArrayStack();
        assertFalse(arrayStack.contain("A"));
    }
    @Test
    public void testThrowIllegalStateExceptionOnPopStack(){
        ArrayStack arrayStack = new ArrayStack();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            arrayStack.pop();
        });

    }

}
