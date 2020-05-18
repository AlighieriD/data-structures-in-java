package ch01.exercise.pr06;

import java.util.Arrays;

/**
 * Created by YH on 2020/5/11.
 */
public class Pr06 {
    /**
     * 编写带有下列声明的例程：
     * public void permute(String str);
     * private void permute(char[] str, int low, int high);
     * 第一个例程是个驱动程序，它调用第二个例程并显示String str中的字符的所有排列。
     * 如果str是"abc"，那么输出的串则是abc,acb,bac,bca,cab和cba。第二个例程使用递归。
     */
    public void permute(String str){
        char[] chars = str.toCharArray();
        permute(chars,0,chars.length-1);
    }

    // 返回str中的字符的所有排列
    private void permute(char[] str, int low, int high){
        if (low == high){
            System.out.println(Arrays.toString(str));
        }
        for (int i = low; i <= high; i++) {
            swap(str,low,i);
            permute(str,low+1,high);
            swap(str,low,i);
        }
    }

    private void swap(char[] str, int i, int j){
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }
}
