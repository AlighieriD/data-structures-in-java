package ch05.exercise.pr24;

/**
 * Created by YH on 2020/8/12.
 */
public class Pr24 {
    public static class Hopscotch<AnyType>{
        private final int MAX_DIST;
        // 最大的负载因子，如果表中负载大于MAX_LOAD则进行扩展表
        private static final double MAX_LOAD = 0.4;
        private static final int DEFAULT_TABLE_SIZE = 101;
        private int currentSize;
        Hopscotch(int maxDist){
            this(maxDist,DEFAULT_TABLE_SIZE);
        }
        Hopscotch(int maxDist, int size){
            MAX_DIST = maxDist;
            hops = new int[maxDist];
            allocateArray(size);
            doClear();
        }
        private AnyType[] array;
        private int[] hops;

        public boolean contains(AnyType x){
            int hash = myhash(x);
            int hop = hops[hash];
        }

//        public boolean remove(AnyType x){
//
//        }
//
//        public boolean insert(AnyType x){
//
//        }

        private int myhash(AnyType x){
            int hashVal = x.hashCode();
            hashVal %= array.length;
            if (hashVal < 0)
                hashVal += array.length;
            return hashVal;
        }

        private void doClear(){
            currentSize = 0;
            for (int i = 0; i < array.length; i++)
                array[i] = null;
            for (int i = 0; i < hops.length; i++) {
                hops[i] = 0;
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
