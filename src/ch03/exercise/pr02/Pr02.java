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

        public void change(int i,int j){
            
        }
    }
    public class DoubleLinkedList<E>{

    }
}
