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
        int rotat = 0;

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

        public int getRotat() {
            return rotat;
        }

        private void spread(Entry t){
            if (t == root)
                return;
            if (t.parent == root){
                if (root.left == t){
                    root.left = t.right;
                    t.right = root;
                    t.parent = root.parent;
                    root.parent = t;
                } else {
                    root.right = t.left;
                    t.left = root;
                    t.parent = root.parent;
                    root.parent = t;
                }
                rotat++;
            } else {
                Entry g = t.parent.parent;
                Entry p = t.parent;
                boolean isLeft1 = g.left == p;
                boolean isLeft2 = p.left == t;
                if (isLeft1 && isLeft2){
                    zigzig_left(t);
                } else if (!isLeft1 && !isLeft2){
                    zigzig_right(t);
                } else if (isLeft1 && !isLeft2){
                    zigzag_left(t);
                } else {
                    zigzag_right(t);
                }
            }
            if (t.parent == null)
                root = t;
            spread(t);
        }

        public V find(K k){
            Entry p = null;
            Entry t = root;
            int cpr;
            while (t != null){
                cpr = k.compareTo(t.k);
                if (cpr < 0){
                    p = t;
                    t = t.left;
                } else if (cpr > 0){
                    p = t;
                    t = t.right;
                } else {
                    spread(t);
                    return t.v;
                }
            }
            spread(p);
            return null;
        }

        private void zigzag_left(Entry t){
            Entry g = t.parent.parent;
            Entry p = t.parent;
            p.right = t.left;
            t.left = p;
            p.parent = t;
            t.parent = g.parent;
            g.left = t.right;
            t.right = g;
            g.parent = t;
            rotat++;
        }

        private void zigzag_right(Entry t){
            Entry g = t.parent.parent;
            Entry p = t.parent;
            p.left = t.right;
            t.right = p;
            p.parent = t;
            t.parent = g.parent;
            g.right = t.left;
            t.left = g;
            g.parent = t;
            rotat++;
        }

        private void zigzig_left(Entry t){
            Entry g = t.parent.parent;
            Entry p = t.parent;
            p.left = t.right;
            t.right = p;
            p.parent = t;
            t.parent = g.parent;
            g.left = p.right;
            p.right = g;
            g.parent = p;
            rotat++;
        }

        private void zigzig_right(Entry t){
            Entry g = t.parent.parent;
            Entry p = t.parent;
            p.right = t.left;
            t.left = p;
            p.parent = t;
            t.parent = g.parent;
            g.right = p.left;
            p.left = g;
            g.parent = p;
            rotat++;
        }

    }
}
