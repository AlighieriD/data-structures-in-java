package ch03.exercise.pr11;

public class Pr11 {
    private static class Node<E>{
        private E e;
        private Node<E> next;
        public Node(E e, Node<E> next){
            this.e = e;
            this.next = next;
        }
    }

    public static class MyLinkedList_PR11<E>{
        private int size = 0;
        private Node<E> head = new Node<>(null,null);

        // 返回链表大小的方法。
        public int getSize() {
            return size;
        }

        // 打印链表的方法。
        public void printList(){
            Node<E> curr = head.next;
            while (curr != null){
                System.out.println(curr.e);
                curr = curr.next;
            }
        }

        private void addAfter(Node<E> node, E e){
            if (node != null){
                Node<E> nextNode = node.next;
                node.next = new Node<>(e,nextNode);
            }
        }

        // 测试值X是否含于链表的方法。
        public boolean isContains(E e){
            return getPreNode(e) != null;
        }

        private Node<E> getPreNode(E e){
            Node<E> curr = head.next;
            Node<E> pre = head;
            if (e != null){
                while (curr != null){
                    if (e.equals(curr.e))
                        return pre;
                    pre = curr;
                    curr = curr.next;
                }
            } else {
                while (curr != null){
                    if (e == curr.e)
                        return pre;
                    pre = curr;
                    curr = curr.next;
                }
            }
            return null;
        }

        // 如果值X尚未含于链表，添加值X到该链表的方法。
        public boolean addIfAbsent(E x){
            if (!isContains(x)){
                addAfter(head,x);
                size++;
                return true;
            } else {
                return false;
            }
        }

        // 如果值X含于链表，将X从该链表中删除的方法。
        public E removeIfPresent(E x){
            Node<E> preNode = getPreNode(x);
            Node<E> nextNode = preNode.next;
            if (preNode != null){
                preNode.next = nextNode.next;
                size--;
                return nextNode.e;
            } else {
                return null;
            }
        }
    }
}
