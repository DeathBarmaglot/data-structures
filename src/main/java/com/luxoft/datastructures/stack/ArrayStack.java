package com.luxoft.datastructures.stack;

import java.util.Iterator;

public class ArrayStack implements Stack, Iterable {
    private int size;
    private Object[] array;

    public ArrayStack() {
        array = new Object[5];
    }

    public ArrayStack(int initialCapacity) {
        array = new Object[initialCapacity];
    }


    @Override
    public void push(Object value) {
        ensureCapacity();
        array[size] = value;
        size++;
    }

    private void ensureCapacity() {
        if (array.length == size) {
            Object[] newArray = new Object[array.length * 2];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    @Override
    public Object pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        Object result = array[size - 1];
        size--;
        return result;
    }

    @Override
    public Object peek() {
        return array[size - 1];
    }

    @Override
    public boolean contain(Object value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(array[i])) {
                return true;
            }
        }
        return false;
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
    public void clear() {
        size = 0;
    }


    public Iterator iterator() {
        return new StackIterator();
    }

    public class StackIterator implements Iterator {
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


