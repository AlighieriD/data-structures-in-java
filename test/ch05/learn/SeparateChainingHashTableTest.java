package ch05.learn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by YH on 2020/8/3.
 */
class SeparateChainingHashTableTest {

    @Test
    void test(){
        SeparateChainingHashTable<String> s = new SeparateChainingHashTable<>();
        Assertions.assertFalse(s.contains("A"));
        s.insert("A");
        Assertions.assertTrue(s.contains("A"));
        s.remove("A");
        Assertions.assertFalse(s.contains("A"));
    }

}