package ch03.exercise.pr30;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Pr30Test {

    @Test
    void selfAdjustList(){
        Pr30.SelfAdjustList<String> s1 = new Pr30.SelfAdjustList<>();
        s1.push("A");
        s1.push("B");
        s1.push("C");
        s1.push("D");
        s1.push("E");
        s1.push("E");
        s1.print();
        s1.find("A");
        s1.print();
    }

    @Test
    void selfAdjustLinkedList(){
        Pr30.SelfAdjustLinkedList<String> s2 = new Pr30.SelfAdjustLinkedList<>();
        s2.push("A");
        s2.push("B");
        s2.push("C");
        s2.push("D");
        s2.push("E");
        s2.push("F");
        s2.print();
        System.out.println("---------");
        s2.find("F");
        s2.print();
    }

}