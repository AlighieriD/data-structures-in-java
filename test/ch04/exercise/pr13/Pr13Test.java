package ch04.exercise.pr13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by YH on 2020/7/5.
 */
class Pr13Test {


    @Test
    void insert(){
        Pr13.MyTreeSet_Pr13 m = new Pr13.MyTreeSet_Pr13();
        m.insert("E");
        m.insert("A");
        m.insert("D");
        m.insert("B");
        m.insert("C");
        m.insert("G");
        m.insert("F");
        m.print();
    }

    @Test
    void remove(){
        Pr13.MyTreeSet_Pr13 m = new Pr13.MyTreeSet_Pr13();
        m.insert("E");
        m.insert("A");
        m.insert("D");
        m.insert("B");
        m.insert("C");
        m.insert("G");
        m.insert("F");
        m.remove("A");
        m.print();
    }
}