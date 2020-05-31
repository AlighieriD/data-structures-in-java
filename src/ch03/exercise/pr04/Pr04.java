package ch03.exercise.pr04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by YH on 2020/5/30.
 */
public class Pr04 {

    /**
     * 3.4 给定两个已排序的表L1和L2，只使用基本的表操作编写计算L1 交集 L2的过程
     * @param l1
     * @param l2
     * @param <E>
     * @return
     */
    public <E extends Comparable<? super E>> List<E> intersection(List<E> l1, List<E> l2){
        List<E> res = new ArrayList<>();
        if (l1.size() == 0 || l2.size() == 0)
            return res;
        Iterator<E> itr1 = l1.iterator();
        Iterator<E> itr2 = l2.iterator();
        E current1 = itr1.next();
        E current2 = itr2.next();
        while (current1 != null && current2 != null){
            int cpr = current1.compareTo(current2);
            if (cpr > 0){
                current2 = itr2.hasNext() ? itr2.next() : null;
            } else if (cpr < 0){
                current1 = itr1.hasNext() ? itr1.next() : null;
            } else {
                res.add(current1);
                current1 = itr1.hasNext() ? itr1.next() : null;
                current2 = itr2.hasNext() ? itr2.next() : null;
            }
        }

        return res;
    }

}
