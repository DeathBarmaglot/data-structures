package com.luxoft.datastructures.list;

import java.util.Iterator;
import java.util.StringJoiner;

public class DoubleLinkedList<T> implements List<T> {

    Node<T> head;
    Node<T> tail;
    int size;

    @Override
    public void add(T value) {
        add(value, size);
    }

    @Override
    public void add(T value, int index) {
        checkNull(value);
        // && value != null

        if (index >= 0) {

            Node<T> node = new Node<>(value);
            if (size == 0) {
                head = tail = node;
            } else if (index == size) {
                tail.prev = tail;
                tail.next = node;
                node.prev = tail;
                tail = node;
            } else if (index == 0) {
                head.prev = node;
                node.next = head;
                head = node;
            } else {
                node.next = getNode(index);
                node.prev = node.next.prev;
                node.next.prev = node;
                node.prev = node.next;
            }
            size++;
        }
    }

    @Override
    public T remove(int index) {

        checkRangeSize(index);
        Node<T> current = head;
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
        assert current != null;
        return current.value;
    }

    @Override
    public T get(int index) {
        checkRangeSize(index);
        return getNode(index).value;
    }

    @Override
    public T set(T value, int index) {
        checkNull(value);
        checkRangeSize(index);
        Node<T> result = getNode(index);
        T oldValue = result.value;
        result.value = value;
        return oldValue;
    }

    private Node<T> getNode(int index) {
        Node<T> result;
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
    public boolean contains(T value) {
        checkNull(value);
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(T value) {
        checkNull(value);
        Node<T> current = head;
        for (int index = 0; index < size - 1; index++) {
            if (value.equals(current.value)) {
                return index;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T value) {
        checkNull(value);
        Node<T> node = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (value.equals(node.value)) {
                return i;
            }
            node = node.prev;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        Node<T> current = head;
        for (int i = 0; i < size; i++) {

            stringJoiner.add(current.value.toString());
            current = current.next;

        }
        return stringJoiner.toString();
    }


    @Override
    public Iterator<T> iterator() {
        return new DoubleLinkedListIterator();
    }

    private class DoubleLinkedListIterator implements Iterator<T> {
        private Node<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T value = current.value;
            current = current.next;
            return value;
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }


    private void checkNull(T value) {
        if (value == null) {
            throw new NullPointerException("Null element in value");
        }
    }

    private void checkRangeSize(int index) {
        if (0 > index || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " more than size");
        }
    }
}