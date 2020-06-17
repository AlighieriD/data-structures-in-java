package ch03.exercise.pr29;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Pr29Test {

    @Test
    void revertPrintTest(){
        Pr29.MyDeque_PR29<String> myDeque = new Pr29.MyDeque_PR29<>();
        myDeque.push("A");
        myDeque.push("B");
        myDeque.push("C");
        myDeque.push("D");
        myDeque.revertPrint();
    }
}