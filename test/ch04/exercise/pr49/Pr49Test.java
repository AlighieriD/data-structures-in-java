package ch04.exercise.pr49;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by YH on 2020/7/26.
 */
class Pr49Test {

    int[] source;

    @BeforeEach
    void init(){
        int len = 1000;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = i+1;
        }
        source = new int[len];
        while (len > 0){
            int i = (int)(Math.random() * (len-1));
            source[1000-len] = arr[i];
            arr[i] = arr[len-1];
            len--;
        }
    }
    @Test
    void test(){
        Pr49.TreeSet_PR49<Integer> m = new Pr49.TreeSet_PR49<>();
        for (int i = 0; i < source.length; i++) {
            m.insert(source[i]);
        }
        Assertions.assertEquals(1,m.findKth(1));
        Assertions.assertEquals(10,m.findKth(10));
        Assertions.assertEquals(1000,m.findKth(1000));
        Assertions.assertEquals(501,m.findKth(501));
    }

}