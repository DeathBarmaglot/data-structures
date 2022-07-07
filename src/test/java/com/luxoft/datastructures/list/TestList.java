package com.luxoft.datastructures.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public abstract class TestList {
    private ArrayList arrayList = new ArrayList();
    private Iterator<Object> iterator = arrayList.iterator();
    private List<String> list;

    @BeforeEach
    public void before() {
        list = getList();
        list.add("A");
        list.add("B");
    }

    protected abstract List<String> getList();


    @Test
    void addNullObjects() {
        list.add(null);
        assertNull(list.get(2));
        assertEquals("B", list.get(1));
    }

    @Test
    void addByIndex() {
        list.add("O");
        list.add("I");
        list.add("E", 2);
        list.add("K", 0);
        list.add("L", 1);
        assertEquals(0, list.indexOf("K"));
        assertEquals(1, list.indexOf("L"));
    }

    @Test
    void removeByIndex() {
        list.add("C");
        list.add("K");
        assertEquals(4, list.size());
        String removedElement = list.remove(2);
        assertEquals(3, list.size());
        assertEquals("C", removedElement);
        list.remove(0);
        assertEquals("B", list.get(0));
    }

    @Test
    void removingNotExistingElement() {
        list.remove(1);
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
    }

    @Test
    void removingNotExistingElementInEmptyList() {
        list.remove(1);
        list.remove(0);
        assertThrows(IllegalStateException.class, () -> list.remove(0));
    }

    @Test
    void getByIndex() {
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
    }

    @Test
    void setByIndex() {
        String oldElementWithIndex0 = list.set("O", 0);
        assertEquals("A", oldElementWithIndex0);
        assertEquals("O", list.get(0));
    }


    @Test
    void clear() {
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    void size() {
        list.add("C");
        assertEquals(3, list.size());
    }

    @Test
    void isEmpty() {
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    void contains() {
        assertTrue(list.contains("A"));
    }

    @Test
    void listDoesntContainSuchElement() {
        assertFalse(list.contains("L"));
    }

    @Test
    void indexOf() {
        list.add("A");
        assertEquals(0, list.indexOf("A"));
        assertEquals(-1, list.indexOf("Z"));
    }

    @Test
    void lastIndexOf() {
        list.add("A");
        assertEquals(2, list.lastIndexOf("A"));
        assertEquals(-1, list.indexOf("Z"));
    }

    @Test
    void noSuchElementForLastLastIndexOf() {
        assertEquals(-1, list.lastIndexOf("I"));
    }


    @Test
    void gettingNonExistingElementInIterator() {
        list.add("A");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if ("A".equals(iterator.next())) {
                iterator.remove();
            }
        }
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @DisplayName("Test Iterator Next Value Return True")
    @Test
    public void testNextAndGetTrue() {
        arrayList.add("A");
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), arrayList.get(0));
        assertFalse(iterator.hasNext());
    }

    @DisplayName("Test Counter And Size Return True")
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

    @DisplayName("Test remove Check HasNext")
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


    @DisplayName("Test Set Method")
    @Test
    public void testSet() {
        arrayList.add("A");
        assertEquals(arrayList.get(0), arrayList.set("B", 0));
    }

    @DisplayName("Test Add Difference Elements with Index")
    @Test
    public void testAdd() {
        arrayList.add("A");
        arrayList.add("B");
        assertEquals(2, arrayList.size());
        arrayList.add(new int[]{0, 1, 2, 3}, 2);
        arrayList.add("D", 6);
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
        assertEquals("B", arrayList.remove(1));
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

    @DisplayName("Test Find Negative Index")
    @Test
    public void testFindNegativeIndex() {
        arrayList.add("A");
        assertEquals(-1, arrayList.indexOf("B"));
        assertEquals(-1, arrayList.lastIndexOf("C"));
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

        assertEquals("Index 1 more than size", message.getMessage());
    }

    @DisplayName("Test Array Index Bounds Exception Less Then Size")
    @Test
    public void testArrayIndexBoundsExceptionLessThenSize() {
        arrayList.add(1);
        IndexOutOfBoundsException message =
                assertThrows(IndexOutOfBoundsException.class, () -> arrayList.set(1, -1));
        assertEquals("Index -1 out of bounds for length 20", message.getMessage());
    }

    @DisplayName("Test Index Bounds Exception More Then Size")
    @Test
    public void testIndexBoundsExceptionMoreThenSize() {
        arrayList.add(1);
        IndexOutOfBoundsException message =
                assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(2));
        assertEquals("Index 2 more than size", message.getMessage());
    }

    @DisplayName("Test Index Bounds Exception Remove is Empty")
    @Test
    public void testIndexBoundsExceptionIsEmpty() {
        IndexOutOfBoundsException message =
                assertThrows(IndexOutOfBoundsException.class, () -> arrayList.remove(3));
        assertEquals("Index 3 more than size", message.getMessage());
    }

    @DisplayName("Test Null element in value")
    @Test
    public void testNullElementInValue() {
        NullPointerException message =
                assertThrows(NullPointerException.class, () -> arrayList.add(null));
        assertEquals("Null element in value", message.getMessage());
    }

    @Test
    void throwExceptionWhenIterationDidntStart() {
        Iterator<String> iterator = list.iterator();
        assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    @DisplayName("Test Add method and capacity increase")
    void testAddAndCapacityIncrease() {
        for (int i = 0; i < 20; i++) {
            list.add(String.valueOf(i));
        }
        assertEquals(20, list.size());
    }

    @Test
    @DisplayName("Test Add null")
    void testAddNull() {
        list.add("A");
        list.add("B");
        list.add("C");
        list.add(null);
        list.add(null);
        assertEquals(3, list.size());
    }

    @Test
    @DisplayName("Test Add and Remove method if index does not exceed bounds")
    void testAddIfIndexInBounds() {
        list.add("A", 0);
        list.add("B", 1);
        list.add("C", 2);
        list.add("D", 2);
        list.add("E", 2);
        assertEquals("D", list.remove(3));
        assertEquals("A", list.remove(0));
        assertEquals("B", list.remove(0));
        assertEquals("E", list.remove(0));
        assertEquals("C", list.remove(0));
        assertEquals(0, list.size());
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    @DisplayName("Test Add method if index exceeds bounds")
    void testAddIfIndexOutOfBounds() {
        list.add("A");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.add("B", 2));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.add("C", -1));
    }

    @Test
    @DisplayName("Test Get method if index does not exceed bounds")
    void testGetIfIndexInBounds() {
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
        assertEquals(3, list.size());
    }

    @Test
    @DisplayName("Test Get method if index exceeds bounds")
    void testGetIfIndexOutOfBounds() {
        list.add("A");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    }

    @Test
    @DisplayName("Test Set method if index does not exceed bounds")
    void testSetIfIndexInBounds() {
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals(3, list.size());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
        list.set("D", 0);
        assertEquals("D", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
        assertEquals(3, list.size());
    }

    @Test
    @DisplayName("Test Set method if index exceeds bounds")
    void testSetIfIndexOutOfBounds() {
        list.add("A");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.set("D", 1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.set("H", -1));
    }

    @Test
    @DisplayName("Test Clear method")
    void testClear() {
        list.add("A");
        list.add("B");
        list.add("C");
        list.clear();
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    @DisplayName("Test Size change method")
    void testSizeChange() {
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals(3, list.size());
        list.add("D", 3);
        assertEquals(4, list.size());
        list.add("E", 1);
        assertEquals(5, list.size());
        assertEquals("D", list.get(4));
    }

    @Test
    @DisplayName("Test IsEmpty method")
    void testIsEmpty() {
        Assertions.assertTrue(list.isEmpty());
        list.add("A");
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    @DisplayName("Test Contains method")
    void testContainsWithTwoStrings() {
        list.add("A");
        list.add("B");
        Assertions.assertTrue(list.contains("A"));
        Assertions.assertFalse(list.contains("C"));
    }

    @Test
    @DisplayName("Test IndexOf method")
    public void testIndexOf() {
        list.add("A");
        list.add("B");
        list.add("A");
        list.add("C");
        assertEquals(0, list.indexOf("A"));
        Assertions.assertNotEquals(2, list.indexOf("A"));
    }

    @Test
    @DisplayName("Test LastIndexOf method")
    public void testLastIndexOf() {
        list.add("A");
        list.add("B");
        list.add("A");
        list.add("C");
        Assertions.assertNotEquals(0, list.lastIndexOf("A"));
        assertEquals(2, list.lastIndexOf("A"));
    }


    @Test
    @DisplayName("Test Iterator Next and Remove methods")
    void testIteratorNextAndRemove() {
        list.add("A");
        list.add("B");
        list.add("C");
        Iterator<String> iterator = list.iterator();
        assertEquals("A", iterator.next());
        assertEquals("B", iterator.next());
        assertEquals("C", iterator.next());
        iterator.remove();
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(2));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    }

    @Test
    @DisplayName("Test Iterator Next method if the element does not exist")
    void testIteratorNextIfTheElementDoesNotExist() {
        list.add("A");
        Iterator<String> iterator = list.iterator();
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            iterator.next();
            iterator.next();
        });
    }

    @Test
    @DisplayName("Test Iterator Remove method if the element does not exist")
    void testIteratorRemoveIfTheElementDoesNotExist() {
        list.add("A");
        Iterator<String> iterator = list.iterator();
        Assertions.assertThrows(IllegalStateException.class, iterator::remove);
    }
}
