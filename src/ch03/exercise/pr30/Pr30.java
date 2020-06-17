package ch03.exercise.pr30;

public class Pr30 {

    /**
     * a. 写出**自调整表**(self-adjusting list)的数组实现。在自调整表中，所有的插入都在前端进行。
     * 自调整表会添加一个find操作，当一个元素被find访问时，他就被移到表的前端而并不改变其余的项的相对顺序。
     * @param <E>
     */
    public static class SelfAdjustList<E>{
        private static int DEFAULT_SIZE = 10;

        protected Object[] items;
        protected int size;

        public SelfAdjustList(){
            items = new Object[DEFAULT_SIZE];
            size = 0;
        }
        public E find(E e){
            int idx = 0;
            E res = null;
            for (; idx < size; idx++) {
                if (e.equals(items[idx])){
                    res = (E) items[idx];
                    change(idx,0);
                    break;
                }
            }
            return res;
        }

        private void change(int from , int to){
            if (from == to)
                return;
            Object o = items[from];
            if (from > to){
                for (int i = from - 1; i >= to; i--) {
                    items[i+1] = items[i];
                }
            }else {
                for (int i = from + 1; i <= to; i++) {
                    items[i - 1] = items[i];
                }
            }
            items[to] = (E) o;
        }

        private void grow(int newSize){
            Object[] newItems = new Object[newSize];
            for (int i = 0; i < size; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }
        public void push(E e){
            if (size + 1 > items.length)
                grow(size << 1);
            for (int i = size - 1; i >= 0; i--) {
                items[i+1] = items[i];
            }
            items[0] = e;
            size++;
        }
        
        public void print(){
            for (int i = 0; i < size; i++) {
                System.out.println(items[i]);
            }
        }
    }

    /**
     * b. 写出自调整表的链表实现
     * @param <E>
     */
    public static class SelfAdjustLinkedList<E>{
        protected static class Node<E>{
            public E e;
            public Node<E> next;
            public Node(E e, Node<E> next){
                this.e = e;
                this.next = next;
            }
        }
        protected Node<E> head = new Node<>(null,null);
        protected int size = 0;
        public void push(E e){
            Node<E> newNode = new Node<>(e,head.next);
            head.next = newNode;
            size++;
        }
        public E find(E e){
            Node<E> pre = head;
            Node<E> first = head.next;
            while (first != null){
                if (e.equals(first.e)){
                    pre.next = first.next;
                    first.next = head.next;
                    head.next = first;
                    return first.e;
                }
                pre = first;
                first = first.next;
            }
            return null;
        }
        public void print(){
            Node<E> first = head.next;
            while (first != null){
                System.out.println(first.e);
                first = first.next;
            }
        }
    }
}
