package ch03.exercise.pr09;

import ch03.learn.MyArrayList;

/**
 * Created by YH on 2020/6/3.
 */
public class Pr09 {
    public static class MyArrayList_PR09<E> extends MyArrayList<E> {

        // O(N) N 是items大小，add也会隐含着扩容，但是他的均摊时间复杂度还是O(1)
        public void addAll( Iterable<? extends E> items ){
            for(E e : items){
                this.add(e);
            }
        }
    }
}
