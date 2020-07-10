package ch04.exercise.pr21;

public class Pr21 {
    public static class MyAVLTree<K extends Comparable<? super K>,V>{
        private static class EntryNode<K,V> {
            K k;
            V v;
            int height;
            EntryNode<K,V> left;
            EntryNode<K,V> right;
            EntryNode(K k, V v, int height, EntryNode<K,V> left, EntryNode<K,V> right){
                this.k = k;
                this.v = v;
                this.height = height;
                this.left = left;
                this.right = right;
            }
        }
        private static final int TOLERANCE = 1;

        EntryNode<K,V> root;

        private int height(EntryNode<K,V> node){
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
            //TODO 平衡
            return balance(node);
        }

        private EntryNode<K,V> balance(EntryNode<K,V> node){
            if (node == null)
                return null;
            if (height(node.left) - height(node.right) > TOLERANCE){
                // node.left 的树高至少为1 ，
                if (height(node.left.left) - height(node.left.right) > TOLERANCE){
                    node = rotateWithLeftChild(node);
                } else {
                    node = doubleWithLeftChild(node);
                }
            } else if (height(node.right) - height(node.left) > TOLERANCE){
                if (height(node.right.right) - height(node.right.left) > TOLERANCE){
                    node = rotateWithRightChild(node);
                } else {
                    node = doubleWithRightChild(node);
                }
            } else {
                node.height = Math.max(height(node.left),height(node.right)) + 1;
            }
            return node;
        }

        private EntryNode<K,V> rotateWithLeftChild(EntryNode<K,V> node){
            EntryNode<K,V> t = node.left;
            node.left = t.right;
            t.right = node;
            node.height = Math.max(height(node.left),height(node.right)) + 1;
            t.height = Math.max(height(t.left),height(t.right)) + 1;
            return t;
        }

        private EntryNode<K,V> rotateWithRightChild(EntryNode<K,V> node){
            EntryNode<K,V> t = node.right;
            node.right = t.left;
            t.left = node;
            node.height = Math.max(height(node.left),height(node.right)) + 1;
            t.height = Math.max(height(t.left),height(t.right)) + 1;
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

    public static void main(String[] args) {
        MyAVLTree<String,String> myAVLTree = new MyAVLTree<>();
        myAVLTree.insert("A","AAA");
        myAVLTree.insert("B","BBB");
        myAVLTree.insert("C","CCC");
        myAVLTree.insert("D","DDD");
        myAVLTree.insert("E","EEE");
        myAVLTree.insert("F","FFF");
        myAVLTree.insert("G","GGG");
        myAVLTree.insert("H","HHH");
//        myAVLTree.print();
    }
}
