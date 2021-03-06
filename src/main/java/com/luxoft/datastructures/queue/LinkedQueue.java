package com.luxoft.datastructures.queue;

import java.util.Iterator;
import java.util.Objects;
import java.util.StringJoiner;

public class LinkedQueue implements Queue {

    private Node head;
    private int size;

    @Override
    public void enqueue(Object value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        size++;
    }

    @Override
    public Object dequeue() {
        if (size == 0) {
            throw new IllegalStateException();
        }
        Object result = head.value;
        head = head.next;
        size--;
        return result;
    }

    @Override
    public Object peek() {
        return head.value;
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
        Node current = head;
        while (current != null) {
            if (Objects.equals(current.value, value)) {
                return true;
            }

            current = current.next;
        }
        return false;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        Node current = head;
        while (current != null) {
            stringJoiner.add(current.value.toString());
            current = current.next;
        }

        return stringJoiner.toString();
    }

    @Override
    public Iterator<Object> iterator() {
        return new QueueIterator();
    }

    public class QueueIterator implements Iterator<Object> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Object next() {
            Object value = head;
            index++;
            return value;

        }
    }
}