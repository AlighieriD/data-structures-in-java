package ch03.exercise.pr02;

public class Pr02 {
    public static class SingleLinkedList<E>{
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
            Node<E> head = new Node<>(null,first);
            int start = 0;
            Node<E> prei = null, prej = null;
            while (head != null && start <= j){
                if (start == i){
                    prei = head;
                }
                if (start == j){
                    prej = head;
                }
                start++;
                head = head.next;
            }

        }

        private void check(int i){
            if (i < 0 || i > size){
                throw new IndexOutOfBoundsException();
            }
        }

    }
    public class DoubleLinkedList<E>{

    }

    public static void main(String[] args) {
    }
}
