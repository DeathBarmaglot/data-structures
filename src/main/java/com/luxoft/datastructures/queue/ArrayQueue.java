package com.luxoft.datastructures.queue;

import java.util.StringJoiner;

public class ArrayQueue implements Queue {
	private int size;
	private Object[] array = new Object[5];


    @Override
    public void enqueue(Object value) {
    array[size] = value;
    size++;
    }

    @Override
    public Object dequeue() {
    	if (size == 0){
        return new IllegalStateException("Queue is Empty");}
        else {
        	Object result = array[size-1];
        	array[size-1] = null;
        	size--;
        	return result;}
    }

    @Override
    public Object peek() {
    	if (size == 0){
        return null;}
        else {return array[0];}
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    @Override
    public boolean contains(Object value) {
        for (int i = 0; i < array.length; i++) {
            if(value.equals(array[i])){
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
        StringJoiner stringJoiner = new StringJoiner(", ","[","]");
        for (int i = 0; i < size; i++) {
            stringJoiner.add(array[i].toString());
        }
        return stringJoiner.toString();
    }
}
