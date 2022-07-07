package com.luxoft.datastructures.list;

import java.util.*;
import java.util.stream.IntStream;

public class ArrayList<E> extends AbstractList<E> {
    private static final double THRESHOLD = 1.5;
    private static final int CAPACITY = 10;

    private E[] array = (E[]) new Object[CAPACITY];

    @Override
    public void add(E value) {
        add(value, size);
    }

    @Override
    public void add(E value, int i) {
        checkNull(value);
        ensureCapacity();
        if (array.length > 0) {
            System.arraycopy(array, i, array, i + 1, size - i);
            array[i] = value;
            size++;
        }
    }

    private void ensureCapacity() {
        System.arraycopy(array, 0, new Object[(int) (array.length * THRESHOLD)], 0, size);
    }

    @Override
    public E remove(int i) {
        check(i, size);
        E node = array[i];

        if (i < size - 1) {
            System.arraycopy(array, i + 1, array, i, size - i - 1);
        }
        array[--size] = null;
        return node;

    }

    //TODO
    @Override
    public E get(int index) {
        check(index, size);
        return array[index];
    }

    @Override
    public void clear() {
        Arrays.fill(array, null);
        size = 0;
    }

    @Override
    public E set(E value, int i) {
        check(i, size);
        E pre = array[i];
        array[i] = value;
        return pre;
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
    public boolean contains(E value) {
        return IntStream.range(0, size / 2).anyMatch(i -> Objects.equals(array[i], value) || Objects.equals(array[size - i - 1], value));
    }

    @Override
    public int indexOf(E value) {
        return IntStream.range(0, size).filter(i -> Objects.equals(array[i], value)).findFirst().orElse(-1);
    }

    @Override
    public int lastIndexOf(E value) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(array[i], value)) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            joiner.add(array[i].toString());
        }
        return joiner.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<E> {
        private int index;

        @Override
        public boolean hasNext() {
            return index < size && (size != 0);
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("There is no such element");
            }
            return array[index++];
        }

        @Override
        public void remove() {
            if (index == 0) {
                throw new UnsupportedOperationException("There is no elements for removing");
            }
            ArrayList.this.remove(--index);
        }
    }

    private void check(int index, int size) {
        checkMaxSize(index);
        if (size == 0) {
            throw new IllegalStateException("IllegalStateException");
        }
        if (index < 0) {
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException:");
        }
    }

    private void checkMaxSize(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " more than size");
        }
    }

    private void checkNull(E value) {
        if (value == null) {
            throw new NullPointerException("Null element in value");
        }
    }


}
