package ch01.exercise.pr03;

import ch01.exercise.pr02.Pr02;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by YH on 2020/5/8.
 */
class Pr03Test {

    private Pr03 pr03;

    @BeforeEach
    void setUp() {
        pr03 = new Pr03();
    }

    @AfterEach
    void tearDown() {
        pr03 = null;
    }

    @Test
    void printDouble() {
        pr03.print(123.1234567);
    }

}