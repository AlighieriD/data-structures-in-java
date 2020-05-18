package ch02.learn;

import ch01.exercise.pr01.Pr01;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.DataGenerate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by YH on 2020/5/19.
 */
class MaxSubSumTest {
    private MaxSubSum maxSubSum;
    @BeforeEach
    void setUp() {
        maxSubSum = new MaxSubSum();
    }

    @AfterEach
    void tearDown() {
        maxSubSum = null;
    }

    @Test
    void maxSubSum1() {
        int[] arr = {-2,11,-4,13,-5,-2,-10};
        Assertions.assertEquals(20,maxSubSum.maxSubSum1(arr));
    }

    @Test
    void maxSubSum2() {
        int[] arr = {-2,11,-4,13,-5,-2,-10};
        Assertions.assertEquals(20,maxSubSum.maxSubSum2(arr));
    }

}