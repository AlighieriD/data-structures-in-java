package ch04.exercise.pr11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by YH on 2020/7/4.
 */
class Pr11Test {

    @Test
    void insert(){
        Pr11.MyTreeSet<String> m = new Pr11.MyTreeSet<>();
        m.insert("D");
        m.insert("A");
        m.insert("C");
        m.insert("B");
        m.insert("E");
        m.insert("F");
        m.insert("0");
        m.insert("10");
        m.printTree();
    }

    @Test
    void remove(){
        Pr11.MyTreeSet<String> m = new Pr11.MyTreeSet<>();
        m.insert("D");
        m.insert("A");
        m.insert("C");
        m.insert("B");
        m.insert("E");
        m.insert("F");
        m.insert("0");
        m.insert("10");
        m.remove("10");
        m.remove("10");
        m.remove("E");
        m.remove("A");
        m.printTree();
    }

    @Test
    void contains(){
        Pr11.MyTreeSet<String> m = new Pr11.MyTreeSet<>();
        m.insert("D");
        m.insert("A");
        m.insert("C");
        m.insert("B");
        m.insert("E");
        m.insert("F");
        m.insert("0");
        m.insert("10");
        Assertions.assertTrue(m.contains("0"));
    }

    @Test
    void iterator(){
        Pr11.MyTreeSet<String> m = new Pr11.MyTreeSet<>();
        m.insert("D");
        m.insert("A");
        m.insert("C");
        m.insert("B");
        m.insert("E");
        m.insert("F");
        m.insert("0");
        m.insert("10");
        for (String s : m){
            System.out.println(s);
        }
    }
}