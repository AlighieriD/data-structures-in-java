package ch04.exercise.pr23;

import ch04.exercise.pr21.Pr21;

/**
 * Created by YH on 2020/7/11.
 */
public class Pr23 {
    public static class PR23_AVL_Tree<K extends Comparable<? super K>,V> {
        private static class EntryNode<K,V> {
            public K k;
            public V v;
            public byte diff;
            public EntryNode<K,V> left;
            public EntryNode<K,V> right;
            public EntryNode<K,V> parent;
            public EntryNode(K k, V v, int height, EntryNode<K,V> left, EntryNode<K,V> right, EntryNode<K,V> parent){
                this.k = k;
                this.v = v;
                this.height = height;
                this.left = left;
                this.right = right;
                this.parent = parent;
            }
        }

        private EntryNode<K,V> root;

        public void insert(K k, V v){

        }

        public V remove(K k){

        }

        private EntryNode<K,V> rotateWithLeftChild(EntryNode<K,V> node){
            EntryNode<K,V> t = node.left;
            node.left = t.right;
            t.right = node;
            
            return t;
        }

        private EntryNode<K,V> rotateWithRightChild(EntryNode<K,V> node){

        }

        private EntryNode<K,V> doubleWithLeftChild(EntryNode<K,V> node){

        }

        private EntryNode<K,V> doubleWithRightChild(EntryNode<K,V> node){

        }

    }
}
