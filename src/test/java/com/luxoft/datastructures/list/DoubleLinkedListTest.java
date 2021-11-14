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
    public void testRemoveNull() {
        assertNull(doubleLinkedList.remove(0));
    }

    @Test
    public void testRemoveANull() {
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");
        doubleLinkedList.add("C");
        assertEquals("B", doubleLinkedList.remove(1));
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

    @Test
    public void testIndexBoundsExceptionRemove() {

        doubleLinkedList.add(1);
        IndexOutOfBoundsException message =
                assertThrows(IndexOutOfBoundsException.class, () -> doubleLinkedList.remove(1));

        System.out.println(message.getMessage());
    }

    @Test
    public void testArrayIndexBoundsExceptionLessThenSize() {

        doubleLinkedList.add(1);
        IndexOutOfBoundsException message =
                assertThrows(IndexOutOfBoundsException.class, () -> doubleLinkedList.add(1, -1));

        System.out.println(message.getMessage());
    }

    @Test
    public void testIndexBoundsExceptionMoreThenSize() {

        doubleLinkedList.add(1);
        IndexOutOfBoundsException message =
                assertThrows(IndexOutOfBoundsException.class, () -> doubleLinkedList.get(2));

        System.out.println(message.getMessage());
    }

    @Test
    public void testThrowsIndexOut() {

        doubleLinkedList.add(1);
        assertEquals(1, doubleLinkedList.size());
        IndexOutOfBoundsException message =
                assertThrows(IndexOutOfBoundsException.class, () -> doubleLinkedList.get(2));

        System.out.println(message.getMessage());
    }

    @DisplayName("test DoubleLinkedList add And remove Is Empty Return True")
    @Test
    public void testDoubleLinkedListAddAndRemove() {
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");
        assertEquals(2, doubleLinkedList.size());
        assertEquals("A", doubleLinkedList.remove(0));
        assertEquals("B", doubleLinkedList.remove(1));
        assertEquals(0, doubleLinkedList.size());
        assertTrue(doubleLinkedList.isEmpty());
    }

    @DisplayName("test DoubleLinkedList add And get Check Size")
    @Test
    public void testAddAndGet() {
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");
        assertEquals(2, doubleLinkedList.size());
        assertEquals("A", doubleLinkedList.get(0));
        assertEquals(2, doubleLinkedList.size());
    }

    @DisplayName("test Empty new DoubleLinkedList Return True")
    @Test
    public void testIsEmptyInNewDoubleLinkedListReturnTrue() {
        assertTrue(doubleLinkedList.isEmpty());
        assertEquals(0, doubleLinkedList.size());
    }

    @DisplayName("test is Empty After add Return False")
    @Test
    public void testIsEmptyAfterAddReturnFalse() {
        doubleLinkedList.add("C");
        assertFalse(doubleLinkedList.isEmpty());
    }

    @DisplayName("test Empty After Clear Return True")
    @Test
    public void testIsEmptyAfterClearReturnTrue() {
        assertTrue(doubleLinkedList.isEmpty());
        doubleLinkedList.add("C");
        doubleLinkedList.add("D");
        assertFalse(doubleLinkedList.isEmpty());
        doubleLinkedList.clear();
        assertTrue(doubleLinkedList.isEmpty());
    }

    @DisplayName("test Contains Return True")
    @Test
    public void testContainsReturnTrue() {
        doubleLinkedList.add("C");
        doubleLinkedList.add("D");
        assertTrue(doubleLinkedList.contains("C"));
        assertFalse(doubleLinkedList.contains("A"));
    }

    @DisplayName("test Contains DoubleLinkedList After remove Return False")
    @Test
    public void testContainsReturnFalse() {
        doubleLinkedList.add("B");
        doubleLinkedList.add("C");
        doubleLinkedList.add("D");
        assertFalse(doubleLinkedList.contains("A"));
        assertEquals("B", doubleLinkedList.remove(0));
        assertTrue(doubleLinkedList.contains("C"));
    }

    @DisplayName("test Contains Empty DoubleLinkedList Return False")
    @Test
    public void testContainsOnEmptyDoubleLinkedListReturnFalse() {
        assertFalse(doubleLinkedList.contains("A"));
        assertEquals(0, doubleLinkedList.size());
        doubleLinkedList.clear();
        assertTrue(doubleLinkedList.isEmpty());
    }

    @DisplayName("test Multiply add And remove Return True")
    @Test
    public void testMultiplyAddAndRemove() {

        for (int i = 0; i < 5; i++) {
            doubleLinkedList.add(i);
        }

        for (int i = 0; i < 5; i++) {
            doubleLinkedList.remove(i);
        }
        assertTrue(doubleLinkedList.isEmpty());

        for (int i = 0; i < 5; i++) {
            doubleLinkedList.add(i);
        }

        for (int i = 0; i < 5; i++) {
            doubleLinkedList.remove(i);
        }
        assertTrue(doubleLinkedList.isEmpty());
    }

    @DisplayName("test String Output")
    @Test
    public void testStringOutput() {

        doubleLinkedList.add("A");
        doubleLinkedList.add("B");
        doubleLinkedList.add("C");

        String expected = "[A, B, C]";
        String actual = doubleLinkedList.toString();

        assertEquals(expected, actual);
    }

}
