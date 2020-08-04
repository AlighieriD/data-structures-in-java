package ch05.learn;

import java.util.Random;

/**
 * 布谷鸟散列的变体
 * 不是经典布谷鸟实现，只用到了一个表，但是允许传入Hash族
 * @param <AnyType>
 */
public class CuckooHashTable<AnyType> {

    public interface HashFamily<AnyType>{
        int hash(AnyType x, int whitch);
        int getNumberOfFunctions();
        void generateNewFunctions();
    }

    public CuckooHashTable(HashFamily<? super AnyType> hf){
        this(hf,DEFAULT_TABLE_SIZE);
    }

    public CuckooHashTable(HashFamily<? super AnyType> hf, int size){
        allocateArray(size);
        doClear();
        hashFunctions = hf;
        numHashFunctions = hf.getNumberOfFunctions();
    }

    public void makeEmpty(){
        doClear();
    }

    public boolean contains(AnyType x){
        return findPos(x) != -1;
    }

    private int myhash(AnyType x, int which){
        int hashVal = hashFunctions.hash(x,which);
        hashVal %= array.length;
        if (hashVal < 0)
            hashVal += array.length;
        return hashVal;
    }

    private int findPos(AnyType x){
        for (int i = 0; i <numHashFunctions; i++){
            int pos = myhash(x,i);
            if (array[pos] != null && array[pos].equals(x))
                return pos;
        }
        return -1;
    }

    public boolean remove(AnyType x){
        int pos = findPos(x);
        if (pos != -1){
            array[pos] = null;
            currentSize--;
        }
        return pos != -1;
    }

    public boolean insert(AnyType x){
        if(contains(x))
            return false;
        if (currentSize >= array.length * MAX_LOAD)
            expand();
        return insertHelper1(x);
    }

    /**
     *
     * @param x
     * @return
     */
    private Random r = new Random();
    private int rehashes = 0;
    private boolean insertHelper1(AnyType x){
        final int COUNT_LIMIT = 100;
        while (true){
            int lastPos = -1;
            int pos;
            for (int count = 0; count < COUNT_LIMIT; count++) {
                // 尝试所有的Hash方法，找到空位
                for (int i = 0; i < numHashFunctions; i++) {
                    pos = myhash(x,i);
                    if (array[pos] == null){
                        array[pos] = x;
                        currentSize++;
                        return true;
                    }
                }
                // 没有找到空位，随机擦除一位，找一个
                int i = 0;
                do {
                    pos = myhash(x,r.nextInt(numHashFunctions));
                } while (pos == lastPos && i++ < 5);

                AnyType tmp = array[lastPos = pos];
                array[pos] = x;
                x = tmp;
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
        rehash((int)(array.length / MAX_LOAD));
    }

    private void rehash(){
        hashFunctions.generateNewFunctions();
        rehash(array.length);
    }

    private void rehash(int size){
        AnyType[] oldArray = array;
        allocateArray(nextPrime(size));
        currentSize = 0;
        for (AnyType a : oldArray){
            if (a != null)
                insert(a);
        }
    }

    private void doClear(){
        currentSize = 0;
        for (int i = 0; i < array.length; i++)
            array[i] = null;
    }

    private void allocateArray(int size){
        array = (AnyType[]) new Object[nextPrime(size)];
    }

    private static final double MAX_LOAD = 0.4;
    private static final int ALLOWED_REHASHS = 1;
    private static final int DEFAULT_TABLE_SIZE = 101;

    private final HashFamily<? super AnyType> hashFunctions;
    private final int numHashFunctions;
    private AnyType[] array;
    private int currentSize;

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

/**
 * 布谷鸟散列的简单字符串散列。
 */
class StringHashFamily implements CuckooHashTable.HashFamily<String>{
    private final int[] MULTIPLIES;
    private final Random r = new Random();
    StringHashFamily(int d){
        MULTIPLIES = new int[d];
        generateNewFunctions();
    }
    @Override
    public int hash(String x, int whitch) {
        final int multiplier = MULTIPLIES[whitch];
        int hashVal = 0;
        for (int i = 0; i < x.length(); i++) {
            hashVal = multiplier * hashVal + x.charAt(i);
        }
        return hashVal;
    }

    @Override
    public int getNumberOfFunctions() {
        return MULTIPLIES.length;
    }

    @Override
    public void generateNewFunctions() {
        for (int i = 0; i < MULTIPLIES.length; i++) {
            MULTIPLIES[i] = r.nextInt();
        }
    }
}