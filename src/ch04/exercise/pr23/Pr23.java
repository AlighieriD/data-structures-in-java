package ch04.exercise.pr23;

import ch04.exercise.pr21.Pr21;

/**
 * Created by YH on 2020/7/11.
 */
public class Pr23 {
    public static class PR23_AVL_Tree<K extends Comparable<? super K>,V> {
        protected static class EntryNode<K,V> {
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
                        p = t;
                        t = t.left;
                    } else if (cpr > 0){
                        p = t;
                        t = t.right;
                    } else {
                        break;
                    }
                }
                if (cpr < 0){
                    p.left = new EntryNode<>(k,v, 0,null,null,p);
                    p.diff++;
                } else if (cpr > 0){
                    p.right = new EntryNode<>(k,v, 0,null,null,p);
                    p.diff--;
                }
                balanceForInsert(p);
            }
        }

        private void balanceForInsert(EntryNode<K,V> node){
            EntryNode<K,V> p = node.parent;
            while (node != null && node.diff != 0){
                //检查当前节点是否需要旋转
                //更新父节点的diff
                if (!isBalance(node)){
                    EntryNode<K,V> newNode = null;
                    if (node.diff > 1){
                        if (node.left.diff >= 0){
                            newNode = rotateWithLeftChild(node);
                        } else {
                            newNode = doubleWithLeftChild(node);
                        }
                    } else if (node.diff < -1){
                        if (node.right.diff <= 0){
                            newNode = rotateWithRightChild(node);
                        } else {
                            newNode = doubleWithRightChild(node);
                        }
                    }
                    if (p != null){
                        if (p.left == node){
                            p.left = newNode;
                        } else {
                            p.right = newNode;
                        }
                    }else {
                        root = newNode;
                    }
                    newNode.parent = p;
                    // 旋转后树高恢复为插入之前，不必再通知父节点
                    break;
                }

                if (p == null)
                    break;

                if (p.left == node)
                    p.diff++;
                else
                    p.diff--;
                node = p;
                p = node.parent;
            }
        }

        private void balanceForDelete(EntryNode<K,V> node){
            EntryNode<K,V> p = node.parent;
            while (node != null && node.diff != -1 && node.diff != 1){
                //检查当前节点是否需要旋转
                //更新父节点的diff
                if (!isBalance(node)){
                    EntryNode<K,V> newNode = null;
                    if (node.diff > 1){
                        if (node.left.diff >= 0){
                            newNode = rotateWithLeftChild(node);
                        } else {
                            newNode = doubleWithLeftChild(node);
                        }
                    } else if (node.diff < -1){
                        if (node.right.diff <= 0){
                            newNode = rotateWithRightChild(node);
                        } else {
                            newNode = doubleWithRightChild(node);
                        }
                    }
                    if (p != null){
                        if (p.left == node){
                            p.left = newNode;
                        } else {
                            p.right = newNode;
                        }
                    }else {
                        root = newNode;
                    }
                    newNode.parent = p;
                    node = newNode;
                }

                if (p == null)
                    break;

                if (node.diff == 0){
                    if (p.left == node)
                        p.diff--;
                    else
                        p.diff++;
                    node = p;
                    p = node.parent;
                }else {
                    break;
                }
            }

        }


        public V remove(K k){
            return remove(k,root);
        }
        private V remove(K k, EntryNode<K,V> t){
            EntryNode<K,V> p = null;
            int cpr = 0;
            while (t != null){
                cpr = k.compareTo(t.k);
                if (cpr < 0){
                    p = t;
                    t = t.left;
                } else if (cpr > 0){
                    p = t;
                    t = t.right;
                } else {
                    if (t.left != null && t.right != null){
                        EntryNode<K,V> min = findMin(t.right);
                        V v = t.v;
                        t.k = min.k;
                        t.v = min.v;
                        remove(min.k,t.right);
                        return v;
                    } else {
                        if (p.left == t){
                            t = t.left != null ? t.left : t.right;
                            p.left = t;
                            p.diff--;
                        } else {
                            t = t.left != null ? t.left : t.right;
                            p.right = t;
                            p.diff++;
                        }
                        if (t != null)
                            t.parent = p;
                    }
                    break;
                }
            }
            balanceForDelete(p);
            return t != null ? t.v : null;
        }

        private EntryNode<K,V> findMin(EntryNode<K,V> t){
            while (t.left != null){
                t = t.left;
            }
            return t;
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

        protected EntryNode<K,V> doubleWithLeftChild(EntryNode<K,V> node){
            System.out.println("旧版");
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
            System.out.println(t.k+" 平衡因子："+t.diff);
            print(t.right);
        }

    }

}
