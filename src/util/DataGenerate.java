package util;

import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Created by YH on 2020/5/2.
 */
public class DataGenerate {

    public static int[] generateDate(int n){
        int[] res = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            res[i] = i;
        }
        for (int i = 0; i < n - 1; i++) {
            int j = r.nextInt(n - i - 1);
            int tmp = res[n-i-1];
            res[n-i-1] = res[j];
            res[j] = tmp;
        }
        return res;
    }

}
