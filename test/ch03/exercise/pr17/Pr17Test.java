package ch03.exercise.pr17;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class Pr17Test {

    @Test()
    void modTest(){
        Pr17.MyArrayList_PR17<String> m1 = new Pr17.MyArrayList_PR17<>();
        m1.add("A");
        m1.add("B");
        m1.add("C");
        Iterator<String> itr = m1.iterator();
        m1.remove(0);
        Assertions.assertThrows(ConcurrentModificationException.class,()-> itr.remove());
    }

}