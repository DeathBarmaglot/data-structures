package com.luxoft.datastructures.list;

import java.util.Iterator;
import java.util.StringJoiner;

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

        if (index >= 0) {

            Node newNode = new Node(value);
            if (size == 0) {
                head = tail = newNode;
            } else if (index == size) {
                tail.prev = tail;
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            } else if (index == 0) {
                head.prev = newNode;
                newNode.next = head;
                head = newNode;
            } else {
                newNode.next = getNode(index);
                newNode.prev = newNode.next.prev;
                newNode.next.prev = newNode;
            }
            size++;
        }
    }

    @Override
    public Object remove(int index) {

        checkRangeSize(index);
        Node current = head;
        size--;
        if (index == 0) {
            head = current.next;
//            head.prev = null;
        } else if (size == 0) {
            current = head = tail = null;
        } else if (index == size) {
            current = tail;
            tail = tail.prev;
            tail.next = null;
        } else {
            current = getNode(index);
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        return current.value;
    }

    @Override
    public Object get(int index) {
        checkRangeSize(index);
        return getNode(index).value;
    }

    @Override
    public Object set(Object value, int index) {
        checkNull(value);
        checkRangeSize(index);
        Node result = getNode(index);
        Object oldValue = result.value;
        result.value = value;
        return oldValue;
    }

    private Node getNode(int index) {
        Node result;
        if (index <= size / 2) {
            result = head;
            for (int i = 0; i < index; i++) {
                result = result.next;
            }
        } else {
            result = tail;
            for (int i = size - 1; i > index; i--) {
                result = result.prev;
            }
        }
        return result;
    }

    @Override
    public void clear() {
        size = 0;
        head = tail = null;
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
        for (int i = 0; i < size; i++) {

            stringJoiner.add(current.value.toString());
            current = current.next;

        }
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

    private void checkRangeSize(int index) {
        if (0 > index || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " more than size ArrayList");
        }
    }
}