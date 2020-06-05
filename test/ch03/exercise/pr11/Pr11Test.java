package ch03.exercise.pr11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by YH on 2020/6/5.
 */
class Pr11Test {

    @Test
    void getSizeTest(){
        Pr11.MyLinkedList_PR11<String> l = new Pr11.MyLinkedList_PR11<>();
        Assertions.assertEquals(0,l.getSize());
        l.addIfAbsent("A");
        Assertions.assertEquals(1,l.getSize());
        l.removeIfPresent("A");
        Assertions.assertEquals(0,l.getSize());
    }

    @Test
    void printListTest(){
        Pr11.MyLinkedList_PR11<String> l = new Pr11.MyLinkedList_PR11<>();
        l.addIfAbsent("A");
        l.addIfAbsent("B");
        l.addIfAbsent("C");
        l.addIfAbsent("A");
        l.printList();
    }

    @Test
    void isContainsTest(){
        Pr11.MyLinkedList_PR11<String> l = new Pr11.MyLinkedList_PR11<>();
        Assertions.assertFalse(l.isContains("A"));
        l.addIfAbsent("A");
        Assertions.assertTrue(l.isContains("A"));
    }


    @Test
    void addIfAbsentTest(){
        Pr11.MyLinkedList_PR11<String> l = new Pr11.MyLinkedList_PR11<>();
        l.addIfAbsent("A");
        l.addIfAbsent("V");
        l.addIfAbsent("Q");
        l.addIfAbsent("A");
        l.addIfAbsent("V");
        Assertions.assertEquals(l.getSize(),3);
    }

    @Test
    void removeIfPresentTest(){
        Pr11.MyLinkedList_PR11<String> l = new Pr11.MyLinkedList_PR11<>();
        l.addIfAbsent("A");
        l.addIfAbsent("B");
        l.removeIfPresent("V");
        l.removeIfPresent("A");
        Assertions.assertEquals(1,l.getSize());

    }



}