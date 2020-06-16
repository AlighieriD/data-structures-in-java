package ch03.exercise.pr25;

import ch03.exercise.pr24.Pr24;

public class Pr25 {
    public static class Stack<E extends Comparable<? super E>>{
        private Pr24.TwoStack<E> stack;

        public int size(){
            return stack.size1();
        }

        public Stack(int size){
            stack = new Pr24.TwoStack<>(size << 1);
        }
        public void push(E e){
            if (e == null)
                throw new NullPointerException();
            stack.push1(e);
            if (stack.size2() == 0 || e.compareTo(stack.peek2()) <= 0)
                stack.push2(e);
        }

        public E pop(){
            E e = stack.pop1();
            if (stack.size2() != 0 && e.compareTo(stack.peek2()) == 0)
                stack.pop2();
            return e;
        }

        public E findMin(){
            return stack.peek2();
        }
    }

}
