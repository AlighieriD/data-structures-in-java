package ch03.learn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    @Test
    void size() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        Assertions.assertEquals(0,myArrayList.size());
        myArrayList.add("A");
        myArrayList.add("B");
        Assertions.assertEquals(2,myArrayList.size());
    }

    @Test
    void isEmpty() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        Assertions.assertTrue(myArrayList.isEmpty());
        myArrayList.add("A");
        myArrayList.add("B");
        Assertions.assertFalse(myArrayList.isEmpty());

    }

    @Test
    void get() {
        MyArrayList<String> m = new MyArrayList<>();
        m.add("A");
        m.add("B");
        m.add("C");
        m.add("D");
        m.add("E");
        m.add("F");
        m.add("G");
        Assertions.assertEquals("C",m.get(2));
    }

    @Test
    void set() {
        MyArrayList<String> m = new MyArrayList<>();
        m.add("A");
        m.add("B");
        m.add("C");
        m.add("D");
        m.add("E");
        m.add("F");
        m.add("G");
        m.set(0,"O");
        Assertions.assertEquals("O",m.get(0));
    }

    @Test
    void add() {
        MyArrayList<String> m = new MyArrayList<>();
        m.add("A");
        m.add("B");
        Assertions.assertEquals(2,m.size());
    }

    @Test
    void add1() {
        MyArrayList<String> m = new MyArrayList<>();
        m.add("A");
        m.add("B");
        m.add(1,"D");
        Assertions.assertEquals("D",m.get(1));
    }

    @Test
    void remove() {
        MyArrayList<String> m = new MyArrayList<>();
        m.add("A");
        m.add("B");
        Assertions.assertEquals("B",m.remove(1));
        Assertions.assertEquals(1,m.size());
    }

    @Test
    void iterator() {
        MyArrayList<String> m = new MyArrayList<>();
        m.add("A");
        m.add("B");
        m.add("C");
        m.add("D");
        m.add("E");
        m.add("F");
        m.add("G");
        for (String s :m) {
            System.out.println(s);
        }

    }
}