package ch03.learn;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements Iterable<E> {

    private int theSize;
    private int modCount = 0;
    private Node<E> beginMarker;
    private Node<E> endMarker;
    private static class Node<E>{
        public Node(E e, Node<E> pre,Node<E> next){
            this.data = e;
            this.pre = pre;
            this.next = next;
        }
        E data;
        Node<E> pre;
        Node<E> next;
    }

    public MyLinkedList(){
        doClear();
    }

    public void clear(){
        doClear();
    }

    private void doClear(){
        beginMarker = new Node<>(null,null,null);
        endMarker = new Node<>(null,beginMarker,null);
        beginMarker.next = endMarker;
        theSize = 0;
        modCount++;
    }
    public int size(){
        return theSize;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public boolean add(E e){
        add(size(),e);
        return true;
    }

    public void add(int idx, E e){
        addBefore(getNode(idx,0,size()),e);
    }


    public E get(int idx){
        return getNode(idx).data;
    }

    public E set(int idx, E e){
        Node<E> node = getNode(idx);
        E old = node.data;
        node.data = e;
        return old;
    }

    public E remove(int idx){
        return remove(getNode(idx));
    }

    private void addBefore(Node<E> node, E e){
        Node<E> newNode = new Node<>(e,node.pre,node);
        newNode.pre.next = newNode;
        node.pre = newNode;
        modCount++;
        theSize++;
    }

    private E remove(Node<E> node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
        theSize--;
        modCount++;
        return node.data;
    }

    private Node<E> getNode(int idx){
        return getNode(idx,0,size() - 1);
    }

    private Node<E> getNode(int idx, int lower, int upper){
        Node<E> node;
        if (idx < lower || idx > upper)
            throw new ArrayIndexOutOfBoundsException();
        if (idx < size() / 2){
            node = beginMarker;
            for (int i = 0; i < idx; i++) {
                node = node.next;
            }
        }else {
            node = endMarker;
            for (int i = size(); i > idx; i--) {
                node = node.pre;
            }
        }
        return node;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyLinkedListIterator();
    }

    private class MyLinkedListIterator implements Iterator<E> {
        private Node<E> current = beginMarker.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;
        @Override
        public void remove() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
            if (!hasNext())
                throw new NoSuchElementException();
            MyLinkedList.this.remove(current.pre);
            expectedModCount++;
            okToRemove = false;
        }

        @Override
        public boolean hasNext() {
            return current != endMarker;
        }

        @Override
        public E next() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
            if (!hasNext())
                throw new NoSuchElementException();

            E e = current.data;
            current = current.next;
            okToRemove = true;
            return e;
        }
    }
}
