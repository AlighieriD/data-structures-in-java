package ch03.exercise.pr33;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by YH on 2020/6/18.
 */
class Pr33Test {

    @Test
    void test(){
        Pr33.MyDeque_PR33<String> m = new Pr33.MyDeque_PR33<>(5);
        m.push("A");
        m.push("B");
        m.push("C");
        m.push("D");
        m.push("E");
        m.pop();
        m.pop();
        m.pop();

    }

}