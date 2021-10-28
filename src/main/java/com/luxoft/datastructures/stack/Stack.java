package com.luxoft.datastructures.stack;

public interface Stack {

    void push(Object value);
    Object pop();
    Object peek();
    boolean contain(Object value);
    int size();
    boolean isEmpty();
    void clear();
}
