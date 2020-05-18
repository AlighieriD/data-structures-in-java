package ch01.exercise.pr01;

import java.util.Arrays;

/**
 * Created by YH on 2020/5/2.
 */
public class Pr01 {

    /**
     * 编写一个程序解决选择问题。令k=N/2。画出表格显示程序对于N种不同的值的运行时间。
     */

    /**
     * 书中提到的第一种方法，用冒泡排序，然后返回第K个值,降序排序
     * @param arr
     * @param k
     * @return
     */
    public int getKth_1(int[] arr, int k){
        if (k <= 0 || k > arr.length){
            throw new ArrayIndexOutOfBoundsException(k);
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j+1] > arr[j]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return arr[k-1];
    }

    /**
     * 书中所提的第二种方法，是对方法一的简单优化，可以省去一小部分（小于arr[k]的部分）不必要的排序
     * @param arr
     * @param k
     * @return
     */
    public int getKth_2(int[] arr, int k){
        if (k <= 0 || k > arr.length){
            throw new ArrayIndexOutOfBoundsException(k);
        }
        for (int i = 0; i < k - 1; i++) {
            for (int j = 0; j < k - i - 1; j++) {
                if (arr[j+1] > arr[j]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        for (int i = k; i < arr.length; i++) {
            int t = arr[i], j = k-1;
            while (j >= 0 && t > arr[j]){
                arr[j+1] = arr[j--];
            }
            arr[j+1] = t;
        }
        return arr[k-1];
    }

    /**
     * 第k个值可以考虑（最大/最小）堆
     * 先建堆（自上而下）O(n)，然后取出第k个（k*log(n)）
     * 大顶堆/小顶堆可以保证0位是在他应该在的位置
     * 重复k次，不必保证其他元素的顺序，减少了大量的排序工作
     * @param arr
     * @param k
     * @return
     */
    public int getKth_3(int[] arr, int k){
        if (k <= 0 || k > arr.length){
            throw new ArrayIndexOutOfBoundsException(k);
        }
        // 自上而下建堆
        for (int i = arr.length/2 - 1; i >= 0; i--) {
            heapify(arr,i,arr.length);
        }
        for (int i = 0; i < k-1; i++) {
            arr[0] = arr[arr.length - i - 1];
            heapify(arr,0, arr.length - 1 - i);
        }
        return arr[0];
    }

    private void heapify(int[] arr,int i,int n){
        while (i <= n/2 - 1){
            int max = i;
            if (i*2+1 < n && arr[i*2+1] > arr[i])
                max = i*2+1;
            if (i*2+2 < n && arr[i*2+2] > arr[max])
                max = i*2+2;
            if (max == i){
                break;
            }
            int tmp = arr[max];
            arr[max] = arr[i];
            arr[i] = tmp;
            i = max;
        }
    }

    /**
     * 利用快速排序的思想，快速排序每次可以确定一个元素的位置，
     * 这个元素的左边都小于它，右边都大于它（升序排列）
     * 找到第k个元素的位置即可
     * @param arr
     * @param k
     * @return
     */
    public int getKth_4(int[] arr, int k){
        if (k <= 0 || k > arr.length){
            throw new ArrayIndexOutOfBoundsException(k);
        }
        int lo = 0, hi = arr.length-1;
        while (hi > lo){
            int pos = sortP(arr,lo,hi);
            // 如果等于k，返回
            // 如果大于k，hi = start；
            // 如果小于k，lo = start；
            if (pos == k - 1)
                return arr[pos];
            else if (pos > k - 1)
                hi = pos - 1;
            else
                lo = pos + 1;
        }
        return arr[lo];
    }

    /**
     * @param arr
     * @param lo
     * @param hi
     * @return
     */
    private int sortP(int[] arr, int lo, int hi){
        int p = arr[lo];
        while (hi > lo){
            // 找到右边不符合条件者，插入左边，此时右边出现空位
            while (hi > lo && arr[hi] < p)
                hi--;
            if (hi > lo)
                arr[lo++] = arr[hi];
            // 找到左边不符合条件者，插入右边，此时左边出现空位
            while (hi > lo && arr[lo] > p)
                lo++;
            if (hi > lo)
                arr[hi--] = arr[lo];
        }
        arr[lo] = p;
        return lo;
    }

}
