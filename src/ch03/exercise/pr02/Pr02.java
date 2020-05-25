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
            
        }
    }
    public class DoubleLinkedList<E>{

    }
}
