package com.luxoft.datastructures.arraylist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// Abstract Data Type
public class ArrayListTest {
ArrayList arrayList = new ArrayList();
    @Test
    public void testAdd(){
        arrayList.add("A");
        arrayList.add("B");
        assertEquals(2,arrayList.size());
        arrayList.add("A",2);
        arrayList.add("B",6);
        assertEquals(4,arrayList.size());
}

//    // we can add value by index between [0, size]
//    // otherwise throw new IndexOutOfBoundsException
//    void add(Object value, int index);
//
//    // we can remove value by index between [0, size - 1]
//    // otherwise throw new IndexOutOfBoundsException
//
//    // [A, B, C] remove = 0
//    // [B (index = 0) , C (index = 1)]
//    Object remove(int index);
//
//    // [A, B, C, null, null] size = 3
//    // we can get value by index between [0, size - 1]
//    // otherwise throw new IndexOutOfBoundsException
//    Object get(int index);
//
//    // we can set value by index between [0, size - 1]
//    // otherwise throw new IndexOutOfBoundsException
//    Object set(Object value, int index);
//
//    void clear();
//
//    int size();
//
//    boolean isEmpty();
//
//    boolean contains(Object value);
//
//    // [A, B, A, C] indexOf(A) -> 0
//    // -1 if not exist
//    int indexOf(Object value);
//
//    // [A, B, A, C] lastIndexOf(A) -> 2
//    int lastIndexOf(Object value);
//
//    // [A, B, C]
//    String toString();

    @Test
    public void testArrayIndexBoundsExceptionLessThenSize(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(1, -1);
        IndexOutOfBoundsException message =
                assertThrows(IndexOutOfBoundsException.class, () -> {arrayList.add(1,-1);});

        message.getMessage();
    }

    @Test
    public void testIndexBoundsExceptionMoreThenSize(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        IndexOutOfBoundsException message =
                assertThrows(IndexOutOfBoundsException.class, () -> {arrayList.add(2,2);});

        message.getMessage();
    }

    @Test
    public void testThrowsIndexOut(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        IndexOutOfBoundsException message =
                assertThrows(IndexOutOfBoundsException.class, () -> {arrayList.get(1);});
        assertEquals(1, arrayList.size());
        message.getMessage();
        }
    }
