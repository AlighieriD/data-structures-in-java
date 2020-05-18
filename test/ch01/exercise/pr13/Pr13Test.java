package ch01.exercise.pr13;

import ch01.exercise.pr05.Pr05;
import ch01.exercise.pr06.Pr06;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by YH on 2020/5/11.
 */
class Pr13Test {

    @Test
    void test() {
        Pr13.Collection<String> collection = new Pr13.Collection<>();
        Assertions.assertTrue(collection.isEmpty());
        Assertions.assertFalse(collection.isPresent(null));
        collection.insert("TEST1");
        Assertions.assertFalse(collection.isEmpty());
        Assertions.assertTrue(collection.isPresent("TEST1"));
        collection.makeEmpty();
        Assertions.assertTrue(collection.isEmpty());
        Assertions.assertFalse(collection.isPresent(null));
        collection.insert("TEST9");
        Assertions.assertTrue(collection.isPresent("TEST9"));
        collection.remove("TEST9");
        Assertions.assertFalse(collection.isPresent("TEST9"));

    }


}