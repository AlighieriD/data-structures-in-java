package ch02.learn;

/**
 * Created by YH on 2020/5/19.
 */
public class MaxSubSum {

    /**
     * 最大子序和问题
     * 给定整数（有可能是负数），求最大的子序的和，如果所有的整数均为负数，则最大子序列和为0
     */
    /**
     * maxSubSum1 使用O(n^3) 时间复杂度方法
     * @param arr
     * @return
     */
    public int maxSubSum1(int[] arr){
        int max = 0;
        // 起始
        for (int i = 0; i < arr.length - 1; i++) {
            // 结束
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k < j; k++) {
                    sum += arr[k];
                }
                max = Math.max(max,sum);
            }
        }
        return max;
    }

    /**
     * maxSubSum2 使用O(n^2) 时间复杂度方法
     * @param arr
     * @return
     */
    public int maxSubSum2(int[] arr){
        int max = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                max = Math.max(max,sum);
            }
        }
        return max;
    }

    /**
     * maxSubSum3 使用O(n*log(n)) 时间复杂度方法
     * @param arr
     * @return
     */
    public int maxSubSum3(int[] arr){
        return 0;
    }

}
