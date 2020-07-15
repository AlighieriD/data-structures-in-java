package ch04.exercise.pr21;

public class Pr21 {
    public static class MyAVLTree<K extends Comparable<? super K>,V>{
        protected static class EntryNode<K,V> {
            public K k;
            public V v;
            public int height;
            public EntryNode<K,V> left;
            public EntryNode<K,V> right;
            public EntryNode(K k, V v, int height, EntryNode<K,V> left, EntryNode<K,V> right){
                this.k = k;
                this.v = v;
                this.height = height;
                this.left = left;
                this.right = right;
            }
        }
        protected static final int TOLERANCE = 1;

        protected EntryNode<K,V> root;

        protected static int height(EntryNode node){
            return node == null ? -1 : node.height;
        }

        public void insert(K k, V v){
            root = insert(k,v,root);
        }

        private EntryNode<K,V> insert(K k, V v,EntryNode<K,V> node) {
            if (node == null)
                return new EntryNode<>(k,v,0,null,null);
            int cpr = k.compareTo(node.k);
            if (cpr < 0){
                node.left = insert(k,v,node.left);
            } else if (cpr > 0){
                node.right = insert(k,v,node.right);
            } else {

            }
            return balance(node);
        }

        public V remove(K k){
            EntryNode<K,V> holder = new EntryNode<>(k,null,-1,null,null);
            root = remove(k,root,holder);
            return holder.v;
        }

        private EntryNode<K,V> remove(K k, EntryNode<K,V> t,EntryNode<K,V> holder){
            if (t == null)
                return null;
            int cpr = k.compareTo(t.k);
            if (cpr < 0){
                t.left = remove(k,t.left,holder);
            } else if (cpr > 0){
                t.right = remove(k,t.right,holder);
            } else {
                if (holder.v == null)
                    holder.v = t.v;
                if (t.left != null && t.right != null){
                    EntryNode<K,V> min = findMin(t.right);
                    t.k = min.k;
                    t.v = min.v;
                    t.right = remove(min.k,t.right,holder);
                } else {
                    t = t.left != null ? t.left : t.right;
                }
            }
            return balance(t);
        }

        public EntryNode<K,V> findMin(EntryNode<K,V> t){
            while (t.left != null){
                t = t.left;
            }
            return t;
        }

        protected EntryNode<K,V> balance(EntryNode<K,V> node){
            if (node == null)
                return null;
            if (height(node.left) - height(node.right) > TOLERANCE){
                // node.left 的树高至少为1 ，
                if (height(node.left.left) >= height(node.left.right)){
                    node = rotateWithLeftChild(node);
                } else {
                    node = doubleWithLeftChild(node);
                }
            } else if (height(node.right) - height(node.left) > TOLERANCE){
                if (height(node.right.right) >= height(node.right.left)){
                    node = rotateWithRightChild(node);
                } else {
                    node = doubleWithRightChild(node);
                }
            } else {
                node.height = Math.max(height(node.left),height(node.right)) + 1;
            }
            return node;
        }

        protected EntryNode<K,V> rotateWithLeftChild(EntryNode<K,V> node){
            EntryNode<K,V> t = node.left;
            node.left = t.right;
            t.right = node;
            node.height = Math.max(height(node.left),height(node.right)) + 1;
            t.height = Math.max(height(t.left),height(t.right)) + 1;
            return t;
        }

        protected EntryNode<K,V> rotateWithRightChild(EntryNode<K,V> node){
            EntryNode<K,V> t = node.right;
            node.right = t.left;
            t.left = node;
            node.height = Math.max(height(node.left),height(node.right)) + 1;
            t.height = Math.max(height(t.left),height(t.right)) + 1;
            return t;
        }

        protected EntryNode<K,V> doubleWithLeftChild(EntryNode<K,V> node){
            node.left = rotateWithRightChild(node.left);
            return rotateWithLeftChild(node);
        }

        protected EntryNode<K,V> doubleWithRightChild(EntryNode<K,V> node){
            node.right = rotateWithLeftChild(node.right);
            return rotateWithRightChild(node);
        }

        public void print(){
            print(root);
        }

        private void print(EntryNode<K,V> t){
            if (t == null)
                return;
            print(t.left);
            System.out.println(height(t.left) + " : " + height(t.right));
            print(t.right);
        }

    }
}