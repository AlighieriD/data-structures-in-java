package ch03.learn;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements Iterable<E> {

    protected int theSize;
    protected int modCount = 0;
    protected Node<E> beginMarker;
    protected Node<E> endMarker;
    protected static class Node<E>{
        public Node(E e, Node<E> pre,Node<E> next){
            this.data = e;
            this.pre = pre;
            this.next = next;
        }
        public E data;
        public Node<E> pre;
        public Node<E> next;
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

    protected void addBefore(Node<E> node, E e){
        Node<E> newNode = new Node<>(e,node.pre,node);
        newNode.pre.next = newNode;
        node.pre = newNode;
        modCount++;
        theSize++;
    }

    protected E remove(Node<E> node){
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

    protected class MyLinkedListIterator implements Iterator<E> {
        public Node<E> current = beginMarker.next;
        public int expectedModCount = modCount;
        public boolean okToRemove = false;
        @Override
        public void remove() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
            if (!okToRemove)
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
