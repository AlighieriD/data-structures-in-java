package ch04.exercise.pr12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by YH on 2020/7/4.
 */
class Pr12Test {


    @Test
    public void insert(){
        Pr12.MyTreeMap<String,String> m = new Pr12.MyTreeMap<>();
        m.insert("A","AAA");
        m.insert("B","BBB");
        m.insert("C","CCC");
        m.insert("A","DDD");
        m.print();
    }

    @Test
    public void remove(){
        Pr12.MyTreeMap<String,String> m = new Pr12.MyTreeMap<>();
        m.insert("A","AAA");
        m.insert("B","BBB");
        m.insert("C","CCC");
        m.insert("A","DDD");
        m.remove("A");
        m.print();
    }

    @Test
    public void get(){
        Pr12.MyTreeMap<String,String> m = new Pr12.MyTreeMap<>();
        m.insert("A","AAA");
        m.insert("B","BBB");
        m.insert("C","CCC");
        m.insert("A","DDD");
        Assertions.assertEquals("BBB",m.get("B"));
    }


}