package ch01.exercise.pr04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

/**
 * Created by YH on 2020/5/9.
 */
class Pr04Test {

    private Pr04 pr04;

    @BeforeEach
    void setUp() {
        pr04 = new Pr04();
    }

    @AfterEach
    void tearDown() {
        pr04 = null;
    }

    @Test
    void test() throws FileNotFoundException {
        String file = Pr04.class.getResource("B.txt").getPath();
        try {
            pr04.processFile(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



}