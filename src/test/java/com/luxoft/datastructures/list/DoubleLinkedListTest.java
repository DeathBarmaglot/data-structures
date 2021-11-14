package com.luxoft.datastructures.list;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleLinkedListTest {
    DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

    @Test
    public void testAdd() {

        Node head = new Node(1);
        Node second = new Node(2);
        head.next = second;
        second.next = new Node(3);
    }

    @Test
    public void testRemoveA() {
        doubleLinkedList.add("A");
        assertEquals("A", doubleLinkedList.remove(0));
    }

    @Test
    public void testRemoveANull() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add("F");
        doubleLinkedList.add("B");
        doubleLinkedList.add("C");
        doubleLinkedList.add("D", 3);
        doubleLinkedList.add("A", 4);
        doubleLinkedList.add("B", 5);
        assertEquals("F", doubleLinkedList.remove(0));
    }


    @Test
    public void testRemoveDefault() {

        doubleLinkedList.add("A");
        doubleLinkedList.add("B");
        doubleLinkedList.add("C");
        assertEquals(3, doubleLinkedList.size());
        doubleLinkedList.remove(0);
        assertEquals(2, doubleLinkedList.size());
        assertEquals("B", doubleLinkedList.get(0));
        assertEquals("C", doubleLinkedList.get(1));
    }

    @Test
    public void testRemoveElements() {
        doubleLinkedList.add("A");
        doubleLinkedList.add("B", 1);
        assertEquals(2, doubleLinkedList.size());
        doubleLinkedList.remove(1);
        assertEquals(1, doubleLinkedList.size());
        assertEquals("A", doubleLinkedList.get(0));
    }

    @Test
    public void testFindLastIndex() {
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");
        doubleLinkedList.add("A");
        doubleLinkedList.add("C");
        assertEquals(2, doubleLinkedList.lastIndexOf("A"));
    }

    @Test
    public void testFindFirstIndex() {
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");
        doubleLinkedList.add("A");
        doubleLinkedList.add("C");
        assertEquals(0, doubleLinkedList.indexOf("A"));
    }

    @Test
    public void testToString() {
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");
        doubleLinkedList.add("C");
        assertEquals("[A, B, C]", doubleLinkedList.toString());
    }

    @Test
    public void testAddClearEmpty() {
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");
        doubleLinkedList.add("C");
        assertEquals(3, doubleLinkedList.size());
        doubleLinkedList.clear();
        assertEquals(0, doubleLinkedList.size());
        assertTrue(doubleLinkedList.isEmpty());
    }

    @Test
    public void testContain() {
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");
        doubleLinkedList.add("C");
        assertTrue(doubleLinkedList.contains("A"));
    }


    @DisplayName("Test DoubleLinkedList add And remove Is Empty Return True")
    @Test
    public void testDoubleLinkedListAddAndRemove() {
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");
        assertEquals(2, doubleLinkedList.size());
        assertEquals("B", doubleLinkedList.remove(1));
        assertEquals("A", doubleLinkedList.remove(0));
        assertTrue(doubleLinkedList.isEmpty());
    }

    @DisplayName("Test DoubleLinkedList add And get Check Size")
    @Test
    public void testAddAndGet() {
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");
        assertEquals(2, doubleLinkedList.size());
        assertEquals("A", doubleLinkedList.get(0));

    }

    @DisplayName("Test Empty new Double LinkedList Return True")
    @Test
    public void testIsEmptyInNewDoubleLinkedListReturnTrue() {
        assertTrue(doubleLinkedList.isEmpty());
        assertEquals(0, doubleLinkedList.size());
    }

    @DisplayName("Test is Empty After add Return False")
    @Test
    public void testIsEmptyAfterAddReturnFalse() {
        doubleLinkedList.add("C");
        assertFalse(doubleLinkedList.isEmpty());
    }

    @DisplayName("Test Empty After Clear Return True")
    @Test
    public void testIsEmptyAfterClearReturnTrue() {
        assertTrue(doubleLinkedList.isEmpty());
        doubleLinkedList.add("C");
        doubleLinkedList.add("D");
        assertFalse(doubleLinkedList.isEmpty());
        doubleLinkedList.clear();
        assertTrue(doubleLinkedList.isEmpty());
    }

    @DisplayName("Test Contains Return True")
    @Test
    public void testContainsReturnTrue() {
        doubleLinkedList.add("C");
        doubleLinkedList.add("D");
        assertTrue(doubleLinkedList.contains("C"));
        assertFalse(doubleLinkedList.contains("A"));
    }

    @DisplayName("Test Contains DoubleLinkedList After remove Return False")
    @Test
    public void testContainsReturnFalse() {
        doubleLinkedList.add("B");
        doubleLinkedList.add("C");
        doubleLinkedList.add("D");
        assertFalse(doubleLinkedList.contains("A"));
        assertEquals("B", doubleLinkedList.remove(0));
        assertTrue(doubleLinkedList.contains("C"));
    }

    @DisplayName("Test Contains Empty DoubleLinkedList Return False")
    @Test
    public void testContainsOnEmptyDoubleLinkedListReturnFalse() {
        assertFalse(doubleLinkedList.contains("A"));
        assertEquals(0, doubleLinkedList.size());
        doubleLinkedList.clear();
        assertTrue(doubleLinkedList.isEmpty());
    }

    @DisplayName("Test Multiply add And remove Return True")
    @Test
    public void testMultiplyAddAndRemove() {

        for (int i = 0; i < 5; i++) {
            doubleLinkedList.add(i);
        }

        while (doubleLinkedList.size > 0) {
            doubleLinkedList.remove(0);
        }

        assertTrue(doubleLinkedList.isEmpty());

        for (int i = 0; i < 5; i++) {
            doubleLinkedList.add(i);
        }

        while (doubleLinkedList.size > 0) {
            doubleLinkedList.remove(0);
        }

        assertTrue(doubleLinkedList.isEmpty());
    }

    @DisplayName("Test toString Output")
    @Test
    public void testStringOutput() {

        doubleLinkedList.add("A");
        doubleLinkedList.add("B");
        doubleLinkedList.add("C");

        String expected = "[A, B, C]";
        String actual = doubleLinkedList.toString();

        assertEquals(expected, actual);
    }

    @DisplayName("Test Index Bounds Exception Remove")
    @Test
    public void testIndexBoundsExceptionRemove() {

        doubleLinkedList.add(1);
        IndexOutOfBoundsException message =
                assertThrows(IndexOutOfBoundsException.class, () -> doubleLinkedList.remove(1));

        assertEquals("Index 1 more than size ArrayList", message.getMessage());
    }

    @DisplayName("Test Array Index Bounds Exception Less Then Size")
    @Test
    public void testArrayIndexBoundsExceptionLessThenSize() {
        doubleLinkedList.add(1);
        IndexOutOfBoundsException message =
                assertThrows(IndexOutOfBoundsException.class, () -> doubleLinkedList.set(1, -1));
        assertEquals("Index -1 more than size ArrayList", message.getMessage());
    }

    @DisplayName("Test Index Bounds Exception More Then Size")
    @Test
    public void testIndexBoundsExceptionMoreThenSize() {
        doubleLinkedList.add(1);
        IndexOutOfBoundsException message =
                assertThrows(IndexOutOfBoundsException.class, () -> doubleLinkedList.get(2));
        assertEquals("Index 2 more than size ArrayList", message.getMessage());
    }

    @DisplayName("Test Index Bounds Exception Remove is Empty")
    @Test
    public void testIndexBoundsExceptionIsEmpty() {
        IndexOutOfBoundsException message =
                assertThrows(IndexOutOfBoundsException.class, () -> doubleLinkedList.remove(3));
        assertEquals("Index 3 more than size ArrayList", message.getMessage());
    }

    @DisplayName("Test Null element in value")
    @Test
    public void testNullElementInValue() {
        NullPointerException message =
                assertThrows(NullPointerException.class, () -> doubleLinkedList.add(null));
        assertEquals("Null element in value", message.getMessage());
    }
}
