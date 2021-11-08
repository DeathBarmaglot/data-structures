package com.luxoft.datastructures.list;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.IntStream;

public class ArrayList implements List{
    private int size;
    private Object[] array = new Object[10];

    @Override
    public void add(Object value) {
    add(value, size);
    }


    @Override
    public void add(Object value, int index) {
        if (index==size){
            capacity();
        }

        checkNull(value);
        if (size - index >= 0) System.arraycopy(array, index, array, index + 1, size - index);

        size++;
        array[index] = value;
    }


    private void capacity() {
        Object[] newArray = new Object[array.length*2];
        System.arraycopy(array,0,newArray,0,array.length);
        array = newArray;
    }

    private void checkMaxSize(int index) {
        if(index >= size) {
            throw new IndexOutOfBoundsException("Index "+ index + " more than size ArrayList");
        }
    }

    private void checkNull(Object value) {
        if(value ==null){
            throw  new NullPointerException("Null element in value");
        }
    }


    @Override
    public Object remove(int index) {
//                System.arraycopy(array,index+1, array, index, size - index -1);

        checkMaxSize(index);

        Object result = array[index];

        IntStream.range(index, size).forEach(i -> array[i] = array[i + 1]);
        array[size-1] = null;
        size--;

        return result;
    }


    @Override
    public Object get(int index) {
        checkMaxSize(index);
        return array[index];
    }

    @Override
    public Object set(Object value, int index) {

        checkMaxSize(index);
        checkNull(value);

        Object result = array[index];
        array[index] = value;
        return result;
    }

    @Override
    public void clear() {
        Arrays.fill(array, null);
        size = 0;
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
        checkNull(value);
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(Object value) {

        checkNull(value);

        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {

        checkNull(value);

        for (int i = size-1; i >= 0; i--){
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
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