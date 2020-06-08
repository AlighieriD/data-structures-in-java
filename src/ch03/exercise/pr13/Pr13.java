package ch03.exercise.pr13;

import ch03.learn.MyArrayList;

import java.util.*;

/**
 * Created by YH on 2020/6/6.
 */
public class Pr13 {

    public static class MyArrayList_PR13<E> extends MyArrayList<E>{

        public ListIterator<E> listIterator(){
            return new MyArrayListIterator();
        }

        @Override
        public Iterator<E> iterator() {
            return new MyArrayListIterator();
        }

        private class MyArrayListIterator implements ListIterator<E> {
            private int current = 0;
            private boolean backwards = false;
            private boolean okToRemove = false;
            @Override
            public boolean hasNext() {
                return current < size();
            }

            @Override
            public E next() {
                if (!hasNext())
                    throw new IndexOutOfBoundsException();
                backwards = false;
                okToRemove = true;
                return theItems[current++];
            }

            @Override
            public boolean hasPrevious() {
                return current > 0;
            }

            @Override
            public E previous() {
                if (!hasPrevious())
                    throw new IndexOutOfBoundsException();
                backwards = true;
                okToRemove = true;
                return theItems[--current];
            }

            @Override
            public int nextIndex() {
                if (!hasNext())
                    throw new IndexOutOfBoundsException();
                return current + 1;
            }

            @Override
            public int previousIndex() {
                if (!hasPrevious())
                    throw new IndexOutOfBoundsException();
                return current - 1;
            }

            @Override
            public void remove() {
                if (!okToRemove)
                    throw new NoSuchElementException();
                if (backwards){
                    MyArrayList_PR13.this.remove(current);
                }else {
                    MyArrayList_PR13.this.remove(--current);
                }
                okToRemove = false;
            }

            @Override
            public void set(E e) {
                if (backwards){
                    MyArrayList_PR13.this.set(current,e);
                }else {
                    MyArrayList_PR13.this.set(current-1,e);
                }
            }

            @Override
            public void add(E e) {
                MyArrayList_PR13.this.add(current++,e);
            }
        }

    }

}
