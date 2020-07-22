package ch04.exercise.pr30;

public class Pr30 {
    public static class Spread_Tree<K extends Comparable<? super K>,V>{
        protected class Entry{
            public K k;
            public V v;
            public Entry left;
            public Entry right;
            public Entry parent;

            public Entry(K k, V v, Entry left, Entry right, Entry parent){
                this.k = k;
                this.v = v;
                this.left = left;
                this.right = right;
                this.parent = parent;
            }
        }
        Entry root;

        public void insert(K k, V v){
            if (root == null){
                root = new Entry(k,v,null,null,null);
            } else {
                root = insert(k,v,root);
            }
        }

        private Entry insert(K k, V v, Entry t){
            if (t == null)
                return new Entry(k,v,null,null,null);
            int cpr = k.compareTo(t.k);
            if (cpr < 0){
                Entry e = insert(k,v,t.left);
                t.left = e;
                e.parent = t;
            } else if (cpr > 0){
                Entry e = insert(k,v,t.right);
                t.right = e;
                e.parent = t;
            } else {

            }
            return t;
        }

        private void spread(Entry t){
            if (t == root)
                return;
            while (t != null){
                if (t.parent == root){
                    if (root.left == t){
                        root.left = t.right;
                        t.right = root;
                        t.parent = root.parent;
                        root.parent = t;
                        root = t;
                    } else {
                        root.right = t.left;
                        t.left = root;
                        t.parent = root.parent;
                        root.parent = t;
                        root = t;
                    }
                } else {
                    Entry g = t.parent.parent;
                    
                }
            }
        }

        private Entry zigzag(Entry t){

        }

        private Entry zigzig(Entry t){

        }

    }
}
