package ch03.learn;

import java.util.Iterator;

public class MyArrayList<E> implements Iterable<E> {

    private static final int DEFAULT_CAPACITY = 10;
    // 此处破坏了封装性，为了通过继承实现习题
    protected int theSize;
    protected E[] theItems;

    public MyArrayList () {
        doClear();
    }

    public void clear(){
        doClear();
    }
    private void doClear(){
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size(){
        return theSize;
    }

    public boolean isEmpty(){
        return size() == 0;
    }
    public void trimToSize(){
        ensureCapacity(size());
    }

    public E get(int idx){
        if (idx < 0 || idx >= size()){
            throw new ArrayIndexOutOfBoundsException();
        }
        return theItems[idx];
    }

    public E set(int idx, E e){
        if (idx < 0 || idx >= size()){
            throw new ArrayIndexOutOfBoundsException();
        }
        E old = theItems[idx];
        theItems[idx] = e;
        return old;
    }
    private void ensureCapacity(int newCapacity){
        if (newCapacity < theSize)
            return;
        E[] oldItems = theItems;
        theItems = (E[])new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            theItems[i] = oldItems[i];
        }

    }

    public boolean add(E e){
        add(size(),e);
        return true;
    }
    public void add(int idx, E e){
        if (theItems.length == size()){
            ensureCapacity(size() * 2 + 1);
        }
        for (int i = theSize; i > idx; i--) {
            theItems[i] = theItems[i-1];
        }
        theItems[idx] = e;
        theSize++;
    }

    public E remove(int idx){
        E e = theItems[idx];
        for (int i = idx; i < size() - 1; i++) {
            theItems[i] = theItems[i + 1];
        }
        theSize--;
        return e;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements Iterator<E> {
        private int current = 0;
        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public E next() {
            if (!hasNext()){
                throw new ArrayIndexOutOfBoundsException();
            }
            return theItems[current++];
        }
    }
}
