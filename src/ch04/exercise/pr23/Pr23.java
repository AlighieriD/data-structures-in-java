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
            public int diff;
            public EntryNode<K,V> left;
            public EntryNode<K,V> right;
            public EntryNode<K,V> parent;
            public EntryNode(K k, V v, int diff, EntryNode<K,V> left, EntryNode<K,V> right, EntryNode<K,V> parent){
                this.k = k;
                this.v = v;
                this.diff = diff;
                this.left = left;
                this.right = right;
                this.parent = parent;
            }
        }

        private EntryNode<K,V> root;

        public void insert(K k, V v){
            if (root == null){
                root = new EntryNode<>(k,v, 0,null,null,null);
            } else {
                EntryNode<K,V> p = null;
                EntryNode<K,V> t = root;
                int cpr = 0;
                while (t != null){
                    cpr = k.compareTo(t.k);
                    if (cpr < 0){
                        t.diff++;
                        p = t;
                        t = t.left;
                    } else if (cpr > 0){
                        t.diff--;
                        p = t;
                        t = t.right;
                    }
                }
                if (cpr < 0){
                    p.left = new EntryNode<>(k,v, 0,null,null,p);
                } else if (cpr > 0){
                    p.right = new EntryNode<>(k,v, 0,null,null,p);
                }
                balance(p);
            }
        }

        private void balance(EntryNode<K,V> node){
            while (node != null && isBalance(node)){
                node = node.parent;
            }
            if (node == null)
                return;
            if (node.diff > 1){
                if (node.left.diff >= 0){
                    rotateWithLeftChild(node);
                } else {
                    doubleWithLeftChild(node);
                }
            } else if (node.diff < -1){
                if (node.right.diff <= 0){
                    rotateWithRightChild(node);
                } else {
                    doubleWithRightChild(node);
                }
            }


        }

        public V remove(K k){

        }

        private static boolean isBalance(EntryNode node){
            if (node == null)
                return true;
            return node.diff >= -1 && node.diff <= 1;
        }

        private EntryNode<K,V> rotateWithLeftChild(EntryNode<K,V> node){
            EntryNode<K,V> t = node.left;
            node.left = t.right;
            if (t.right != null)
                t.right.parent = node;
            t.right = node;
            node.parent = t;
            int x = t.diff, y = node.diff;
            if (x >= 0){
                if (y-x >= 1){
                    t.diff = x - 1;
                    node.diff = y - x - 1;
                } else {
                    t.diff = y - 2;
                    node.diff = y - x - 1;
                }
            } else {
                if (y >= 1){
                    t.diff = x - 1;
                    node.diff = y - 1;
                } else {
                    t.diff = x + y - 2;
                    node.diff =  y - 1;
                }
            }
            return t;
        }

        private EntryNode<K,V> rotateWithRightChild(EntryNode<K,V> node){
            EntryNode<K,V> t = node.right;
            node.right = t.left;
            if (t.left != null)
                t.left.parent = node;
            t.left = node;
            node.parent = t;
            int x = t.diff, y = node.diff;
            if (x <= 0){
                if (x-y >= 1){
                    t.diff = x + 1;
                    node.diff = y - x + 1;
                }else {
                    t.diff = y + 2;
                    node.diff = y - x + 1;
                }
            }else {
                if (y <= -1){
                    t.diff = x + 1;
                    node.diff = y + 1;
                }else {
                    t.diff = y + x + 2;
                    node.diff = y + 1;
                }
            }
            return t;
        }

        private EntryNode<K,V> doubleWithLeftChild(EntryNode<K,V> node){
            node.left = rotateWithRightChild(node.left);
            return rotateWithLeftChild(node);
        }

        private EntryNode<K,V> doubleWithRightChild(EntryNode<K,V> node){
            node.right = rotateWithLeftChild(node.right);
            return rotateWithRightChild(node);
        }

    }
}
