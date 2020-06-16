package ch03.exercise.pr24;

/**
 * Created by YH on 2020/6/16.
 */
public class Pr24 {
    public static class TwoStack<E>{
        E[] items;
        int head1;

        int head2;

        public TwoStack(int size){
            items = (E[]) new Object[size];
            head1 = 0;
            head2 = size - 1;
        }

        public void push1(E e){
            if (head1 > head2)
                throw new IndexOutOfBoundsException();
            items[head1++] = e;
        }

        public void push2(E e){
            if (head2 < head1)
                throw new IndexOutOfBoundsException();
            items[head2--] = e;
        }

        public E pop1(){
            if (head1 <= 0)
                throw new IndexOutOfBoundsException();
            return items[--head1];
        }

        public E pop2(){
            if (head2 >= items.length - 1)
                throw new IndexOutOfBoundsException();
            return items[++head2];
        }

        public E peek1(){
            if (head1 <= 0)
                throw new IndexOutOfBoundsException();
            return items[head1-1];
        }

        public E peek2(){
            if (head2 >= items.length - 1)
                throw new IndexOutOfBoundsException();
            return items[head2+1];
        }

        public int size1(){
            return head1;
        }

        public int size2(){
            return items.length - head2 - 1;
        }

    }

}
