package ch01.exercise.pr06;

import ch01.exercise.pr05.Pr05;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by YH on 2020/5/11.
 */
class Pr06Test {

    private Pr06 pr06;

    @BeforeEach
    void setUp() {
        pr06 = new Pr06();
    }

    @AfterEach
    void tearDown() {
        pr06 = null;
    }

    @Test
    void test() {
        pr06.permute("abcd");
    }

}