package ch05.exercise.pr05;

import ch05.exercise.pr05.pr05.Pr05;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by YH on 2020/8/8.
 */
class Pr05Test {

    @Test
    void test(){
        Pr05.SeparateSingleChainingHashTable<String> s = new Pr05.SeparateSingleChainingHashTable<>(11);
        s.insert("A");
        s.insert("B");
        s.insert("C");
        s.insert("D");
        s.insert("E");
        Assertions.assertTrue(s.contains("A"));
        s.remove("A");
        Assertions.assertFalse(s.contains("A"));
    }
}