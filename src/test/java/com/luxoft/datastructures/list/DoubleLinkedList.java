package com.luxoft.datastructures.list;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class DoubleLinkedList {
    DoubleLinkedList doubleLinkedList = new DoubleLinkedList();


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
}

//    @Test
//    public void testAll(){
//
//
//        Node b= new Node(5);
//        Node c= new Node(2);
//
//        System.out.println(b.next.value);
//
//    }
//
//
//
//    private int countNode(Node head){
//        int c = 1;
//        Node current = head;
//        while (current.next != null){
//            current=current.next;
//            c++;
//        }
//        return c;
//    }
//
//    @Test
//    public void testAdd() {
//
//        Node head = new Node(1);
//        Node second = new Node(2);
//        head.next = second;
//        Node third = new Node(3);
//        second.next = third;
//
////        System.out.println(getByIndex(head, 0));
////        System.out.println(getByIndex(head, 1));
////        System.out.println(getByIndex(head, 2));
//    }
//
//    static Object getByIndex(Node head, int index) {
//        Node current = head;
//        for (int i = 0; i < index; i++) {
//            current = current.next;
//        }
//
//        return current.value;
//    }
//