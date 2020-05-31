package ch03.learn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by YH on 2020/5/29.
 */
class MyLinkedListTest {
    @Test
    void clear() {
        MyLinkedList<String> m = new MyLinkedList<>();
        m.add("A");
        m.add("B");
        m.add("C");
        m.add("D");
        Assertions.assertEquals(4,m.size());
        m.clear();
        Assertions.assertEquals(0,m.size());
    }

    @Test
    void size() {
        MyLinkedList<String> m = new MyLinkedList<>();
        m.add("A");
        m.add("B");
        m.add("C");
        m.add("D");
        Assertions.assertEquals(4,m.size());
    }

    @Test
    void isEmpty() {
        MyLinkedList<String> m = new MyLinkedList<>();
        Assertions.assertTrue(m.isEmpty());
        m.add("A");
        Assertions.assertFalse(m.isEmpty());
    }

    @Test
    void add() {
        MyLinkedList<String> m = new MyLinkedList<>();
        m.add("A");
        Assertions.assertEquals("A",m.get(0));
    }

    @Test
    void set() {
        MyLinkedList<String> m = new MyLinkedList<>();
        m.add("A");
        m.set(0,"D");
        Assertions.assertEquals("D",m.get(0));
    }

    @Test
    void remove() {
        MyLinkedList<String> m = new MyLinkedList<>();
        m.add("A");
        m.remove(0);
        Assertions.assertTrue(m.isEmpty());
    }

    @Test
    void iterator() {
        MyLinkedList<String> m = new MyLinkedList<>();
        m.add("A");
        m.add("B");
        m.add("C");
        m.add("D");
        m.add("E");
        m.add("F");
        for (String s:m) {
            System.out.println(s);
        }
    }

}