package ch01.exercise.pr14;

import ch01.exercise.pr13.Pr13;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by YH on 2020/5/14.
 */
class Pr14Test {

    @Test
    void test() {
        Pr14.OrderedCollection<String> orderedCollection = new Pr14.OrderedCollection<>();
        Assertions.assertTrue(orderedCollection.isEmpty());
        orderedCollection.insert("A");
        Assertions.assertFalse(orderedCollection.isEmpty());
        orderedCollection.insert("B");
        orderedCollection.insert("0");
        Assertions.assertEquals("0",orderedCollection.findMin());
        Assertions.assertEquals("B",orderedCollection.findMax());
        orderedCollection.insert(null);
        assertThrows(NullPointerException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                orderedCollection.findMax();
            }
        });
    }


}