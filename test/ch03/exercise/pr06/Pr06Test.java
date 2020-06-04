package ch03.exercise.pr06;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by YH on 2020/6/3.
 */
class Pr06Test {

    private Pr06 pr06;

    @BeforeEach
    void setup(){
        pr06 = new Pr06();
    }

    @AfterEach
    void teardown(){
        pr06 = null;
    }

    @Test
    void josephus() {
        int n1 = 5, m1 = 0;
        Assertions.assertEquals(5,pr06.josephus(n1,m1));
        int n2 = 5, m2 = 1;
        Assertions.assertEquals(3,pr06.josephus(n2,m2));
        int n3 = 5, m3 = 2;
        Assertions.assertEquals(4,pr06.josephus(n3,m3));
    }

}