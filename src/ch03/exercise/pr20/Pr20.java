package ch03.exercise.pr20;

import ch03.learn.MyLinkedList;


/**
 * Created by YH on 2020/6/12.
 */
public class Pr20 {
    public static class MyLinkedList_PR20<E> extends MyLinkedList<E> {
        int realSize;
        private static class Node<E> extends MyLinkedList.Node<E>{
            protected byte deleted;
            public Node(E e, MyLinkedList.Node<E> pre, MyLinkedList.Node<E> next, byte deleted){
                super(e,pre,next);
                this.deleted = deleted;
            }
        }

        @Override
        public void doClear(){
            beginMarker = new Node<>(null,null,null,(byte)0);
            endMarker = new Node<>(null,beginMarker,null,(byte)0);
            beginMarker.next = endMarker;
            theSize = 0;
            modCount++;
        }

        @Override
        protected void addBefore(MyLinkedList.Node<E> node, E e){
            Node<E> newNode = new Node<>(e,node.pre,node,(byte) 0);
            newNode.pre.next = newNode;
            node.pre = newNode;
            modCount++;
            theSize++;
            realSize++;
        }

        @Override
        protected Node<E> getNode(int idx, int lower, int upper){
            Node<E> node;
            if (idx < lower || idx > upper)
                throw new ArrayIndexOutOfBoundsException();
            node = (Node<E>) beginMarker;
            int start = 0;
            while (start <= idx) {
                node = (Node<E>) node.next;
                if (node.deleted == 0)
                    start++;
            }
            return node;
        }

        @Override
        protected E remove(MyLinkedList.Node<E> node){
            ((Node<E>)node).deleted = 1;
            theSize--;
            modCount++;
            return node.data;
        }

    }

    public static void main(String[] args) {
        MyLinkedList_PR20<String> l = new MyLinkedList_PR20<>();
        l.add("A");
        l.add("B");
        l.add("C");
        l.add("D");
        l.remove(0);
        System.out.println(l.size());
        System.out.println(l.get(0));
    }
}
