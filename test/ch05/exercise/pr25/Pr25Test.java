package ch05.exercise.pr25;

import ch05.learn.CuckooHashTable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by YH on 2020/8/18.
 */
class Pr25Test {
    @Test
    void test(){
        StringHashFamily hashFamily = new StringHashFamily(2);
        Pr25.CuckooHashTableClassical<String> c = new Pr25.CuckooHashTableClassical<String>(hashFamily,10);
        c.insert("AAA");
        c.insert("asd");
        c.insert("asdaf");
        c.insert("sdafjas");
        c.insert("asfagfbasj");
        c.insert("asfhagj");
        c.insert("ashdiahda");
        c.insert("ashiah");
        c.insert("ahsdiagsdhgashd");
        c.insert("asdhijahd");
        c.insert("asdbasdf");
        c.insert("askndajdsbj");
        c.insert("asdhavds");
        c.insert("asjbdhavd");
        c.insert("adhadfgadv");
        c.insert("ajhsduahdu");
        c.insert("ajduagda");
        c.insert("adhuagd");
        Assertions.assertTrue(c.contains("asdaf"));
        Assertions.assertFalse(c.contains("AA"));
        c.remove("asdaf");
        Assertions.assertFalse(c.contains("asdaf"));
    }
}
class StringHashFamily implements Pr25.CuckooHashTableClassical.HashFamily<String> {
    private final int[] MULTIPLIES;
    private final Random r = new Random();
    StringHashFamily(int d){
        MULTIPLIES = new int[d];
        generateNewFunctions();
    }
    @Override
    public int hash(String x, int whitch) {
        final int multiplier = MULTIPLIES[whitch];
        int hashVal = 0;
        for (int i = 0; i < x.length(); i++) {
            hashVal = multiplier * hashVal + x.charAt(i);
        }
        return hashVal;
    }

    @Override
    public int getNumberOfFunctions() {
        return MULTIPLIES.length;
    }

    @Override
    public void generateNewFunctions() {
        for (int i = 0; i < MULTIPLIES.length; i++) {
            MULTIPLIES[i] = r.nextInt();
        }
    }
}
