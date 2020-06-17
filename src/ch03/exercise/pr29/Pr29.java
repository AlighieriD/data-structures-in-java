package ch03.exercise.pr29;

import ch03.exercise.pr28.Pr28;

public class Pr29 {
    public static class MyDeque_PR29<E> extends Pr28.MyDeque<E> {
        public void revertPrint(){
            Node<E> last = tail.pre;
            while (last != head){
                System.out.println(last.e);
                last = last.pre;
            }
        }
    }
}
