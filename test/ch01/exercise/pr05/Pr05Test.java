package ch01.exercise.pr05;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created by YH on 2020/5/11.
 */
class Pr05Test {
    private Pr05 pr05;

    @BeforeEach
    void setUp() {
        pr05 = new Pr05();
    }

    @AfterEach
    void tearDown() {
        pr05 = null;
    }

    @Test
    void test() {
        int a = 0b1111;
        Assertions.assertEquals(4,pr05.getOne(a));
        int b = 0b1000;
        Assertions.assertEquals(1,pr05.getOne(b));
        int c = 0b0010;
        Assertions.assertEquals(1,pr05.getOne(c));
    }


}