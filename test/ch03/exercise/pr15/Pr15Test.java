package ch03.exercise.pr15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class Pr15Test {

    @Test
    void spliceTest(){
        Pr15.MyLinkedList_PR15<String> base = new Pr15.MyLinkedList_PR15<>();
        base.add("A");
        base.add("B");
        base.add("C");
        Pr15.MyLinkedList_PR15<String> l = new Pr15.MyLinkedList_PR15<>();
        l.add("D");
        l.add("E");
        l.add("F");
        Iterator<String> itr = base.iterator();
        itr.next();
        base.splice(itr,l);
        Assertions.assertEquals(6,base.size());
        Assertions.assertEquals(0,l.size());
    }
}