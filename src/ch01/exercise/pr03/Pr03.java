package ch01.exercise.pr03;

import java.math.BigDecimal;

/**
 * Created by YH on 2020/5/8.
 */
public class Pr03 {

    /**
     * 1.3 只使用处理I/O的printDigit方法，编写一种方法以输出任意double型量（可以是负的）。
     */

    public void print(double d){
        if (d < 0){
            d = -d;
            System.out.print("-");
        }
        printInt((int) d);
        System.out.print(".");
        printOut(d - (int) d);
    }

    public void printOut(double d){
        float diff = 1e-6f;
        d = d * 10;
        printDigit((int) d);
        if (d > diff){
            printOut(d- (int) d);
        }
    }

    /**
     * printInt 可以输出 i
     * @param i
     */
    public void printInt(int i){
        if (i >= 10){
            // printInt 输出 i / 10 部分
            printInt(i / 10);
        }
        // printDigit 输出最后一位
        printDigit(i % 10);
    }
    private void printDigit(int i){
        System.out.print(i);
    }

}
