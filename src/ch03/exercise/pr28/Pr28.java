package ch03.exercise.pr28;

import java.util.NoSuchElementException;

public class Pr28 {
    public static class MyDeque<E> {
        protected Node<E> head;
        protected Node<E> tail;
        protected int size;
        public MyDeque(){
            head = new Node<>(null,null,null);
            tail = new Node<>(head,null,null);
            head.next = tail;
            size = 0;
        }
        //push(x) : 将项x插入到双端队列的前端。
        public void push(E e){
            Node<E> newNode = new Node<>(head,e,head.next);
            head.next.pre = newNode;
            head.next = newNode;
            size++;
        }
        //pop() : 从双端队列中删除前端项并将其返回。
        public E pop(){
            if (size <= 0)
                throw new NoSuchElementException();
            Node<E> remove = head.next;
            head.next = remove.next;
            remove.next.pre = head;
            size--;
            return remove.e;
        }
        //inject(x) : 将项x插入到双端队列的尾端。
        public void inject(E e){
            Node<E> newNode = new Node<>(tail.pre,e,tail);
            tail.pre.next = newNode;
            tail.pre = newNode;
            size++;
        }

        //eject() : 从双端队列中删除尾端项并将其返回。
        public E eject(){
            if (size <= 0)
                throw new NoSuchElementException();
            Node<E> remove = tail.pre;
            tail.pre = remove.pre;
            remove.pre.next = tail;
            size--;
            return remove.e;
        }
        protected static class Node<E>{
            public E e;
            public Node<E> next;
            public Node<E> pre;
            public Node(Node<E> pre, E e, Node<E> next){
                this.pre = pre;
                this.e = e;
                this.next = next;
            }
        }

    }
}
