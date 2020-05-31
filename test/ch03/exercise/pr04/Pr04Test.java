package ch03.exercise.pr04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by YH on 2020/5/31.
 */
class Pr04Test {

    private Pr04 pr04;

    @BeforeEach
    void setup(){
        pr04 = new Pr04();
    }

    @AfterEach
    void teardown(){
        pr04 = null;
    }
    @Test
    void intersection() {
        List<String> list1 = new LinkedList<>();
        list1.add("A");
        list1.add("B");
        list1.add("C");
        list1.add("D");
        list1.add("F");
        list1.add(null);
        List<String> list2 = new LinkedList<>();
        list2.add("D");
        list2.add("E");
        list2.add("F");
        list2.add("G");
        list1.add(null);
        List<String> l = pr04.intersection(list1,list2);
        Assertions.assertLinesMatch(l, Arrays.asList("D","F"));
    }

}