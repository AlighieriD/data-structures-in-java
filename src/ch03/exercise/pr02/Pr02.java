package ch03.exercise.pr02;

import java.util.Iterator;

public class Pr02 {
    public static class SingleLinkedList<E> {
        private Node<E> first;
        private Node<E> last;
        private int size;
        private static class Node<E> {
            E value;
            Node<E> next;
            Node(E e, Node<E> next){
                this.value = e;
                this.next = next;
            }
        }
        public void add(E e){
            final Node<E> l = last;
            Node<E> node = new Node<>(e,null);
            last = node;
            if (l == null){
                first = node;
            }else {
                l.next = node;
            }
            size++;
        }

        /**
         * https://www.geeksforgeeks.org/swap-nodes-in-a-linked-list-without-swapping-data/
         * @param i
         * @param j
         */
        public void swap(int i , int j){
            // 检查 i j 下标是否合法
            check(i);
            check(j);
            // 保证 j > i
            if (i > j){
                swap(j,i);
                return;
            }
            // 找到prei 和 prej
            // 哨兵节点，简化代码
            Node<E> head = new Node<>(null,first);
            Node<E> h = head;
            int start = 0;
            Node<E> prei = null, prej = null;
            while (h != null && start <= j){
                if (start == i){
                    prei = h;
                }
                if (start == j){
                    prej = h;
                }
                start++;
                h = h.next;
            }
            Node<E> tmp = prei.next;
            prei.next = prej.next;
            prej.next = tmp;
            tmp = prei.next.next;
            prei.next.next = prej.next.next;
            prej.next.next = tmp;
            first = head.next;
            if (j == size - 1){
                last = prej.next;
            }
        }

        private void check(int i){
            if (i < 0 || i >= size){
                throw new IndexOutOfBoundsException();
            }
        }

        public void print(){
            Node<E> f = first;
            while (f != null){
                System.out.print(f.value);
                if (f.next != null){
                    System.out.print(" -> ");
                }
                f = f.next;
            }
        }
    }
    public static class DoubleLinkedList<E>{
        private Node<E> head;
        private Node<E> tail;
        public DoubleLinkedList(){
            head = new Node<>(null,null,null);
            tail = new Node<>(head,null,null);
            head.next = tail;
        }
        private int size;
        private static class Node<E> {
            E value;
            Node<E> next;
            Node<E> pre;
            Node(Node<E> pre, E e, Node<E> next){
                this.pre = pre;
                this.value = e;
                this.next = next;
            }
        }
        public void add(E e){
            Node<E> node = new Node<>(tail.pre,e,tail);
            tail.pre.next = node;
            tail.pre = node;
            size++;
        }
        private void check(int i){
            if (i < 0 || i >= size){
                throw new IndexOutOfBoundsException();
            }
        }

        public void swap(int i , int j){
            // 检查 i j 下标是否合法
            check(i);
            check(j);
            // 保证 j > i
            if (i > j){
                swap(j,i);
                return;
            }
            // 找到prei 和 prej
            Node<E> f = head.next;
            int start = 0;
            Node<E> nodei = null, nodej = null;
            while (f != null && start <= j){
                if (start == i){
                    nodei = f;
                }
                if (start == j){
                    nodej = f;
                }
                start++;
                f = f.next;
            }
            Node<E> tmp1 = nodei.next;
            Node<E> tmp2 = nodei.pre;
            nodei.next = nodej.next;
            nodej.next.pre = nodei;
            nodei.pre = nodej.pre;
            nodej.pre.next = nodei;
            nodej.next = tmp1;
            tmp1.pre = nodej;
            nodej.pre = tmp2;
            tmp2.next = nodej;
        }

        public void print(){
            Node<E> f = head.next;
            for (int i = 0; i < size; i++) {
                System.out.print(f.value);
                if (i != size - 1){
                    System.out.print(" -> ");
                }
                f = f.next;
            }
       }

    }
}
