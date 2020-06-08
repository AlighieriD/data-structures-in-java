package ch03.exercise.pr14;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by YH on 2020/6/7.
 */
class Pr14Test {

    Pr14.MyLinkedList_PR14<String> l ;
    @BeforeEach
    void setUp() {
        l = new Pr14.MyLinkedList_PR14<>();
    }

    @AfterEach
    void tearDown() {
        l = null;
    }

    @Test
    void listIteratorTest(){
        l.add("A");
        l.add("B");
        l.add("C");
        l.add("D");
        ListIterator<String> itr = l.listIterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
        while (itr.hasPrevious()){
            System.out.println(itr.previous());
        }
        for (int i = 0; i < 4; i++) {
            itr.next();
            itr.add(String.valueOf(i));
        }
        while (itr.hasPrevious()){
            System.out.println(itr.previous());
        }
        for (int i = 0; i < 4; i++) {
            itr.next();
            itr.next();
            itr.remove();
        }
        while (itr.hasPrevious()){
            System.out.println(itr.previous());
        }

    }

}