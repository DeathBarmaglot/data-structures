package com.luxoft.datastructures.list;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {
    ArrayList arrayList = new ArrayList();
    Iterator iterator = arrayList.iterator();

    @DisplayName("Test Next Value Return True")
    @Test
    public void testNextAndGetTrue() {
        arrayList.add("A");
        assertEquals(iterator.next(), arrayList.get(0));
    }

    @DisplayName("Test Counter And Size Return True")
    @Test
    public void testCounter() {
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        int count = 0;
        while (iterator.hasNext()){
            count++;
            iterator.next();
        }
        assertEquals(count, arrayList.size());
    }

    @DisplayName("Test remove")
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

    @DisplayName("Test Has Next Return True")
    @Test
    public void testHasNextTrue() {
        arrayList.add("A");
        assertTrue(iterator.hasNext());
        assertEquals(1, arrayList.size());
    }

    @DisplayName("Test Has Next Return False")
    @Test
    public void testHasNextFalse() {
        assertFalse(iterator.hasNext());
        assertTrue(arrayList.isEmpty());
    }

    @DisplayName("Test Push And Next Iterator")
    @Test
    public void testPushAndIterator() {
        arrayList.add("A");
        assertEquals(arrayList.get(0), iterator.next());
    }


    @DisplayName("Test Add Diff Elements with Index")
    @Test
    public void testAdd() {
        arrayList.add("A");
        arrayList.add("B");
        assertEquals(2, arrayList.size());
        arrayList.add("A", 2);
        arrayList.add("B", 6);
        assertEquals(4, arrayList.size());
    }

    @DisplayName("Test Add And Remove Elements with Index")
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

    @DisplayName("Test Remove Elements with Index")
    @Test
    public void testRemoveElements() {
        arrayList.add("A");
        arrayList.add("B", 1);
        assertEquals(2, arrayList.size());
        arrayList.remove(1);
        assertEquals(1, arrayList.size());
        assertEquals("A", arrayList.get(0));
    }

    @DisplayName("Test Find Last Index")
    @Test
    public void testFindLastIndex() {
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("A");
        arrayList.add("C");
        assertEquals(2, arrayList.lastIndexOf("A"));
    }

    @DisplayName("Test Find First Index")
    @Test
    public void testFindFirstIndex() {
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("A");
        arrayList.add("C");
        assertEquals(0, arrayList.indexOf("A"));
    }
    @DisplayName("Test ToString Return True")
    @Test
    public void testToString() {
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        assertEquals("[A, B, C]", arrayList.toString());
    }

    @DisplayName("Test is Empty After Add And Clear Return True")
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
    @DisplayName("Test Contains After Add Return True")
    @Test
    public void testContains() {
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        assertTrue(arrayList.contains("A"));
    }
    @DisplayName("Test Index Bounds Exception Remove")
    @Test
    public void testIndexBoundsExceptionRemove() {

        arrayList.add(1);
        IndexOutOfBoundsException message =
                assertThrows(IndexOutOfBoundsException.class, () -> arrayList.remove(1));

        System.out.println(message.getMessage());
    }

    @DisplayName("Test Array Index Bounds Exception Less Then Size")
    @Test
    public void testArrayIndexBoundsExceptionLessThenSize() {
        arrayList.add(1);
        IndexOutOfBoundsException message =
                assertThrows(IndexOutOfBoundsException.class, () -> arrayList.add(1, -1));
        System.out.println(message.getMessage());
    }

    @DisplayName("Test Index Bounds Exception More Then Size")
    @Test
    public void testIndexBoundsExceptionMoreThenSize() {
        arrayList.add(1);
        IndexOutOfBoundsException message =
                assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(2));
        System.out.println(message.getMessage());
    }

    @DisplayName("Test Throws Index Out")
    @Test
    public void testThrowsIndexOut() {
        arrayList.add(1);
        assertEquals(1, arrayList.size());
        IndexOutOfBoundsException message =
                assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(2));
        System.out.println(message.getMessage());
    }
}
