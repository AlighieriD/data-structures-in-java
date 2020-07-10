package ch04.exercise.pr16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by YH on 2020/7/7.
 */
class Pr16Test {

    @Test
    void insert(){
        Pr16.MyTreeSet_Pr16<String> m = new Pr16.MyTreeSet_Pr16<>();
        m.insert("G");
        m.insert("A");
        m.insert("B");
        m.insert("E");
        m.insert("C");
        m.insert("F");
        m.insert("D");
        m.print();
    }

    @Test
    void remove(){
        Pr16.MyTreeSet_Pr16<String> m = new Pr16.MyTreeSet_Pr16<>();
        m.insert("G");
        m.insert("A");
        m.insert("B");
        m.insert("E");
        m.insert("C");
        m.insert("F");
        m.insert("D");
        m.remove("A");
        m.remove("D");
        m.print();
    }

    @Test
    void find(){
        Pr16.MyTreeSet_Pr16<String> m = new Pr16.MyTreeSet_Pr16<>();
        m.insert("G");
        m.insert("A");
        m.insert("B");
        m.insert("E");
        m.insert("C");
        m.insert("F");
        m.insert("D");
        m.remove("A");
        m.remove("D");
        Assertions.assertEquals("B",m.findMin());
        Assertions.assertEquals("G",m.findMax());
    }
}