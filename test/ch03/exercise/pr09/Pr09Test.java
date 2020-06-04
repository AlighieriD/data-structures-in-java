package ch03.exercise.pr09;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by YH on 2020/6/3.
 */
class Pr09Test {

    @Test
    void addAllTest(){
        Pr09.MyArrayList_PR09<String> mal = new Pr09.MyArrayList_PR09<>();
        mal.add("A");
        mal.add("B");
        mal.add("C");
        mal.add("D");

        ArrayList<String> al = new ArrayList<>();
        al.add("A");
        al.add("L");
        al.add("I");
        al.add("B");
        al.add("B");
        LinkedList<String> ll = new LinkedList<>();
        ll.add("-");
        ll.add("S");
        ll.add("T");
        ll.add("A");
        ll.add("R");
        ll.add("T");
        mal.addAll(al);
        mal.addAll(ll);

        List<String> res = new ArrayList<>();
        for (String s : mal){
            res.add(s);
        }
        Assertions.assertLinesMatch(res, Arrays.asList("A","B","C","D","A","L","I","B","B","-","S","T","A","R","T"));
    }

}