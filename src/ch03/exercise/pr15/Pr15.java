package ch03.exercise.pr15;

import ch03.learn.MyLinkedList;

import java.util.Iterator;

public class Pr15 {
    public static class MyLinkedList_PR15<T> extends MyLinkedList<T>{
        public void splice(Iterator<T> itr, MyLinkedList_PR15<? extends T> lst){
            if (lst.size() == 0)
                return;
            if (lst == this)
                return;
            MyLinkedListIterator m = (MyLinkedListIterator)itr;
            Node<T> fisrt = (Node<T>)lst.beginMarker.next;
            m.current.pre.next = fisrt;
            fisrt.pre = m.current.pre;
            Node<T> last = (Node<T>)lst.endMarker.pre;
            m.current.pre = last;
            last.next = m.current;
            theSize += lst.size();
            lst.clear();
        }
    }
}
