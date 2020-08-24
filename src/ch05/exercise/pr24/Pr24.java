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
        private static final int ALLOWED_REHASHS = 1;
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
            int i = findPos(x);
            return i != -1;
        }

        private int findPos(AnyType x){
            int hash = myhash(x);
            int hop = hops[hash];
            int dist = 0;
            while (hop != 0){
                // 因为hop是2的n次方（bit map），所以 & 2 相当于 % 2
                int i = hop & 1;
                if (i != 0 && x.equals(array[hash + dist])){
                    return dist;
                }
                hop = hop >>> 1;
                dist++;
            }
            return -1;
        }

        public boolean remove(AnyType x){
            int dist = findPos(x);
            if (dist != -1){
                int hash = myhash(x);
                array[hash + dist] = null;
                hops[hash] &= ~(1 << dist);
                return true;
            }
            return false;
        }


        int expanded = 0;
        public boolean insert(AnyType x){
            if (contains(x))
                return false;
            while (true){
            }
            // 如果hops已满，则expand
            while (isFull(x)){
                if (++expanded > ALLOWED_REHASHS){
                    throw new RuntimeException("插入失败");
                }
                else{
                    expand();
                }
            }
            // 尝试插入hops中的空位中
            int hash = myhash(x);
            int dist = probe(hash);

            while (dist >= MAX_DIST){

            }
            // 表已满，找不到位置插入
            if (dist < 0)
                return false;
            // 可以插入
            if (dist < MAX_DIST){
                array[hash + dist] = x;
                hops[hash] |= (1 << dist);
                currentSize++;
                return true;
            }else {

            }

            // 尝试挪出空位

        }

        private void expand(){

        }

        private void rehash(){

        }

        private void rehash(int size){

        }

        private boolean isFull(AnyType x){
            int hash = myhash(x);
            int hop = hops[hash];
            for (int i = 0; i < MAX_DIST; i++) {
                if ((hop & 1) == 0){
                    return false;
                }
                hop >>>= 1;
            }
            return true;
        }

        /**
         * 探测指定hash值的元素第一个能插入的位置
         * 返回距离
         * @param hash
         * @return
         */
        private int probe(int hash){
            int dist = 0;
            while (hash + dist < array.length){
                if (array[hash + dist] == null){
                    return dist;
                }
                dist++;
            }
            return -1;
        }

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
