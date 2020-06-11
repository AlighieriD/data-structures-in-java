package ch03.exercise.pr19;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by YH on 2020/6/12.
 */
class Pr19Test {

    Pr19<String> l;

    @BeforeEach
    void setup(){
        l = new Pr19<>();
    }

    @AfterEach
    void teardown(){
        l = null;
    }

    @Test
    void clear() {
        l.add("A");
        l.add("B");
        l.add("C");
        l.add("D");
        Assertions.assertEquals(4,l.size());
        l.clear();
        Assertions.assertEquals(0, l.size());
    }

    @Test
    void add1() {
        l.add("A");
        l.add(0,"B");
        Assertions.assertEquals("B",l.get(0));
    }

    @Test
    void set() {
        l.add("A");
        l.add("B");
        l.set(1,"V");
        Assertions.assertEquals("V",l.get(1));
    }

    @Test
    void remove() {
        l.add("A");
        l.add("B");
        l.add("C");
        l.remove(1);
        Assertions.assertEquals(2,l.size());
        Assertions.assertEquals("A",l.get(0));
        Assertions.assertEquals("C",l.get(1));
    }

}