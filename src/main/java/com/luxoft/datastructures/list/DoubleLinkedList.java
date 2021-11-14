package com.luxoft.datastructures.list;

import java.util.Iterator;
import java.util.StringJoiner;
import java.util.stream.IntStream;

public class DoubleLinkedList implements List {

    Node head;
    Node tail;
    int size;

    @Override
    public void add(Object value) {
        add(value, size);
    }

    @Override
    public void add(Object value, int index) {
        checkNull(value);

        Node newNode = new Node(value);
        if (size == 0) {
            head = tail = newNode;
        } else if (index == size - 1) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else if (index == 0) {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    @Override
    public Object remove(int index) {
        checkMaxSize(index);
        Object current = head.value;
        size--;
        if (index == 0) {
            head.prev = null;
            head = head.next;
            return current;
        }
        if (size == 0) {
            head = tail = null;
            return null;
        }

        if (index == size) {
//            current = tail.value;
//            tail.next = null;
//            tail = tail.prev;
        } else {
            tail.prev = head.next;
        }

        //set(null, index);

        return current;
    }

    @Override
    public Object get(int index) {
        checkMaxSize(index);
        return ran(index);
    }

    @Override
    public Object set(Object value, int index) {
        checkNull(value);
        checkMaxSize(index);
        Node result = ran(index);
        Object oldValue = result.value;
        result.value = value;
        return oldValue;
    }

    private Node ran(int index) {
        Node result = head;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result;
    }

    @Override
    public void clear() {
        size = 0;
        head = new Node(null);

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object value) {
        checkNull(value);
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(Object value) {
        checkNull(value);
        Node current = head;
        for (int index = 0; index < size - 1; index++) {
            if (value.equals(current.value)) {
                return index;
            }
            current = current.next;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        checkNull(value);
        Node current = tail;
        for (int index = size - 1; index >= 0; index--) {
            if (value.equals(current.value)) {
                return index;
            }
            current = current.prev;
        }

        return -1;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        Node current = head;
        IntStream.range(0, size).mapToObj(i -> current.value.toString()).forEach(stringJoiner::add);
        return stringJoiner.toString();
    }

    @Override
    public Iterator<Object> iterator() {
        return new DoubleLinkedListIterator();
    }

    private class DoubleLinkedListIterator implements Iterator<Object> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Object next() {
            Object value = current.value;
            current = current.next;
            return value;
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }


    private void checkNull(Object value) {
        if (value == null) {
            throw new NullPointerException("Null element in value");
        }
    }

    private void checkMaxSize(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " more than size ArrayList");
        }
    }
}