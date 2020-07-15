package ch04.exercise.pr22;

import ch04.exercise.pr21.Pr21;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by YH on 2020/7/11.
 */
class Pr22Test {

    Pr22.PR22_isBalance<String,String> avlTree;

    @BeforeEach
    void init(){
        avlTree = new Pr22.PR22_isBalance<>();
        avlTree.insert("A","AAA");
        avlTree.insert("B","AAA");
        avlTree.insert("C","AAA");
        avlTree.insert("D","AAA");
        avlTree.insert("E","AAA");
        avlTree.insert("F","AAA");
        avlTree.insert("G","AAA");
        avlTree.insert("H","AAA");
        avlTree.insert("I","AAA");
        avlTree.insert("G","AAA");
        avlTree.insert("K","AAA");
        avlTree.insert("L","AAA");
        avlTree.insert("M","AAA");
        avlTree.insert("N","AAA");
        avlTree.insert("O","AAA");
        avlTree.insert("P","AAA");
        avlTree.insert("Q","AAA");
        avlTree.insert("R","AAA");
        avlTree.insert("S","AAA");
        avlTree.insert("T","AAA");
        avlTree.insert("U","AAA");
        avlTree.insert("V","AAA");
        avlTree.insert("W","AAA");
        avlTree.insert("X","AAA");
        avlTree.insert("Y","AAA");
        avlTree.insert("Z","AAA");
    }

    @AfterEach
    void destory(){
        avlTree = null;
    }

    @Test
    void test1(){
        Pr22.PR22_isBalance.isCorrectAndBalance(avlTree);
    }

}