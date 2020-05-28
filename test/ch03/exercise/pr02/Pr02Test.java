package ch03.exercise.pr02;

import ch03.exercise.pr01.Pr01;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by YH on 2020/5/28.
 */
class Pr02Test {

    @Test
    void swap() {
        Pr02.SingleLinkedList<Integer> s = new Pr02.SingleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            s.add(i);
        }
        s.print();
        System.out.println();
        s.swap(2,9);
        s.print();

    }

}