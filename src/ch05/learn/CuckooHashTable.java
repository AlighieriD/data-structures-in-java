package ch05.learn;

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
    private boolean insertHelper1(AnyType x){
        final int COUNT_LIMIT = 100;
        while (true){

        }
    }

    private void expand(){}

    private void rehash(){}

    private void doClear(){
        currentSize = 0;
        for (int i = 0; i < array.length; i++)
            array[i] = null;
    }

    private void allocateArray(int size){}

    private static final double MAX_LOAD = 0.4;
    private static final int ALLOWED_REHASHS = 1;
    private static final int DEFAULT_TABLE_SIZE = 101;

    private final HashFamily<? super AnyType> hashFunctions;
    private final int numHashFunctions;
    private AnyType[] array;
    private int currentSize;
}
