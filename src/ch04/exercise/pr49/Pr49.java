package ch04.exercise.pr49;

/**
 * Created by YH on 2020/7/26.
 */
public class Pr49 {
    public static class TreeSet_PR49<K extends Comparable<? super K>> {
        public class Node<K>{
            K k;
            Node<K> left;
            Node<K> right;
            int leftCount;
            Node(K k,Node<K> left,Node<K> right,int leftCount){
                this.k = k;
                this.left = left;
                this.right = right;
                this.leftCount = leftCount;
            }
        }

        private Node<K> root;

        public void insert(K k){
            root = insert(k,root);
        }

        private Node<K> insert(K k, Node<K> t){
            if (t == null)
                return new Node<>(k,null,null,1);
            int cpr = k.compareTo(t.k);
            if (cpr < 0){
                t.leftCount++;
                t.left = insert(k,t.left);
            } else if (cpr > 0){
                t.right = insert(k, t.right);
            } else {

            }
            return t;
        }

        public K findKth(int k){
            Node<K> n = findKth(k,root);
            return n != null ? n.k : null;
        }

        private Node<K> findKth(int k, Node<K> t){
            if (t == null)
                return null;
            if (k == t.leftCount)
                return t;
            else if (k < t.leftCount)
                return findKth(k,t.left);
            else
                return findKth(k - t.leftCount,t.right);
        }
    }
}
