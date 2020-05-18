package ch01.exercise.pr14;

import ch01.exercise.pr13.Pr13;

/**
 * Created by YH on 2020/5/12.
 */
public class Pr14 {

    /**
     * 设计一个泛型类OrderedCollection，它存储Comparable的对象的集合（在数组中），以及该集合的当前大小。
     * 提供public方法isEmpty、makeEmpty、insert、remove、findMin和findMax。
     * findMin和findMax分别返回该集合中最小的和最大的Comparable对象的引用（如果该集合为空，则返回null）。
     */

    // 教训，想要复用，要么抽象出接口，来继承实现， 要么父类某些域要设计成protected
    // private 纯粹的封装
    // public 公开的
    // default 同包 相信同包的不会搞事，并且同包可以搞事
    // protected 同包 + 包外子类 希望可以被子类使用
    public static class OrderedCollection<T extends Comparable<? super T>> extends Pr13.Collection<T>{

        public OrderedCollection(int capital) {
            super(capital);
        }

        public OrderedCollection() {
            super();
        }

        private T element(int i){
            return (T) objects[i];
        }

        public T findMin(){
            if (size <= 0)
                throw new IndexOutOfBoundsException();
            T min = (T) objects[0];
            for (int i = 1; i < size; i++) {
                if (min.compareTo(element(i)) > 0){
                    min = element(i);
                }
            }

            return min;
        }

        public T findMax(){
            if (size <= 0)
                throw new IndexOutOfBoundsException();
            T max = (T) objects[0];
            for (int i = 1; i < size; i++) {
                if (max.compareTo(element(i)) < 0){
                    max = element(i);
                }
            }

            return max;
        }
    }

}
