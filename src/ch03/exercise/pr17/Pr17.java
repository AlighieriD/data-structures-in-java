package ch03.exercise.pr17;

import ch03.learn.MyArrayList;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Pr17 {
    public static class MyArrayList_PR17<E> extends MyArrayList<E>{
        private int modCount = 0;

        @Override
        public void clear() {
            super.clear();
            modCount++;
        }

        @Override
        public void trimToSize() {
            super.trimToSize();
            modCount++;
        }

        @Override
        public boolean add(E e) {
            modCount++;
            return super.add(e);
        }

        @Override
        public void add(int idx, E e) {
            modCount++;
            super.add(idx, e);
        }

        @Override
        public E remove(int idx) {
            modCount++;
            return super.remove(idx);
        }

        @Override
        public Iterator<E> iterator() {
            return new MyArrayListIterator();
        }

        private class MyArrayListIterator implements Iterator<E> {
            private int current = 0;
            private boolean okToRemove = false;
            private int expectedModCount = modCount;
            @Override
            public void remove() {
                if (modCount != expectedModCount)
                    throw new ConcurrentModificationException();
                if (!okToRemove)
                    throw new NoSuchElementException();
                MyArrayList_PR17.this.remove(--current);
                expectedModCount++;
                okToRemove = false;
            }

            @Override
            public boolean hasNext() {
                return current < size();
            }

            @Override
            public E next() {
                if (modCount != expectedModCount)
                    throw new ConcurrentModificationException();
                if (!hasNext())
                    throw new NoSuchElementException();
                okToRemove = true;
                return theItems[current++];
            }
        }

    }
}
