package ch03.exercise.pr18;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by YH on 2020/6/10.
 */
class Pr18Test {

    @Test
    void test(){
        Pr18.MyLinkedList_PR18<String> m = new Pr18.MyLinkedList_PR18<>();
        m.addFirst("A");
        Assertions.assertEquals(m.getFirst(),m.getLast());
        m.addFirst("B");
        Assertions.assertEquals("A",m.getLast());
        Assertions.assertEquals("B",m.getFirst());
        m.addLast("C");
        Assertions.assertEquals("C",m.get(2));
        m.removeFirst();
        Assertions.assertEquals("A",m.getFirst());
        Assertions.assertEquals("C",m.getLast());
    }

}