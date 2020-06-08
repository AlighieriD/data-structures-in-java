package ch03.exercise.pr14;

import ch03.learn.MyLinkedList;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Created by YH on 2020/6/7.
 */
public class Pr14 {
    public static class MyLinkedList_PR14<E> extends MyLinkedList<E> {
        @Override
        public Iterator<E> iterator() {
            return new MyLinkedListIterator();
        }

        public ListIterator<E> listIterator(){
            return new MyLinkedListIterator();
        }

        private class MyLinkedListIterator implements ListIterator<E>{
            private int expectedModCount = modCount;
            private boolean okToRemove = false;
            private boolean backwards = false;
            Node<E> current = beginMarker.next;
            int currentIdx = 0;

            @Override
            public boolean hasNext() {
                return currentIdx < size();
            }

            @Override
            public E next() {
                if (modCount != expectedModCount)
                    throw new ConcurrentModificationException();
                if (!hasNext())
                    throw new IndexOutOfBoundsException();
                E e = current.data;
                current = current.next;
                currentIdx++;
                okToRemove = true;
                backwards  = false;
                return e;
            }

            @Override
            public boolean hasPrevious() {
                return currentIdx > 0;
            }

            @Override
            public E previous() {
                if (modCount != expectedModCount)
                    throw new ConcurrentModificationException();
                if (!hasPrevious())
                    throw new IndexOutOfBoundsException();
                E e = current.pre.data;
                current = current.pre;
                currentIdx--;
                okToRemove = true;
                backwards = true;
                return e;
            }

            @Override
            public int nextIndex() {
                if (modCount != expectedModCount)
                    throw new ConcurrentModificationException();
                if (!hasNext())
                    throw new IndexOutOfBoundsException();
                return currentIdx+1;
            }

            @Override
            public int previousIndex() {
                if (modCount != expectedModCount)
                    throw new ConcurrentModificationException();
                if (!hasPrevious())
                    throw new IndexOutOfBoundsException();
                return currentIdx - 1;
            }

            @Override
            public void remove() {
                if (modCount != expectedModCount)
                    throw new ConcurrentModificationException();
                if (!okToRemove)
                    throw new NoSuchElementException();
                if (backwards){
                    MyLinkedList_PR14.this.remove(current.next);
                }else {
                    MyLinkedList_PR14.this.remove(current.pre);
                }
                okToRemove = false;
                expectedModCount++;
                currentIdx--;
            }

            @Override
            public void set(E e) {
                if (modCount != expectedModCount)
                    throw new ConcurrentModificationException();
                if (!okToRemove)
                    throw new IndexOutOfBoundsException();
                if (backwards){
                    current.next.data = e;
                }else {
                    current.pre.data = e;
                }
            }

            @Override
            public void add(E e) {
                if (modCount != expectedModCount)
                    throw new ConcurrentModificationException();
                MyLinkedList_PR14.this.addBefore(current,e);
                currentIdx++;
                expectedModCount++;
            }
        }
    }
}
