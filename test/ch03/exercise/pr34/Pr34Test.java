package ch03.exercise.pr34;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by YH on 2020/6/18.
 */
class Pr34Test {
    @Test
    void isCicleTest() {
        Pr34.MyCicleList<String> m = new Pr34.MyCicleList<>();
        Pr34.Node<String> n1 = new Pr34.Node<>("A");
        Pr34.Node<String> n2 = new Pr34.Node<>("B");
        Pr34.Node<String> n3 = new Pr34.Node<>("C");
        Pr34.Node<String> n4 = new Pr34.Node<>("D");
        Pr34.Node<String> n5 = new Pr34.Node<>("E");
        Pr34.Node<String> n6 = new Pr34.Node<>("F");
        Pr34.Node<String> n7 = n6;
        m.append(n1);
        m.append(n2);
        m.append(n3);
        m.append(n4);
        m.append(n5);
        m.append(n6);
        m.append(n7);
        Assertions.assertTrue(Pr34.isCicle(m));
    }

    @Test
    void isCicle2() {
        Pr34.MyCicleList<String> m = new Pr34.MyCicleList<>();
        Pr34.Node<String> n1 = new Pr34.Node<>("V");
        Pr34.Node<String> n2 = new Pr34.Node<>("B");
        Pr34.Node<String> n3 = new Pr34.Node<>("C");
        Pr34.Node<String> n4 = new Pr34.Node<>("D");
        Pr34.Node<String> n5 = new Pr34.Node<>("E");
        Pr34.Node<String> n6 = new Pr34.Node<>("F");
        Pr34.Node<String> n7 = n3;
        m.append(n1);
        m.append(n2);
        m.append(n3);
        m.append(n4);
        m.append(n5);
        m.append(n6);
        m.append(n7);
        Assertions.assertTrue(Pr34.isCicle(m));
    }

}