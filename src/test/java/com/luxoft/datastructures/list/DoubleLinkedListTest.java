package com.luxoft.datastructures.list;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleLinkedListTest<T> {
    DoubleLinkedList<T> doubleLinkedList = new DoubleLinkedList<>();

    @Test
    public void testAdd() {

        Node<T> head = new Node(1);
        Node<T> second = new Node(2);
        head.next = second;
        second.next = new Node(3);
    }

    @Test
    public void testRemoveA() {
        doubleLinkedList.add((T) "A");
        assertEquals("A", doubleLinkedList.remove(0));
    }

    @Test
    public void testRemoveANull() {

        doubleLinkedList.add((T)"F");
        doubleLinkedList.add((T)"B");
        doubleLinkedList.add((T)"C");
        doubleLinkedList.add((T)"D", 3);
        doubleLinkedList.add((T)"A", 4);
        doubleLinkedList.add((T)"B", 5);
        assertEquals("F", doubleLinkedList.remove(0));
    }


    @Test
    public void testRemoveDefault() {

        doubleLinkedList.add((T)"A");
        doubleLinkedList.add((T)"B");
        doubleLinkedList.add((T)"C");
        assertEquals(3, doubleLinkedList.size());
        doubleLinkedList.remove(0);
        assertEquals(2, doubleLinkedList.size());
        assertEquals("B", doubleLinkedList.get(0));
        assertEquals("C", doubleLinkedList.get(1));
    }

    @Test
    public void testRemoveElements() {
        doubleLinkedList.add((T)"A");
        doubleLinkedList.add((T) "B", 1);
        assertEquals(2, doubleLinkedList.size());
        doubleLinkedList.remove(1);
        assertEquals(1, doubleLinkedList.size());
        assertEquals("A", doubleLinkedList.get(0));
    }

    @Test
    public void testFindLastIndex() {
        doubleLinkedList.add((T)"A");
        doubleLinkedList.add((T)"B");
        doubleLinkedList.add((T)"A");
        doubleLinkedList.add((T)"C");
        assertEquals(2, doubleLinkedList.lastIndexOf((T)"A"));
    }

    @Test
    public void testFindFirstIndex() {
        doubleLinkedList.add((T)"A");
        doubleLinkedList.add((T)"B");
        doubleLinkedList.add((T)"A");
        doubleLinkedList.add((T)"C");
        assertEquals(0, doubleLinkedList.indexOf((T)"A"));
    }

    @Test
    public void testToString() {
        doubleLinkedList.add((T)"A");
        doubleLinkedList.add((T)"B");
        doubleLinkedList.add((T)"C");
        assertEquals("[A, B, C]", doubleLinkedList.toString());
    }

    @Test
    public void testAddClearEmpty() {
        doubleLinkedList.add((T)"A");
        doubleLinkedList.add((T)"B");
        doubleLinkedList.add((T)"C");
        assertEquals(3, doubleLinkedList.size());
        doubleLinkedList.clear();
        assertEquals(0, doubleLinkedList.size());
        assertTrue(doubleLinkedList.isEmpty());
    }

    @Test
    public void testContain() {
        doubleLinkedList.add((T)"A");
        doubleLinkedList.add((T)"B");
        doubleLinkedList.add((T)"C");
        assertTrue(doubleLinkedList.contains((T)"A"));
    }


    @DisplayName("Test DoubleLinkedList add And remove Is Empty Return True")
    @Test
    public void testDoubleLinkedListAddAndRemove() {
        doubleLinkedList.add((T)"A");
        doubleLinkedList.add((T)"B");
        assertEquals(2, doubleLinkedList.size());
        assertEquals("B", doubleLinkedList.remove(1));
        assertEquals("A", doubleLinkedList.remove(0));
        assertTrue(doubleLinkedList.isEmpty());
    }

    @DisplayName("Test DoubleLinkedList add And get Check Size")
    @Test
    public void testAddAndGet() {
        doubleLinkedList.add((T)"A");
        doubleLinkedList.add((T)"B");
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
        doubleLinkedList.add((T)"C");
        assertFalse(doubleLinkedList.isEmpty());
    }

    @DisplayName("Test Empty After Clear Return True")
    @Test
    public void testIsEmptyAfterClearReturnTrue() {
        assertTrue(doubleLinkedList.isEmpty());
        doubleLinkedList.add((T)"C");
        doubleLinkedList.add((T)"D");
        assertFalse(doubleLinkedList.isEmpty());
        doubleLinkedList.clear();
        assertTrue(doubleLinkedList.isEmpty());
    }

    @DisplayName("Test Contains Return True")
    @Test
    public void testContainsReturnTrue() {
        doubleLinkedList.add((T)"C");
        doubleLinkedList.add((T)"D");
        assertTrue(doubleLinkedList.contains((T)"C"));
        assertFalse(doubleLinkedList.contains((T)"A"));
    }

    @DisplayName("Test Contains DoubleLinkedList After remove Return False")
    @Test
    public void testContainsReturnFalse() {
        doubleLinkedList.add((T)"B");
        doubleLinkedList.add((T)"C");
        doubleLinkedList.add((T)"D");
        assertFalse(doubleLinkedList.contains((T)"A"));
        assertEquals("B", doubleLinkedList.remove(0));
        assertTrue(doubleLinkedList.contains((T)"C"));
    }

    @DisplayName("Test Contains Empty DoubleLinkedList Return False")
    @Test
    public void testContainsOnEmptyDoubleLinkedListReturnFalse() {
        assertFalse(doubleLinkedList.contains((T)"A"));
        assertEquals(0, doubleLinkedList.size());
        doubleLinkedList.clear();
        assertTrue(doubleLinkedList.isEmpty());
    }

    @DisplayName("Test Multiply add And remove Return True")
    @Test
    public void testMultiplyAddAndRemove() {

        for (int i = 0; i < 5; i++) {
            doubleLinkedList.add( (T) (""+ i));
        }

        while (doubleLinkedList.size > 0) {
            doubleLinkedList.remove(0);
        }

        assertTrue(doubleLinkedList.isEmpty());

        for (int i = 0; i < 5; i++) {
            doubleLinkedList.add((T) (""+ i));
        }

        while (doubleLinkedList.size > 0) {
            doubleLinkedList.remove(0);
        }

        assertTrue(doubleLinkedList.isEmpty());
    }

    @DisplayName("Test toString Output")
    @Test
    public void testStringOutput() {

        doubleLinkedList.add((T)"A");
        doubleLinkedList.add((T)"B");
        doubleLinkedList.add((T)"C");

        String expected = "[A, B, C]";
        String actual = doubleLinkedList.toString();

        assertEquals(expected, actual);
    }

    @DisplayName("Test Index Bounds Exception Remove")
    @Test
    public void testIndexBoundsExceptionRemove() {

        doubleLinkedList.add((T) "A");
        IndexOutOfBoundsException message =
                assertThrows(IndexOutOfBoundsException.class, () -> doubleLinkedList.remove(1));

        assertEquals("Index 1 more than size ArrayList", message.getMessage());
    }

    @DisplayName("Test Array Index Bounds Exception Less Then Size")
    @Test
    public void testArrayIndexBoundsExceptionLessThenSize() {
        doubleLinkedList.add((T) "A");
        IndexOutOfBoundsException message =
                assertThrows(IndexOutOfBoundsException.class, () -> doubleLinkedList.set((T) "A", -1));
        assertEquals("Index -1 more than size ArrayList", message.getMessage());
    }

    @DisplayName("Test Index Bounds Exception More Then Size")
    @Test
    public void testIndexBoundsExceptionMoreThenSize() {
        doubleLinkedList.add((T) "A");
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
