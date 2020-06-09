package ch03.exercise.pr18;

import ch03.learn.MyLinkedList;

import java.util.NoSuchElementException;

public class Pr18 {
    public static class MyLinkedList_PR18<E> extends MyLinkedList<E>{

        public void addFirst(E e){
            addBefore(beginMarker.next,e);
        }

        public void addLast(E e){
            addBefore(endMarker,e);
        }

        public void removeFirst(){
            if (beginMarker.next == endMarker)
                throw new NoSuchElementException();
            remove(beginMarker.next);
        }

        public void removeLast(){
            if (beginMarker == endMarker.pre)
                throw new NoSuchElementException();
            remove(endMarker.pre);
        }

        public E getFirst(){
            if (beginMarker.next == endMarker)
                throw new NoSuchElementException();
            return beginMarker.next.data;
        }

        public E getLast(){
            if (beginMarker == endMarker.pre)
                throw new NoSuchElementException();
            return endMarker.pre.data;
        }
    }
}
