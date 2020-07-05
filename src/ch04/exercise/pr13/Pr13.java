package ch04.exercise.pr13;

/**
 * Created by YH on 2020/7/5.
 */
public class Pr13 {
    public static class MyTreeSet_Pr13<K extends Comparable<? super K>>{
        private static class Node<K> {
            K k;
            Node<K> left;
            Node<K> right;
            Node<K> nt;
            Node<K> pr;
            Node(K k){
                this.k = k;
            }
            Node(K k,Node<K> left,Node<K> right,Node<K> nt,Node<K> pr){
                this.k = k;
                this.left = left;
                this.right = right;
                this.nt = nt;
                this.pr = pr;
            }
        }

        Node<K> root;
        Node<K> min;
        Node<K> max;

        public void insert(K k){
            root = insert(k,root,null,null);
        }

        public Node<K> insert(K k, Node<K> t,Node<K> nt, Node<K> pr){
            if (t == null){
                Node<K> n = new Node<>(k,null,null,nt,pr);
                if (nt != null)
                    nt.pr = n;
                if (pr != null)
                    pr.nt = n;

                if (min == null)
                    min = n;
                else
                    min = k.compareTo(min.k) < 0 ? n : min;
                if (max == null)
                    max = n;
                else
                    max = k.compareTo(max.k) > 0 ? n : max;
                return n;
            }
            int cpr = k.compareTo(t.k);
            if (cpr < 0){
                t.left = insert(k,t.left,t,pr);
            }else if (cpr > 0){
                t.right = insert(k,t.right,nt,t);
            }else {

            }
            return t;
        }


        public void remove(K k){
            root = remove(k,root,null,null);
        }

        private Node<K> remove(K k, Node<K> t, Node<K> nt, Node<K> pr){
            if (t == null)
                return null;
            int cpr = k.compareTo(t.k);
            if (cpr < 0){
                t.left = remove(k,t.left,t,pr);
            } else if (cpr > 0){
                t.right = remove(k,t.right,nt,t);
            } else {
                if (t.left != null && t.right != null){
                    Node<K> min = findMin(t.right);
                    t.k = min.k;
                    t.nt = nt;
                    if (nt != null)
                        nt.pr = t;
                    t.right = remove(min.k,t.right,nt,pr);
                } else {
                    Node<K> n = t.left == null ? t.right : t.left;
                    if (n != null){
                        n.nt = nt;
                        if (nt != null)
                            nt.pr = n;
                        n.pr = pr;
                        if (pr != null)
                            pr.nt = n;
                    }
                    if (min.k.compareTo(t.k) == 0){
                        min = t.nt;
                    }
                    if (max.k.compareTo(t.k) == 0){
                        max = t.pr;
                    }
                    t = n;
                }
            }
            return t;
        }

        private Node<K> findMin(Node<K> t){
            Node<K> node = t;
            while (node.left != null){
                node = node.left;
            }
            return node;
        }

        public void print(){
            Node<K> cur = min;
            while (cur != null){
                System.out.println(cur.k);
                cur = cur.nt;
            }
        }

    }
}
