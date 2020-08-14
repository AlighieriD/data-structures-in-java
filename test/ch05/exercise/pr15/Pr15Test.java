package ch05.exercise.pr15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Pr15Test {

    @Test
    void contains_v1() {
        String base = "abcdefg";
        Assertions.assertEquals(Pr15.contains_v1(base,"abc"),0);
        Assertions.assertEquals(Pr15.contains_v1(base,"cde"),2);
        Assertions.assertEquals(Pr15.contains_v1(base,"cdet"),-1);
        Assertions.assertEquals(Pr15.contains_v1(base,"defg"),3);

    }
}