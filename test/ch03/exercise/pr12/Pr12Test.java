package ch03.exercise.pr12;

import ch03.exercise.pr11.Pr11;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by YH on 2020/6/6.
 */
class Pr12Test {


    private Pr12.MyLinkedList_PR12<String> l;

    @BeforeEach
    void setup(){
        l = new Pr12.MyLinkedList_PR12<>();
    }

    @AfterEach
    void teardown(){
        l = null;
    }

    @Test
    void getSizeTest(){
        Assertions.assertEquals(0,l.getSize());
        l.addIfAbsent("A");
        Assertions.assertEquals(1,l.getSize());
        l.removeIfPresent("A");
        Assertions.assertEquals(0,l.getSize());
    }

    @Test
    void printListTest(){
        l.addIfAbsent("A");
        l.addIfAbsent("B");
        l.addIfAbsent("C");
        l.addIfAbsent("A");
        l.printList();
    }

    @Test
    void isContainsTest(){
        Assertions.assertFalse(l.isContains("A"));
        l.addIfAbsent("A");
        Assertions.assertTrue(l.isContains("A"));
    }


    @Test
    void addIfAbsentTest(){
        l.addIfAbsent("A");
        l.addIfAbsent("V");
        l.addIfAbsent("Q");
        l.addIfAbsent("A");
        l.addIfAbsent("V");
        l.printList();
        Assertions.assertEquals(l.getSize(),3);
    }

    @Test
    void removeIfPresentTest(){
        l.addIfAbsent("A");
        l.addIfAbsent("B");
        l.removeIfPresent("V");
        l.removeIfPresent("A");
        l.printList();
        Assertions.assertEquals(1,l.getSize());

    }
}