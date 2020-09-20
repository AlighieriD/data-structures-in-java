package ch06.learn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by YH on 2020/9/20.
 */
class BinaryHeapTest {
    @Test
    void deleteMin() {
        BinaryHeap<Integer> b = new BinaryHeap<>(new Integer[]{1,2,3,4,5,6,7,8,9,0});
        b.deleteMin();
    }

}