package ch01.exercise.pr13;

import java.util.Arrays;

/**
 * Created by YH on 2020/5/11.
 */
public class Pr13 {
    /**
     * 设计一个泛型类Collection，它储存object对象的集合（在数组中），以及该集合的当前大小。
     * 提供public方法isEmpty、makeEmpty、insert、remove和isPresent。
     * 方法isPresent(x)当且仅当在该集合中存在（由equals定义）等于x的一个Object时返回true。
     */
    public static class Collection<T> {
        protected Object[] objects;
        protected int size;

        public Collection(int capital){
            size = capital;
            objects = new Object[capital];
        }

        public Collection(){
            size = 0;
            objects = new Object[]{};
        }

        public boolean isEmpty(){
            return size == 0;
        }

        public void makeEmpty(){
            size = 0;
            objects = new Object[]{};
        }

        public void insert(T e){
            grow(size+1);
            objects[++size - 1] = e;
            return;
        }

        private void grow(int growSize){
            if (objects.length < growSize){
                objects = Arrays.copyOf(objects,growSize);
            }
        }

        public void remove(T e){
            for (int i = 0; i < size; i++) {
                if (e != null && e.equals(objects[i])
                        || e == null && objects[i] == null){
                    removeAt(i);
                    return;
                }
            }
        }

        private void removeAt(int i){
            for (int j = i+1; j < size; j++) {
                objects[j-1] = objects[j];
            }
            objects[--size] = null;
        }

        public boolean isPresent(T e){
            for (int i = 0; i < size; i++) {
                if (e != null && e.equals(objects[i])
                        || e == null && objects[i] == null){
                    return true;
                }
            }
            return false;
        }
    }
    public static class InsertNullException extends Exception{
    }
}
