package ch03.exercise.pr16;

import ch03.learn.MyArrayList;

import java.util.Iterator;

/**
 * Created by YH on 2020/6/9.
 */
public class Pr16 {
    public static class MyArrayList_PR16<E> extends MyArrayList<E> {
        public Iterator<E> reverseIterator(){
            return new ArrayListReverseIterator();
        }

        private class ArrayListReverseIterator implements Iterator<E>{
            private int current = theSize-1;
            @Override
            public void remove() {
                MyArrayList_PR16.this.remove(current+1);
            }

            @Override
            public boolean hasNext() {
                return current >= 0;
            }

            @Override
            public E next() {
                if (!hasNext()){
                    throw new ArrayIndexOutOfBoundsException();
                }
                return theItems[current--];
            }
        }
    }
}
