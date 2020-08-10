package ch05.exercise.pr05.pr05;

import ch05.learn.SeparateChainingHashTable;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Pr05 {
    public static class SeparateSingleChainingHashTable<AnyType> extends SeparateChainingHashTable<AnyType>{
        SeparateSingleChainingHashTable(){
            this(DEFAULT_TABLE_SIZE);
        }

        SeparateSingleChainingHashTable(int size){
            theLists = new SingleLinkedList[nextPrime(size)];
            for (int i = 0; i < theLists.length; i++)
                theLists[i] = new SingleLinkedList<>();
        }
    }

    public static class SingleLinkedList<E> implements List<E>{
        private static class Node<E> {
            E e;
            Node<E> next;
            Node(E e, Node<E> next){
                this.e = e;
                this.next = next;
            }
        }

        private Node<E> root;
        private int size = 0;
        @Override
        public int size() {
            return size;
        }

        @Override
        public boolean isEmpty() {
            return size == 0;
        }

        @Override
        public boolean contains(Object o) {
            Node<E> n = root;
            while (n != null){
                if (n.e.equals(o))
                    return true;
                n = n.next;
            }
            return false;
        }

        @Override
        public Iterator<E> iterator() {
            throw new UnsupportedOperationException("not support operation");
        }

        @Override
        public Object[] toArray() {
            throw new UnsupportedOperationException("not support operation");
        }

        @Override
        public <T> T[] toArray(T[] a) {
            throw new UnsupportedOperationException("not support operation");
        }

        @Override
        public boolean add(E e) {
            Node<E> n = new Node<>(e,root);
            root = n;
            size++;
            return true;
        }

        @Override
        public boolean remove(Object o) {
            Node<E> p = null;
            Node<E> n = root;
            while (n != null){
                if (n.e.equals(o)){
                    if (p == null){
                        root = n.next;
                    } else {
                        p.next = n.next;
                    }
                    n = null;
                    size--;
                    return true;
                }
                p = n;
                n = n.next;
            }
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            throw new UnsupportedOperationException("not support operation");
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            throw new UnsupportedOperationException("not support operation");
        }

        @Override
        public boolean addAll(int index, Collection<? extends E> c) {
            throw new UnsupportedOperationException("not support operation");
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException("not support operation");
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException("not support operation");
        }

        @Override
        public void clear() {
            throw new UnsupportedOperationException("not support operation");
        }

        @Override
        public E get(int index) {
            throw new UnsupportedOperationException("not support operation");
        }

        @Override
        public E set(int index, E element) {
            throw new UnsupportedOperationException("not support operation");
        }

        @Override
        public void add(int index, E element) {
            throw new UnsupportedOperationException("not support operation");
        }

        @Override
        public E remove(int index) {
            throw new UnsupportedOperationException("not support operation");
        }

        @Override
        public int indexOf(Object o) {
            throw new UnsupportedOperationException("not support operation");
        }

        @Override
        public int lastIndexOf(Object o) {
            throw new UnsupportedOperationException("not support operation");
        }

        @Override
        public ListIterator<E> listIterator() {
            throw new UnsupportedOperationException("not support operation");
        }

        @Override
        public ListIterator<E> listIterator(int index) {
            throw new UnsupportedOperationException("not support operation");
        }

        @Override
        public List<E> subList(int fromIndex, int toIndex) {
            throw new UnsupportedOperationException("not support operation");
        }
    }
}
