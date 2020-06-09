package ch03.exercise.pr16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class Pr16Test {

    @Test
    void reverseIteratorTest(){
        Pr16.MyArrayList_PR16<String> l = new Pr16.MyArrayList_PR16();
        l.add("A");
        l.add("B");
        l.add("C");
        Iterator<String> ritr = l.reverseIterator();
        while(ritr.hasNext())
            System.out.println(ritr.next());
        Iterator<String> ritr1 = l.reverseIterator();
        while(ritr1.hasNext()){
            System.out.println(ritr1.next());
            ritr1.remove();
        }
        Assertions.assertEquals(0,l.size());

    }

}