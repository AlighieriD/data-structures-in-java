package ch04.exercise.pr11;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeMap;

/**
 * Created by YH on 2020/7/1.
 */
public class Pr11 {

    /**
     * 编写TreeSet类的实现程序，其中相关的迭代器使用二叉查找树。
     * 在每个节点上添加一个指向其父节点的链。
     * @param <K>
     */
    public static class MyTreeSet<K extends Comparable<? super K>> implements Iterable<K>{
        private class Node{
            private K k;
            private Node left;
            private Node right;
            private Node patent;
            public Node(K k,Node left, Node right, Node patent){
                this.k = k;
                this.left = left;
                this.right = right;
                this.patent = patent;
            }

        }

        private Node root;

        public void insert(K k){
            root = insert(k,root,null);
        }

        private Node insert(K k,Node t, Node pt){
            if (t == null) {
                return new Node(k,null,null,pt);
            }

            int cpr = t.k.compareTo(k);
            if (cpr > 0){
                t.left = insert(k,t.left,t);
            } else if (cpr < 0) {
                t.right = insert(k,t.right,t);
            } else {

            }
            return t;
        }

        public void remove(K k){
            root = remove(k,root);
        }

        public boolean contains(K k){
            return contains(k,root);
        }

        private boolean contains(K k, Node t){
            if (t == null)
                return false;
            int cpr = t.k.compareTo(k);
            if (cpr == 0)
                return true;
            else if (cpr > 0)
                return contains(k,t.left);
            else
                return contains(k,t.right);
        }

        private Node remove(K k, Node t){
            if (t == null)
                return null;
            int cpr = t.k.compareTo(k);
            if (cpr > 0){
                t.left = remove(k,t.left);
            }else if (cpr < 0){
                t.right = remove(k,t.right);
            }else {
                if (t.left != null && t.right != null){
                    t.k = findMin(t.right).k;
                    t.right = remove(t.k,t.right);
                } else {
                    Node oneNode = t.left != null ? t.left : t.right;
                    if (oneNode == null){
                        t = null;
                    } else {
                        oneNode.patent = t.patent;
                        t = oneNode;
                    }
                }
            }
            return t;
        }

        private Node findMin(Node t){
            Node min = t;
            while (min.left != null){
                min = min.left;
            }
            return min;
        }

        public void printTree(){
            printTree(root);
        }

        private void printTree(Node t){
            if (t == null)
                return;
            printTree(t.left);
            System.out.println(t.k);
            printTree(t.right);
        }

        public K get(K k){
            return get(k,root);
        }

        public K get(K k ,Node t){
            if (t == null)
                return null;
            int cpr = t.k.compareTo(k);
            if (cpr > 0){
                return get(k, t.left);
            } else if (cpr < 0) {
                return get(k,t.right);
            } else {
                return t.k;
            }
        }

        @Override
        public Iterator<K> iterator() {
            return new MyTreeSetItr();
        }

        private class MyTreeSetItr implements Iterator<K>{
            Node current = findMin(root);
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public K next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                Node t = current;
                if (current.right != null) {
                    current = findMin(current.right);
                } else {
                    while (current.patent != null && current.patent.k.compareTo(t.k) < 0){
                        current = current.patent;
                    }
                    current = current.patent;
                }
                return t.k;
            }
        }
    }
}
