package com.luxoft.datastructures.list;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {
    ArrayList arrayList = new ArrayList();
    Iterator<Object> iterator = arrayList.iterator();

    @Test
    public void testRemoveElements() {
        arrayList.add("A");
        arrayList.add("B", 1);
        assertEquals(2, arrayList.size());
        assertEquals("B", arrayList.remove(1));
        assertEquals(1, arrayList.size());
        assertEquals("A", arrayList.get(0));
    }

    @Test
    public void testNextAndGetTrue() {
        arrayList.add("A");
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), arrayList.get(0));
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testHasNextRemove() {
        arrayList.add("A");
        arrayList.add("B");
        iterator.next();
        iterator.next();
        arrayList.remove(1);
        assertFalse(iterator.hasNext());
        assertEquals(1, arrayList.size());
    }

    @Test
    public void testHasNextTrue() {
        arrayList.add("A");
        assertTrue(iterator.hasNext());
        assertEquals(1, arrayList.size());
    }

    @Test
    public void testHasNextFalse() {
        assertFalse(iterator.hasNext());
        assertTrue(arrayList.isEmpty());
    }

    @Test
    public void testPushAndIterator() {
        arrayList.add("A");
        assertEquals(arrayList.get(0), iterator.next());
    }


    @Test
    public void testSet() {
        arrayList.add("A");
        assertEquals(arrayList.get(0), arrayList.set("B", 0));
    }

    @Test
    public void testIndexBoundsException() {

        arrayList.add(1);
        IndexOutOfBoundsException message =
                assertThrows(IndexOutOfBoundsException.class, () -> arrayList.remove(1));

        assertEquals("Index 1 more than size", message.getMessage());
    }

    //TODO
    @Test
    public void testAdd() {
        arrayList.add("A");
        arrayList.add("B");
        assertEquals(2, arrayList.size());
        arrayList.add(new int[]{0, 1, 2, 3}, 2);
        arrayList.add("D", 6);
        assertEquals(4, arrayList.size());
    }


    @Test
    public void testCounter() {
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        int count = 0;
        while (iterator.hasNext()) {
            count++;
            iterator.next();
        }
        assertEquals(count, arrayList.size());
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
    public void testFindNegativeIndex() {
        arrayList.add("A");
        assertEquals(-1, arrayList.indexOf("B"));
        assertEquals(-1, arrayList.lastIndexOf("C"));
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
    public void testContains() {
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        assertTrue(arrayList.contains("A"));
    }

    @Test
    public void testNullElementInValue() {
        NullPointerException message =
                assertThrows(NullPointerException.class, () -> arrayList.add(null));
        assertEquals("Null element in value", message.getMessage());
    }
}
