package com.luxoft.datastructures.queue;

public interface Queue extends Iterable<Object> {
    void enqueue(Object value);

    Object dequeue();

    Object peek();

    int size();

    boolean isEmpty();

    boolean contains(Object value);

    void clear();

    String toString();
}
