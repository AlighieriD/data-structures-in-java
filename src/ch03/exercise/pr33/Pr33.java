package ch03.exercise.pr33;

/**
 * Created by YH on 2020/6/18.
 */
public class Pr33 {
    public static class MyDeque_PR33<E>{
        protected Object[] items;
        protected int size = 0;
        protected int head = 0;
        protected int tail = 0;

        public MyDeque_PR33(int size){
            items = new Object[size];
        }

        public void push(E e){
            if (size >= items.length)
                throw new OutOfMemoryError();
            items[head] = e;
            head = head + 1 >= items.length ? 0 : head + 1;
            size++;
        }

        public E pop() {
            if (size <= 0)
                throw new OutOfMemoryError();
            E e = (E) items[tail];
            tail = tail + 1 >= items.length ? 0 : tail + 1;
            size--;
            return e;
        }
    }
}
