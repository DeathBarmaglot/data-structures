package com.luxoft.datastructures.list;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedList<T> extends AbstractList<T> implements List<T> {

    private Node<T> head;
    private Node<T> tail;

    @Override
    public void add(T value, int index) {
        check(index, size + 1);
        Node<T> node = new Node<>(value);
        if (head == null) {
            head = tail = node;
        } else if (index == 0) {
            node.next = head;
            head.pre = node;
            head = node;
        } else if (index == size) {
            tail.next = node;
            node.pre = tail;
            tail = node;
        } else {
            Node<T> pre = getBy(index - 1);
            node.pre = pre;
            pre.next = node;
            node.next = pre.next;
            pre.next.pre = node;
        }
        size++;
    }

    @Override
    public T remove(int index) {
        check(index, size);
        Node<T> post;
        if (size == 1) {
            post = head;
            head = tail = null;
        } else if (index == 0) {
            post = head;
            head = head.next;
        } else if (index == size - 1) {
            post = tail;
            tail = tail.pre;
        } else {
            Node<T> pre = getBy(index - 1);
            post = pre.next;
            pre.next = pre.next.next;
            pre.next.pre = pre;
        }
        size--;
        return post.value;
    }

    @Override
    public T get(int index) {
        check(index, size);
        return getBy(index).value;
    }

    @Override
    public T set(T value, int index) {
        check(index, size);
        Node<T> node = getBy(index);
        Node<T> pre = new Node<>(node.value);
        node.value = value;
        return pre.value;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public boolean contains(T value) {
        Node<T> a = head;
        Node<T> z = tail;
        for (int i = 0; i < size / 2; i++) {
            if (Objects.equals(a.value, value)
                    || Objects.equals(z.value, value)) {
                return true;
            }
            a = a.next;
            z = z.pre;
        }
        return false;
    }

    @Override
    public int indexOf(Object o) {
        Node<T> node;
        node = head;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(node.value, o)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node<T> current;
        current = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(current.value, o)) {
                return i;
            }
            current = current.pre;
        }
        return -1;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;
            int counter = -1;

            @Override
            public boolean hasNext() {
                return (counter < size - 1) && (size != 0);
            }

            @Override
            public T next() {
                if (counter >= size - 1) {
                    throw new NoSuchElementException("There is no such element");
                }
                if (counter == -1) {
                    node = head;
                } else {
                    node = node.next;
                }
                counter++;
                return node.value;
            }

            @Override
            public void remove() {
                if (counter < 0) {
                    throw new IllegalStateException(
                            "There is no elements for removing, counter before fist element!");
                }
                node = node.pre;
                LinkedList.this.remove(counter);
                counter--;
            }
        };
    }

    private Node<T> getBy(int index) {
        Node<T> node;
        if (index < size / 2) {
            node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.pre;
            }
        }
        return node;
    }

    private static class Node<T> {

        T value;
        Node<T> next;
        Node<T> pre;

        public Node(T value) {
            this.value = value;
        }
    }

    private void check(int index, int size) {
        if (size == 0) {
            throw new IllegalStateException("IllegalStateException");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "IndexOutOfBoundsException: " + (size - 1));
        }
    }

}
