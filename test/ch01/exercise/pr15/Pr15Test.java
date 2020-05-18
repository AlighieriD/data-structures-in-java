package ch01.exercise.pr15;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created by YH on 2020/5/14.
 */
class Pr15Test {


    private Pr15 pr15;
    private Pr15.Rectangle[] arr;
    @BeforeEach
    void setUp() {
        pr15 = new Pr15();
        arr = new Pr15.Rectangle[]{
        new Pr15.Rectangle(10,10),
        new Pr15.Rectangle(20,2),
        new Pr15.Rectangle(100,1),
        new Pr15.Rectangle(50,50),
        new Pr15.Rectangle(99,2),
        new Pr15.Rectangle(3,70),
        };
    }

    @AfterEach
    void tearDown() {
        pr15 = null;
    }

    @Test
    void test() {
        Pr15.Rectangle r = pr15.getMaxS(arr);
        Assertions.assertEquals(r.getLength(),50);
        Assertions.assertEquals(r.getWidth(),50);
        Assertions.assertEquals(r.getLength()*r.getWidth(),2500);
    }

    @Test
    void test1() {
        Pr15.Rectangle r = pr15.getMaxC(arr);
        Assertions.assertEquals(r.getLength(),100);
        Assertions.assertEquals(r.getWidth(),1);
        Assertions.assertEquals(r.getWidth() * 2 + r.getLength() * 2,202);
    }


}