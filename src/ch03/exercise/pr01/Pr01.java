package ch03.exercise.pr01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by YH on 2020/5/25.
 */
public class Pr01 {

    /**
     * 写出过程printLots(L, P)。该过程的运行时间是多少?
     */

    /**
     * L , P 包含升序排列的整数
     * 打印出L中由P所指定的位置上的元素
     *
     * 利用了增强for循环，本质上是利用了iterator
     * 可以记录每次循环的当前位置
     * @param L
     * @param P
     */
    public <T> List<T> printLots(List<T> L,List<Integer> P){
        Iterator<T> iterator = L.iterator();
        List<T> res = new ArrayList<>();
        int i = 0;
        for (Integer p : P ) {
            while (iterator.hasNext() && i < p){
                iterator.next();
                i++;
            }
            if (iterator.hasNext() && i == p){
                res.add(iterator.next());
                i++;
            }
        }
        return res;
    }
}
