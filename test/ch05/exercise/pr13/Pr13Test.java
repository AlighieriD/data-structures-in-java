package ch05.exercise.pr13;

import ch03.exercise.pr12.Pr12;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Pr13Test {
    @Test
    void multiplyPolynomial() {
        Pr12.MyLinkedList_PR12<Pr13.Node> p1 = new Pr12.MyLinkedList_PR12<>();
        p1.addIfAbsent(new Pr13.Node(1,1));
        p1.addIfAbsent(new Pr13.Node(2,2));
        Pr12.MyLinkedList_PR12< Pr13.Node > p2 = new Pr12.MyLinkedList_PR12<>();
        p2.addIfAbsent(new Pr13.Node(1,1));
        p2.addIfAbsent(new Pr13.Node(2,2));
        Pr13.multiplyPolynomial(p1, p2);
    }

}