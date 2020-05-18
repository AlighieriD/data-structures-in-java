package ch01.exercise.pr05;

/**
 * Created by YH on 2020/5/11.
 */
public class Pr05 {

    /**
     * 编写一种递归方法，返回数N的二进制表示中1的个数。利用这样的事实：
     * 如果N是奇数，那么其1的个数等于N/2的二进制表示中1的个数加1。
     */

    public int getOne(int n){
        if (n < 2)
            return n;
        return n % 2 + getOne(n / 2);
    }

}
