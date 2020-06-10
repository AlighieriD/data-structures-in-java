package ch03.exercise.pr19;

import java.util.Iterator;

/**
 * Created by YH on 2020/6/10.
 */
public class Pr19<E> {
    private int theSize;
    private int modCount = 0;
    private Node<E> first;
    private Node<E> last;

    public Pr19(){
        doClear();
    }

    public void clear(){
        doClear();
    }

    private void doClear(){
        first = last = null;
        theSize = 0;
        modCount++;
    }
    public int size(){
        return theSize;
    }

    public boolean add(E e){
        Node<E> l = last;
        Node<E> newNode = new Node<>(l,e,null);
        last = newNode;
        if (l == null){
            first = last;
        }else {
            l.next = newNode;
        }
        theSize++;
        modCount++;
    }

    public void add(int idx, E e){

    }

    public E get(int idx){}

    public E set(int idx, E e){}

    public E remove(int idx){}

    private void addBefore(Node<E> p, E e){

    }
    private void addAfter(Node<E> p, E e){
        // 保证 p 不是空节点
        Node<E> n = p.next;

    }

    private E remove(Node<E> p){}

    private Node<E> getNode(int idx){}


    public Iterator<E> iterator(){

    }

    private class LinkedListIterator implements Iterator<E>{

    }

    private static class Node<E> {
        E e;
        Node<E> pre;
        Node<E> next;
        Node(Node<E> pre, E e, Node<E> next){
            this.pre = pre;
            this.e = e;
            this.next = next;
        }
    }
}
