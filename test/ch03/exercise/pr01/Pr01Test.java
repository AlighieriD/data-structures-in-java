package ch03.exercise.pr01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Pr01Test {
    private Pr01 pr01;

    @BeforeEach
    void setUp() {
        pr01 = new Pr01();
    }

    @AfterEach
    void tearDown() {
        pr01 = null;
    }

    @Test
    void printLots(){
        List<String> L = new LinkedList<>();
        L.add("0");
        L.add("1");
        L.add("2");
        L.add("3");
        L.add("4");
        L.add("5");
        L.add("6");
        L.add("7");
        L.add("8");
        List<Integer> P = new ArrayList<>();
        P.add(1);
        P.add(3);
        P.add(5);
        P.add(7);
        P.add(90);
        Assertions.assertArrayEquals(new String[] {"1","3","5","7"}, pr01.printLots(L,P).toArray());
    }

}