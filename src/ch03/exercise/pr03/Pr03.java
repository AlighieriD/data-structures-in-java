package ch03.exercise.pr03;

import ch03.learn.MyLinkedList;

import java.util.Iterator;

public class Pr03 {
    public static class MyLinkedList_PR03<E> extends MyLinkedList<E>{
        public boolean contains(E e){
            boolean flag = false;
            for (E element: this) {
                if (element == e){
                    return true;
                }
            }
            return flag;
        }
    }
}
