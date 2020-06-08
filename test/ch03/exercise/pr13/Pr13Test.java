package ch03.exercise.pr13;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by YH on 2020/6/7.
 */
class Pr13Test {

    Pr13.MyArrayList_PR13<String> l;

    @BeforeEach
    void setup(){
        l = new Pr13.MyArrayList_PR13<>();
    }

    @AfterEach
    void teardown(){
        l = null;
    }

    @Test
    void itr(){
        l.add("A");
        l.add("B");
        l.add("C");
        Iterator<String> iterator = l.iterator();
        while (iterator.hasNext()){
            String s = iterator.next();
            System.out.println(s);
            iterator.remove();
        }
        Assertions.assertEquals(l.size(),0);
    }

    @Test
    void listItr(){
        ListIterator<String> itr = l.listIterator();
        l.add("A");
        l.add("B");
        l.add("C");
        Assertions.assertEquals(3,l.size());
        while (itr.hasNext()){
            String s = itr.next();
            System.out.println(s);
            itr.remove();
        }
        Assertions.assertEquals(l.size(),0);
        itr.add("A");
        itr.add("B");
        itr.add("C");
        Assertions.assertEquals(3,l.size());
        while (itr.hasPrevious()){
            System.out.println(itr.previous());
            itr.remove();
        }
        Assertions.assertEquals(l.size(),0);
        l.add("A");
        l.add("C");
        l.add("E");
        itr.next();
        itr.add("B");
        itr.next();
        itr.add("D");
        ListIterator<String> itr1 = l.listIterator();
        while (itr1.hasNext()){
            String s = itr1.next();
            System.out.println(s);
        }

    }

}