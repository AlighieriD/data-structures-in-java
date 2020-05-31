package ch03.exercise.pr03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by YH on 2020/5/30.
 */
class Pr03Test {

    @Test
    public void contains(){
        Pr03.MyLinkedList_PR03<String> m = new Pr03.MyLinkedList_PR03<>();
        m.add("ZXC");
        m.add("GHJ");
        m.add("jiahd");
        m.add("NHUL");
        Assertions.assertTrue(m.contains("ZXC"));
        Assertions.assertTrue(m.contains("NHUL"));
        Assertions.assertTrue(m.contains("jiahd"));
        Assertions.assertFalse(m.contains("ASD"));
    }

}