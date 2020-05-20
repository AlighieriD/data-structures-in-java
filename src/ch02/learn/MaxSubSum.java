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
        return maxSubSum3(arr,0, arr.length-1);
    }

    // 该方法会返回最大自序和
    private int maxSubSum3(int[] arr, int l, int r){
        if (l > r)
            return 0;
        if (l == r)
            return arr[l] > 0 ? arr[l] : 0;
        int mid = (l + r) / 2;
        int leftMax = maxSubSum3(arr,l,mid);
        int rightMax = maxSubSum3(arr,mid+1,r);

        int leftBorderMax = 0, leftBorderSum = 0;
        for (int i = mid; i >= l; i--) {
            leftBorderSum += arr[i];
            leftBorderMax = Math.max(leftBorderMax,leftBorderSum);
        }
        int rightBorderMax = 0, rightBorderSum = 0;
        for (int i = mid+1; i <= r; i++) {
            rightBorderSum += arr[i];
            rightBorderMax = Math.max(rightBorderMax,rightBorderSum);
        }
        int res = Math.max(leftMax,rightMax);
        res = Math.max(res,leftBorderMax+rightBorderMax);
        return res;
    }

    /**
     * maxSubSum3 使用O(n) 时间复杂度方法
     * @param arr
     * @return
     */
    public int maxSubSum4(int[] arr){
        int l = 0, res = 0, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            while (sum < 0){
                sum -= arr[l++];
            }
            res = Math.max(res,sum);
        }
        return res;
    }

    /**
     * maxSubSum3 使用O(n) 时间复杂度方法
     * @param arr
     * @return
     */
    public int maxSubSum4_2(int[] arr){
        int res = 0, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > res){
                res = sum;
            }else if (sum < 0){
                sum = 0;
            }
        }
        return res;
    }

}
