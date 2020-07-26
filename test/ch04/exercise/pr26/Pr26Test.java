package ch04.exercise.pr26;

import ch04.exercise.pr21.Pr21;
import ch04.exercise.pr23.Pr23;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by YH on 2020/7/18.
 */
class Pr26Test {


    Pr23.PR23_AVL_Tree<String,String> m1 = null;
    Pr26.MyAVLTree_Pr26<String,String> m2 = null;


    @BeforeEach
    void init(){
        m1 = new Pr23.PR23_AVL_Tree<>();
        m2 = new Pr26.MyAVLTree_Pr26();
        m1.insert("E","EEE");
        m1.insert("B","BBB");
        m1.insert("F","FFF");
        m1.insert("A","AAA");
        m1.insert("D","DDD");
        m2.insert("E","EEE");
        m2.insert("B","BBB");
        m2.insert("F","FFF");
        m2.insert("A","AAA");
        m2.insert("D","DDD");
    }


    @Test
    void test(){
        m1.print();
        System.out.println("======================");
        m2.print();
        m1.insert("C","CCC");
        m2.insert("C","CCC");
        System.out.println("======================");

        m1.print();
        System.out.println("======================");
        m2.print();

    }

}