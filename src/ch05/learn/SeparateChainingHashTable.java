package ch05.learn;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by YH on 2020/8/1.
 */
public class SeparateChainingHashTable<AnyType> {

    public SeparateChainingHashTable(){
        this(DEFAULT_TABLE_SIZE);
    }

    public SeparateChainingHashTable(int size){
        theLists = new LinkedList[nextPrime(size)];
        for (int i = 0; i < theLists.length; i++)
            theLists[i] = new LinkedList<>();
    }

    public void insert(AnyType x){
        List<AnyType> whichList = theLists[myhash(x)];
        if (!whichList.contains(x)){
            whichList.add(x);
            if (++currentSize > theLists.length)
                rehash();
        }
    }

    public void remove(AnyType x){
        List<AnyType> whichList = theLists[myhash(x)];
        if (whichList.contains(x)){
            whichList.remove(x);
            currentSize--;
        }
    }

    public boolean contains(AnyType x){
        List<AnyType> whichList = theLists[myhash(x)];
        return whichList.contains(x);
    }

    public void makeEmpty(){
        for (int i = 0; i < theLists.length; i++)
            theLists[i] = new LinkedList<>();
    }

    private static final int DEFAULT_TABLE_SIZE = 101;

    private List<AnyType>[] theLists;

    private int currentSize;

    private void rehash(){};

    private int myhash(AnyType x){
        int hashVal = x.hashCode();

        hashVal %= theLists.length;
        if (hashVal < 0)
            hashVal += theLists.length;
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
