package ch04.exercise.pr30;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Pr30Test {

    Pr30.Spread_Tree<String,String> sp;

    @BeforeEach
    void init(){
        sp  = new Pr30.Spread_Tree<>();
        sp.insert("A","AA");
        sp.insert("B","BB");
        sp.insert("C","CC");
        sp.insert("D","DD");
        sp.insert("E","EE");
        sp.insert("F","FF");
        sp.insert("G","GG");
        sp.insert("H","HH");
        sp.insert("I","II");
        sp.insert("J","JJ");
        sp.insert("K","KK");
        sp.insert("L","LL");
        sp.insert("M","MM");
        sp.insert("N","NN");
        sp.insert("O","OO");
        sp.insert("P","PP");
        sp.insert("Q","QQ");
        sp.insert("R","RR");
        sp.insert("S","SS");
        sp.insert("T","TT");
        sp.insert("U","UU");
        sp.insert("V","VV");
        sp.insert("W","WW");
        sp.insert("X","XX");
        sp.insert("Y","YY");
        sp.insert("Z","ZZ");
    }
    @Test
    void test(){
        sp.find("A");
        sp.find("M");
        sp.find("O");
        sp.find("A");
        sp.find("P");
        sp.find("Z");
        sp.find("Z");
        sp.find("V");
        sp.find("R");
        sp.find("K");
        System.out.println(sp.getRotat());
    }

}