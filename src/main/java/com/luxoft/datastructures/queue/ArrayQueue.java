package com.luxoft.datastructures.queue;
//NoSuchElementException
//remove
//peek 0 -> null 
//boolean offer true if add else false
//add
//remove
public class ArrayQueue implements Queue {
	private int size;
	private Object[] array = new Object[5];


    @Override
    public void enqueue(Object value) {
    array[array.length-1] = value;
    size++;
    }

    @Override
    public Object dequeue() {
    	if (size == 0){
        return null;}
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
        for (int i = 0; i < size; i++) {
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
}
