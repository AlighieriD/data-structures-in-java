package ch04.exercise.pr16;

/**
 * Created by YH on 2020/7/7.
 */
public class Pr16 {
    public static class MyTreeSet_Pr16<K extends Comparable<? super K>>{

        private static class Node<K>{
            boolean deleted = false;
            K k;
            Node<K> left;
            Node<K> right;
            Node(K k , Node<K> left , Node<K> right){
                this.k = k;
                this.left = left;
                this.right = right;
            }
        }

        private Node<K> root;

        public void insert(K k){
            root = insert(k, root);
        }

        private Node<K> insert(K k , Node<K> t){
            if (t == null)
                return new Node<>(k,null,null);
            int cpr = k.compareTo(t.k);
            if (cpr < 0)
                t.left = insert(k,t.left);
            else if (cpr > 0)
                t.right = insert(k,t.right);
            else
                t.deleted = true;
            return t;
        }

        public void remove(K k){
            remove(k,root);
        }

        private void remove(K k, Node<K> t){
            if (t == null)
                return;
            int cpr = k.compareTo(t.k);
            if (cpr < 0){
                remove(k,t.left);
            }else if (cpr > 0){
                remove(k,t.right);
            }else {
                t.deleted = true;
            }
        }

        public K findMin(){
            Node<K> node = findMin(root);
            return node != null ? node.k : null;
        }

        private Node<K> findMin(Node<K> t){
            if (t == null)
                return null;
            Node<K> min;
            min = findMin(t.left);
            if (min == null){
                if (!t.deleted){
                    min = t;
                } else {
                    min = findMin(t.right);
                }
            }
            return min;
        }

        public K findMax(){
            Node<K> node = findMax(root);
            return node != null ? node.k : null;
        }

        private Node<K> findMax(Node<K> t){
            if (t == null)
                return null;
            Node<K> max;
            max = findMin(t.right);
            if (max == null){
                if (!t.deleted){
                    max = t;
                } else {
                    max = findMax(t.left);
                }
            }
            return max;
        }

        public void print(){
            print(root);
        }

        private void print(Node<K> t){
            if (t == null)
                return;
            print(t.left);
            if (!t.deleted)
                System.out.println(t.k);
            print(t.right);
        }
    }
}
