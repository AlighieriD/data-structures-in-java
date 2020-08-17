package ch05.exercise.pr25;

import org.omg.CORBA.IntHolder;

/**
 * Created by YH on 2020/8/16.
 */
public class Pr25 {

    public static class CuckooHashTableClassical<AnyType> {

        public interface HashFamily<AnyType>{
            int hash(AnyType x, int whitch);
            int getNumberOfFunctions();
            void generateNewFunctions();
        }

        CuckooHashTableClassical(HashFamily<? super AnyType> hf){
            this(hf,DEFAULT_TABLE_SIZE);
        }
        CuckooHashTableClassical(HashFamily<? super AnyType> hf, int size){
            this.hashFunctions = hf;
            this.numHashFunctions = hf.getNumberOfFunctions();
            allocateArray(size);
            doClear();
        }
        // 最大的负载因子，如果表中负载大于MAX_LOAD则进行扩展表
        private static final double MAX_LOAD = 0.4;
        // 进行插入时允许的rehash（另外选择Hash函数）次数，若大于ALLOWED_REHASHS则进行扩展表
        private static final int ALLOWED_REHASHS = 1;
        // 默认表大小
        private static final int DEFAULT_TABLE_SIZE = 101;
        // Hash函数族
        private final HashFamily<? super AnyType> hashFunctions;
        // Hash函数数量
        private final int numHashFunctions;
        // 表
        private AnyType[][] array;
        // 当前size
        private int currentSize;
        // 每个Hash表的size
        private int[] sizeAtTable;

        public boolean contains(AnyType x){
            return findPos(x,null) != -1;
        }

        private int myhash(AnyType x, int which){
            int hashVal = hashFunctions.hash(x,which);
            hashVal %= array[which].length;
            if (hashVal < 0)
                hashVal += array[which].length;
            return hashVal;
        }

        private int findPos(AnyType x, IntHolder inWhichTable){
            for (int i = 0; i <numHashFunctions; i++){
                int pos = myhash(x,i);
                if (array[i][pos] != null && array[i][pos].equals(x)){
                    if (inWhichTable != null)
                        inWhichTable.value = i;
                    return pos;
                }
            }
            return -1;
        }

        public boolean remove(AnyType x){
            IntHolder inWhichTable = new IntHolder();
            int pos = findPos(x,inWhichTable);
            if (pos != -1){
                array[inWhichTable.value][pos] = null;
                sizeAtTable[inWhichTable.value]--;
                currentSize--;
            }
            return pos != -1;
        }

        public boolean insert(AnyType x){
            if(contains(x))
                return false;
            if (currentSize >= array.length * array[0].length * MAX_LOAD)
                expand();
            return insertHelper1(x);
        }

        private int rehashes = 0;
        private boolean insertHelper1(AnyType x){
            final int COUNT_LIMIT = 100;
            while (true){
                int pos;
                for (int count = 0; count < COUNT_LIMIT; count++) {
                    // 总是替换第一次找到的位置
                    for (int i = 0; i < numHashFunctions; i++) {
                        pos = myhash(x,i);
                        if (array[i][pos] == null){
                            array[i][pos] = x;
                            sizeAtTable[i]++;
                            currentSize++;
                            return true;
                        } else {
                            AnyType tmp = array[i][pos];
                            array[i][pos] = x;
                            x = tmp;
                        }
                    }
                }

                // 如果尝试若干次，依然没法插入成功，则尝试rehash表
                // 如果已经经过若干次rehash , 则扩充表的大小
                if (++rehashes > ALLOWED_REHASHS){
                    expand();
                    rehashes = 0;
                } else {
                    rehash();
                }
            }
        }

        private void expand(){
            rehash((int)(array[0].length / MAX_LOAD));
        }

        private void rehash(){
            hashFunctions.generateNewFunctions();
            rehash(array[0].length);
        }

        private void rehash(int size){
            AnyType[][] oldArray = array;
            allocateArray(nextPrime(size));
            currentSize = 0;
            sizeAtTable = new int[numHashFunctions];
            for (AnyType[] a : oldArray){
                for(AnyType v : a){
                    if (v != null)
                        insert(v);
                }
            }
        }

        private void doClear(){
            currentSize = 0;
            sizeAtTable = new int[numHashFunctions];
            for (int i = 0; i < array.length; i++){
                for (int j = 0; j < array[i].length; j++){
                    array[i][j] = null;
                }
            }
        }

        private void allocateArray(int size){
            array = (AnyType[][]) new Object[numHashFunctions][nextPrime(size)];
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
