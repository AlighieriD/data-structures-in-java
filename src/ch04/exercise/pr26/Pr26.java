package ch04.exercise.pr26;

import ch04.exercise.pr23.Pr23;

/**
 * Created by YH on 2020/7/18.
 */
public class Pr26 {
    public static class MyAVLTree_Pr26<K extends Comparable<? super K>,V> extends Pr23.PR23_AVL_Tree<K,V> {
        @Override
        protected Pr23.PR23_AVL_Tree.EntryNode<K, V> doubleWithLeftChild(Pr23.PR23_AVL_Tree.EntryNode<K, V> node) {
            System.out.println("新版");
            Pr23.PR23_AVL_Tree.EntryNode<K, V> t = node.left;
            Pr23.PR23_AVL_Tree.EntryNode<K, V> n = t.right;
            t.right = n.left;
            if (n.left != null)
                n.left.parent = t;
            node.left = n.right;
            if (n.right != null)
                n.right.parent = node;
            n.left = t;
            n.right = node;
            t.parent = n;
            node.parent = n;

            int z = node.diff, x = t.diff, y = n.diff;
            int k1,k2,k3;
            if (y > 0){
                k1 = x + 1;
                if (x > -1){
                    k3 = z - x - y - 2;
                    if (k1 >= 0 && k3 >= 0){
                        k2 = x + y + 1;
                    } else if (k1 >= 0 && k3 < 0){
                        k2 = z - 1;
                    } else if (k1 < 0 && k3 >= 0){
                        k2 = y;
                    } else {
                        k2 = z - x - 2;
                    }
                } else {
                    k3 = z - y - 2;
                    if (k1 >= 0 && k3 >= 0){
                        k2 = x + y + 1;
                    } else if (k1 >= 0 && k3 < 0){
                        k2 = x + z - 1;
                    } else if (k1 < 0 && k3 >= 0){
                        k2 = y;
                    } else {
                        k2 = z - 2;
                    }
                }
            } else {
                k1 = x - y + 1;
                if (x > -1){
                    k3 = z - x - 2;
                    if (k1 >= 0 && k3 >= 0){
                        k2 = x + 1;
                    } else if (k1 >= 0 && k3 < 0){
                        k2 = z - 1;
                    } else if (k1 < 0 && k3 >= 0){
                        k2 = y;
                    } else {
                        k2 = y - x + z - 2;
                    }
                } else {
                    k3 = z - 2;
                    if (k1 >= 0 && k3 >= 0){
                        k2 = x + 1;
                    } else if (k1 >= 0 && k3 < 0){
                        k2 = x + z - 1;
                    } else if (k1 < 0 && k3 >= 0){
                        k2 = y;
                    } else {
                        k2 = y + z - 2;
                    }
                }
            }
            node.diff = k3;
            t.diff = k1;
            n.diff = k2;
            return n;
        }

        @Override
        protected Pr23.PR23_AVL_Tree.EntryNode<K, V> doubleWithRightChild(Pr23.PR23_AVL_Tree.EntryNode<K, V> node) {
            return super.doubleWithRightChild(node);
        }
    }
}
