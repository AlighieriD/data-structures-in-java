package ch05.learn;

/**
 * Created by YH on 2020/8/3.
 */
public class QuadraticProbingHashTable<AnyType> {
    public QuadraticProbingHashTable(){
        this(DEFAULT_TABLE_SIZE);
    }

    public QuadraticProbingHashTable(int size){
        allocateArray(size);
        makeEmpty();
    }

    public void makeEmpty(){
        currentSize = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }

    public boolean contains(AnyType x){
        int pos = findPos(x);
        return isActive(pos);
    }

    public void insert(AnyType x){
        int pos = findPos(x);
        if (isActive(pos))
            return;
        array[pos] = new HashEntry<AnyType>(x,true);
        if (pos > array.length / 2)
            rehash();
    }

    public void remove(AnyType x){
        int pos = findPos(x);
        if (isActive(pos))
            array[pos].isActive = false;
    }

    private static class HashEntry<AnyType> {
        public AnyType element;
        public boolean isActive;
        public HashEntry(AnyType e){
            this.element = e;
        }

        public HashEntry(AnyType e, boolean i){
            this.element = e;
            this.isActive = i;
        }
    }

    private static final int DEFAULT_TABLE_SIZE = 11;

    private HashEntry<AnyType>[] array;
    private int currentSize;

    private void allocateArray(int arraySize){
        array = new HashEntry[nextPrime(arraySize)];
    }

    private boolean isActive(int currentPos){
        return array[currentPos] != null && array[currentPos].isActive;
    }

    private int findPos(AnyType x){
        int offset = 1;
        int currentPos = myhash(x);

        while (array[currentPos] != null &&
                !array[currentPos].element.equals(x)){
            currentPos += offset;
            offset += 2;
            if (currentPos >= array.length)
                currentPos -= array.length;
        }
        return currentPos;
    }

    private void rehash(){}

    private int myhash(AnyType x){
        int hashVal = x.hashCode();

        hashVal %= array.length;
        if (hashVal < 0)
            hashVal += array.length;
        return hashVal;
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
