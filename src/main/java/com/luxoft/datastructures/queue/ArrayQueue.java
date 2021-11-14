package com.luxoft.datastructures.queue;

import java.util.Iterator;
import java.util.StringJoiner;

public class ArrayQueue implements Queue {
    private int size;
    private final Object[] array = new Object[5];


    @Override
    public void enqueue(Object value) {
        array[size] = value;
        size++;
    }

    @Override
    public Object dequeue() {
        if (size == 0) {
            return new IllegalStateException("Queue is Empty");
        } else {
            Object result = array[size - 1];
            array[size - 1] = null;
            size--;
            return result;
        }
    }

    @Override
    public Object peek() {
        if (size == 0) {
            return null;
        } else {
            return array[0];
        }
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
        for (Object o : array) {
            if (value.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            stringJoiner.add(array[i].toString());
        }
        return stringJoiner.toString();
    }

    public Iterator<Object> iterator() {
        return new ArrayQueue.QueueIterator();
    }

    public class QueueIterator implements Iterator<Object> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Object next() {
            Object value = array[index];
            index++;
            return value;

        }
    }
}
