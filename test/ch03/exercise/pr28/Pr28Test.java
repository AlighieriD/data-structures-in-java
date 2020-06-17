package ch03.exercise.pr28;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Pr28Test {

    @Test
    void test(){
        Pr28.MyDeque<String> myDeque = new Pr28.MyDeque<>();
        myDeque.push("A");
        myDeque.push("B");
        myDeque.push("C");
        while (myDeque.size > 0){
            System.out.println(myDeque.eject());
        }
        myDeque.inject("A");
        myDeque.inject("B");
        myDeque.inject("C");
        while (myDeque.size > 0){
            System.out.println(myDeque.pop());
        }

    }
}