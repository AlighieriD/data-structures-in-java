package ch03.exercise.pr10;

import ch03.learn.MyLinkedList;

import java.util.Iterator;

/**
 * Created by YH on 2020/6/3.
 */
public class Pr10 {

    public static class MyLinkedList_PR10<E> extends MyLinkedList<E> {
        public void removeAll( Iterable<? extends E> items){
            for (E item : items){
                Iterator<E> itr = iterator();
                while (itr.hasNext()){
                    if (itr.next().equals(item)){
                        itr.remove();
                        break;
                    }
                }
            }
        }
    }
}
