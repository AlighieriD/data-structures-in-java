package ch03.exercise.pr05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by YH on 2020/5/31.
 */
public class Pr05 {

    public <E extends Comparable<? super E>> List<E> union(List<E> l1, List<E> l2){
        List<E> res = new ArrayList<>();
        Iterator<E> itr1 = l1.iterator();
        Iterator<E> itr2 = l2.iterator();
        E current1 = itr1.hasNext() ? itr1.next() : null;
        E current2 = itr2.hasNext() ? itr2.next() : null;
        while (current1 != null && current2 != null){
            int cmp = current1.compareTo(current2);
            if (cmp > 0){
                res.add(current2);
                current2 = itr2.hasNext() ? itr2.next() : null;
            } else if (cmp < 0){
                res.add(current1);
                current1 = itr1.hasNext() ? itr1.next() : null;
            } else {
                res.add(current1);
                current1 = itr1.hasNext() ? itr1.next() : null;
                current2 = itr2.hasNext() ? itr2.next() : null;
            }
        }
        while (current1 != null){
            res.add(current1);
            current1 = itr1.hasNext() ? itr1.next() : null;
        }
        while (current2 != null){
            res.add(current2);
            current2 = itr2.hasNext() ? itr2.next() : null;
        }
        return res;
    }
}
