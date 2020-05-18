package ch01.exercise.pr01;

import org.junit.jupiter.api.*;
import util.DataGenerate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by YH on 2020/5/2.
 */
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
    void getKth_1() {
        int[] arr1 = DataGenerate.generateDate(3000);
        long start1 = System.nanoTime();
        Assertions.assertEquals(1500,pr01.getKth_1(arr1,1500));
        long end1 = System.nanoTime();
        System.out.println("getKth_1:"+(end1-start1));
    }

    @Test
    void getKth_2() {
        int[] arr1 = DataGenerate.generateDate(3000);
        long start1 = System.nanoTime();
        Assertions.assertEquals(1500,pr01.getKth_2(arr1,1500));
        long end1 = System.nanoTime();
        System.out.println("getKth_2:"+(end1-start1));
    }

    @Test
    void getKth_3() {
        int[] arr1 = DataGenerate.generateDate(30000000);
        long start1 = System.nanoTime();
        Assertions.assertEquals(15000000,pr01.getKth_3(arr1,15000000));
        long end1 = System.nanoTime();
        System.out.println("getKth_3:"+(end1-start1));
    }
    @Test
    void getKth_4() {
        int[] arr1 = DataGenerate.generateDate(30000000);
        long start1 = System.nanoTime();
        Assertions.assertEquals(15000000,pr01.getKth_4(arr1,15000000));
        long end1 = System.nanoTime();
        System.out.println("getKth_4:"+(end1-start1));
    }

}