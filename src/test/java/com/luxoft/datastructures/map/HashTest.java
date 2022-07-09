package com.luxoft.datastructures.map;

import org.junit.jupiter.api.Test;

class HashTest {

    @Test
    public static void main(String[] args) {
        HashMap map = new HashMap<>(25);
        System.out.println(map);
//        IntStringCappedMap map = new IntStringCappedMap(25);
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(12, "Twelve");
        map.put(9, "Nine");
        map.put(1, "One");
        System.out.println(map);
        java.util.HashMap<Object, Object> objectObjectHashMap = new java.util.HashMap<>();
        System.out.println(objectObjectHashMap.hashCode());

//        System.out.println(new TreeMap<>(map));
//    assert ("{1=One, 7=Seven, 8=Eight, 9=Nine, 12=Twelve}");

    }

    @Test
    void iterator() {
    }

    @Test
    void put() {
    }

    @Test
    void get() {
    }

    @Test
    void containsKey() {
    }

    @Test
    void remove() {
    }

    @Test
    void size() {
    }
}