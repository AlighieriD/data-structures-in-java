package ch03.exercise.pr10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by YH on 2020/6/4.
 */
class Pr10Test {
    @Test
    void removeAllTest(){
        Pr10.MyLinkedList_PR10<String> mll = new Pr10.MyLinkedList_PR10();
        mll.add("A");
        mll.add("B");
        mll.add("C");
        mll.add("D");
        LinkedList l = new LinkedList();
        l.add("D");
        l.add("B");
        mll.removeAll(l);
        List<String> res = new LinkedList<>();
        for (String s : mll){
            res.add(s);
        }
        Assertions.assertLinesMatch(res, Arrays.asList("A","C"));
    }
}