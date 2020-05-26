package ch03.exercise.pr02;

public class Pr02 {
    public static class SingleLinkedList<E>{
        private Node<E> first;
        private Node<E> last;
        private int size;
        private static class Node<E> {
            E value;
            Node<E> next;
            Node(E e, Node<E> next){
                this.value = e;
                this.next = next;
            }
        }
        public void add(E e){
            final Node<E> l = last;
            Node<E> node = new Node<>(e,null);
            last = node;
            if (l == null){
                first = node;
            }else {
                l.next = node;
            }
            size++;
        }


        /**
         * 通过只调整链（而不是数据）来交换两个相邻的元素。
         * 通用接口
         * 是否相邻，是否是头尾节点，都需要考虑
         * @param i
         * @param j
         */
        public void swap(int i, int j){
            // TODO i j 是否符合规则
            Node<E> f = first;
            Node<E> prei = null, prej = null;
            int start = 0;
            // TODO 此处假设j > i
            while (f != null && start <= j){
                if (start == i - 1){
                    prei = f;
                } else if (start == j - 1){
                    prej = f;
                }
                start++;
                f = f.next;
            }
            // i == 0的情况
            if (prei == null){

            }else {
                prei.next.next = prej.next.next;
                prei.next = prej.next;
                if (j - i == 1){
                    prei.next.next = prej;
                }else {
                    prei.next.next
                }
            }
        }
    }
    public class DoubleLinkedList<E>{

    }
}
