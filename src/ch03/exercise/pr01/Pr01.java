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
     * @param L
     * @param P
     */
    public static void printLots(List<Integer> L,List<Integer> P){
        Iterator<Integer> iterator = L.iterator();
        int i = 0;
        for (Integer p :
                P) {
            while (iterator.hasNext() && i < L.size()){
                Integer l = iterator.next();
                if (i++ == p){
                    System.out.println(l);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> L = new ArrayList<>();
        L.add(1);
        L.add(2);
        L.add(3);
        L.add(4);
        L.add(5);
        L.add(6);
        L.add(7);
        List<Integer> P = new ArrayList<>();
        P.add(1);
        P.add(3);
        P.add(4);
        P.add(6);
        printLots(L,P);
    }

}
