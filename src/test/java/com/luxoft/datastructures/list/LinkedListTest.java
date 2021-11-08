package com.luxoft.datastructures.list;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {
    ArrayList arrayList = new ArrayList();

    @Test
    public void testAdd() {

        Node head = new Node(1);
        Node second = new Node(2);
        head.next = second;
        Node third = new Node(3);
        second.next = third;

        System.out.println(getByIndex(head, 0));
        System.out.println(getByIndex(head, 1));
        System.out.println(getByIndex(head, 2));
    }

    static Object getByIndex(Node head, int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.value;
    }


    @Test
    public void testRemoveDefault() {
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        assertEquals(3, arrayList.size());
        arrayList.remove(0);
        assertEquals(2, arrayList.size());
        assertEquals("B", arrayList.get(0));
        assertEquals("C", arrayList.get(1));
    }

    @Test
    public void testRemoveElements() {
        arrayList.add("A");
        arrayList.add("B", 1);
        assertEquals(2, arrayList.size());
        arrayList.remove(1);
        assertEquals(1, arrayList.size());
        assertEquals("A", arrayList.get(0));
    }

    @Test
    public void testFindLastIndex() {
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("A");
        arrayList.add("C");
        assertEquals(2, arrayList.lastIndexOf("A"));
    }

    @Test
    public void testFindFirstIndex() {
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("A");
        arrayList.add("C");
        assertEquals(0, arrayList.indexOf("A"));
    }

    @Test
    public void testToString() {
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        assertEquals("[A, B, C]", arrayList.toString());
    }

    @Test
    public void testAddClearEmpty() {
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        assertEquals(3, arrayList.size());
        arrayList.clear();
        assertEquals(0, arrayList.size());
        assertTrue(arrayList.isEmpty());
    }

    @Test
    public void testContain() {
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        assertTrue(arrayList.contains("A"));
    }

    @Test
    public void testIndexBoundsExceptionRemove() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        IndexOutOfBoundsException message =
                assertThrows(IndexOutOfBoundsException.class, () -> arrayList.remove(1));

        System.out.println(message.getMessage());
    }

    @Test
    public void testArrayIndexBoundsExceptionLessThenSize() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        IndexOutOfBoundsException message =
                assertThrows(IndexOutOfBoundsException.class, () -> arrayList.add(1, -1));

        System.out.println(message.getMessage());
    }

    @Test
    public void testIndexBoundsExceptionMoreThenSize() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        IndexOutOfBoundsException message =
                assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(2));

        System.out.println(message.getMessage());
    }

    @Test
    public void testThrowsIndexOut() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        assertEquals(1, arrayList.size());
        IndexOutOfBoundsException message =
                assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(2));

        System.out.println(message.getMessage());
    }
}
