package com.luxoft.datastructures.arraylist;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Abstract Data Type
public class ArrayListTest {
    ArrayList arrayList = new ArrayList();

    @Test
    public void testAdd() {
        arrayList.add("A");
        arrayList.add("B");
        assertEquals(2, arrayList.size());
        arrayList.add("A", 2);
        arrayList.add("B", 6);
        assertEquals(4, arrayList.size());
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
                assertThrows(IndexOutOfBoundsException.class, () -> arrayList.add(1,-1));

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
