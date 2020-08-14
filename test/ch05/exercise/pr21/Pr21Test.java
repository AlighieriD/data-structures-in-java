package ch05.exercise.pr21;

import ch01.exercise.pr04.Pr04;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Pr21Test {

    @Test
    void wordTest() throws FileNotFoundException {
//        String dictName = Pr21.class.getResource("dict.txt").getPath();
        String file = Pr04.class.getResource("B.txt").getPath();
        Map<String,Pr21.Entry> m = Pr21.wordTest();
        System.out.println(m.entrySet().size());
    }
}