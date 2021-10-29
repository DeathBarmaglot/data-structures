package com.luxoft.datastructures.arraylist;

public class ArrayList implements List{
    private int size;
    private Object[][] array = new Object[10][10];

    @Override
    public void add(Object value) {
    add(value, size);
    }

    @Override
    public void add(Object value, int index) {
        if (value != null){
        array[index][size] = value;
        size++;
        }
        if (index>size){
            throw new IndexOutOfBoundsException();
        }

    }

    @Override
    public Object remove(int index) {
        Object[] result = array[index];
        for (int i = 0; i < result.length ; i++) {
            array[index][i] = null;
        }
        return result;
    }

    @Override
    public Object get(int index) {
        return array[index];
    }

    @Override
    public Object set(Object value, int index) {
        return null;
    }

    @Override
    public void clear() {
        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j < array[i].length ; j++) {
            array[i][j] = null;}
        }
        size=0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

//    // [A, B, A, C] lastIndexOf(A) -> 2
//    int lastIndexOf(Object value);
//
//    // [A, B, C]
//    String toString();
    @Override
    public boolean contains(Object value) {
        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j < array[j].length ; j++) {
                if(array[i][j].equals(value)) return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object value) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object value) {
        return 0;
    }
}