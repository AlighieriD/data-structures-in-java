package ch05.learn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by YH on 2020/8/3.
 */
class QuadraticProbingHashTableTest {
    @Test
    void contains() {
        QuadraticProbingHashTable<String> s = new QuadraticProbingHashTable<>();
        Assertions.assertFalse(s.contains("A"));
//        s.insert("A");
    }

}