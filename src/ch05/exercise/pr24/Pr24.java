package ch05.exercise.pr24;

/**
 * Created by YH on 2020/8/12.
 */
public class Pr24 {
    public static class Hopscotch<AnyType>{
        private final int MAX_DIST;
        private static final int DEFAULT_TABLE_SIZE = 101;
        private int currentSize;
        Hopscotch(int maxDist){
            this(maxDist,DEFAULT_TABLE_SIZE);
        }
        Hopscotch(int maxDist, int size){
            MAX_DIST = maxDist;
            dist = new int[maxDist];
            allocateArray(size);
            doClear();
        }
        private AnyType[] array;
        private int[] dist;

        private void doClear(){
            currentSize = 0;
            for (int i = 0; i < array.length; i++)
                array[i] = null;
            for (int i = 0; i < dist.length; i++) {
                dist[i] = 0;
            }
        }

        private void allocateArray(int size){
            array = (AnyType[]) new Object[nextPrime(size)];
        }

        private static int nextPrime(int n){
            n++;
            while (!isPrime(n)){
                n++;
            }
            return n;
        }

        private static boolean isPrime(int n){
            if (n < 2)
                return false;
            for (int i = 2; i < n; i++) {
                if (n % i == 0)
                    return false;
            }
            return true;

        }

    }
}
