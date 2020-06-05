package ch03.exercise.pr12;

import java.util.TreeMap;

/**
 * Created by YH on 2020/6/5.
 */
public class Pr12 {
    private static class Node<E extends Comparable<? super E>>{
        private E e;
        private Node<E> next;
        public Node(E e, Node<E> next){
            this.e = e;
            this.next = next;
        }
    }

    public static class MyLinkedList_PR12<E extends Comparable<? super E>>{
        private int size = 0;
        private Node<E> head = new Node<>(null,null);

        // 返回链表大小的方法。
        public int getSize(){
            return size;
        }

        // 打印链表的方法。
        public void printList(){
            Node<E> curr = head.next;
            while (curr != null){
                System.out.println(curr.e);
                curr = curr.next;
            }
        }

        private Node<E> getPreNode(E e){
            Node<E> curr = head.next;
            Node<E> pre = head;
            if (e != null){
                while (curr != null){
                    if (e.compareTo(curr.e) >= 0){
                        return pre;
                    }
                    pre = curr;
                    curr = curr.next;
                }
            }
            return pre;
        }

        private void addAfter(Node<E> node, E e){
            if (node != null){
                Node<E> nextNode = node.next;
                node.next = new Node<>(e,nextNode);
                size++;
            }
        }

        private Node<E> removeAfter(Node<E> node){
            if (node != null && node.next != null){
                Node<E> removeNode = node.next;
                node.next = removeNode.next;
                size--;
                return removeNode;
            }
            return null;
        }

        // 测试值X是否含于链表的方法。
        public boolean isContains(E e){
            Node<E> preNode = getPreNode(e);
            return preNode != null;
        }

        // 如果值X尚未含于链表，添加值X到该链表的方法。
        public boolean addIfAbsent(E x){
            Node<E> preNode = getPreNode(x);
            if (preNode == null){
                addAfter(head,x);
                return true;
            } else {
                return false;
            }
        }

        // 如果值X含于链表，将X从该链表中删除的方法。
        public E removeIfPresent(E x){
            Node<E> preNode = getPreNode(x);
            if (preNode != null){
                Node<E> removed = removeAfter(preNode);
                return removed.e;
            } else {
                return null;
            }
        }
    }

}
