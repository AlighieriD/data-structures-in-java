package ch05.exercise.pr24;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by YH on 2020/8/25.
 */
class Pr24Test {

    static class T {
        String s;
        int hash;
        T(String s,int hash){
            this.s = s;
            this.hash = hash;
        }
        @Override
        public int hashCode() {
            return hash;
        }

        @Override
        public String toString() {
            return s;
        }
    }

    @Test
    void test(){
        Pr24.Hopscotch<T> h = new Pr24.Hopscotch<T>(4,14);
        T t;
        h.insert(t = new T("A",7));
        h.insert(new T("B",9));
        h.insert(new T("C",6));
        h.insert(new T("D",7));
        h.insert(new T("E",8));
        h.insert(new T("F",12));
        h.insert(new T("G",11));
        h.insert(new T("H",9));
        h.insert(new T("I",6));
        Assertions.assertTrue(h.contains(t));
        h.remove(t);
        Assertions.assertFalse(h.contains(t));
    }

}