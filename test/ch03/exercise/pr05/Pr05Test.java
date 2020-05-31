package ch03.exercise.pr05;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by YH on 2020/6/1.
 */
class Pr05Test {
    private Pr05 pr05;

    @BeforeEach
    void setup(){
        pr05 = new Pr05();
    }

    @AfterEach
    void tearDown(){
        pr05 = null;
    }

    @Test
    void union() {
        List<String> l1 = new ArrayList<>();
        l1.add("A");
        l1.add("B");
        l1.add("C");
        l1.add("D");
        l1.add("E");
        l1.add("F");
        l1.add("R");
        l1.add("Z");
        List<String> l2 = new ArrayList<>();
        l2.add("A");
        l2.add("B");
        l2.add("C");
        l2.add("D");
        l2.add("E");
        l2.add("F");
        Assertions.assertLinesMatch(pr05.union(l1,l2), Arrays.asList("A","B","C","D","E","F","R","Z"));
    }

}