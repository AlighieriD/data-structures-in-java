package ch01.exercise.pr02;

import ch01.exercise.pr01.Pr01;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.DataGenerate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by YH on 2020/5/5.
 */
class Pr02Test {

    private Pr02 pr02;

    @BeforeEach
    void setUp() {
        pr02 = new Pr02();
    }

    @AfterEach
    void tearDown() {
        pr02 = null;
    }

    @Test
    void wordSearch_1() {
        char[][] pazzleBoard = {
                {'t','h','i','s'},
                {'w','a','t','s'},
                {'o','a','h','g'},
                {'f','g','d','t'}};
        String[] words = {"this","two","fat","that"};
        pr02.wordSearch_1(pazzleBoard,words);
    }

    @Test
    void wordSearch_1_2() {
        char[][] pazzleBoard = {
                {'N','E','A','U','A','G','A','R','P','K','L','I','V','E'},
                {'E','R','R','I','E','A','R','L','I','O','E','E','O','R'},
                {'G','R','L','R','J','R','M','A','B','S','T','A','L','N'},
                {'N','E','E','S','H','L','R','E','N','U','T','T','D','T'},
                {'I','M','T','E','N','C','Y','A','O','G','S','I','E','Y'},
                {'L','H','W','E','A','S','L','E','Y','R','E','D','M','R'},
                {'W','O','G','R','Y','F','F','I','N','D','O','R','O','D'},
                {'O','G','H','M','D','A','R','K','A','R','T','S','R','R'},
                {'R','W','A','S','C','A','R','S','J','T','R','T','T','A'},
                {'K','A','R','T','F','A','R','C','H','C','T','I','W','Z'},
                {'J','R','R','O','E','T','R','H','A','G','R','I','D','I'},
                {'R','T','I','G','E','N','O','I','M','R','E','H','R','W'},
                {'A','S','D','L','A','N','O','R','W','L','D','E','N','T'},
                {'H','S','D','O','K','R','A','T','D','D','I','L','R','D'}
        };
        String[] words = {"HARRY","POTTER","JKROWLING","RONALD","WEASLEY","HERMIONE",
                "GRANGER","HOGWARTS","WITCHCRAFT","WIZARDRY","VOLDEMORT","ALBUS","SCAR","HAGRID","DARKARTS","GRYFFINDOR"};
        pr02.wordSearch_1(pazzleBoard,words);
    }


}