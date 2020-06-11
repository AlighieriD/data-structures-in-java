package ch03.exercise.pr19;

/**
 * Created by YH on 2020/6/10.
 */
public class Pr19<E>{
    private int theSize;
    private int modCount = 0;
    private Node<E> first;
    private Node<E> last;

    public Pr19(){
        doClear();
    }

    public void clear(){
        doClear();
    }

    private void doClear(){
        first = last = null;
        theSize = 0;
        modCount++;
    }
    public int size(){
        return theSize;
    }

    public boolean add(E e){
        Node<E> l = last;
        Node<E> newNode = new Node<>(l,e,null);
        last = newNode;
        if (l == null){
            first = last;
        }else {
            l.next = newNode;
        }
        theSize++;
        modCount++;
        return true;
    }

    public void add(int idx, E e){
        if (idx < 0 || idx > size())
            throw new IndexOutOfBoundsException();
        Node<E> node = getNode(idx);
        if (idx != size())
            addBefore(node,e);
        else
            addAfter(node,e);
    }

    public E get(int idx){
        if (idx < 0 || idx >= size())
            throw new IndexOutOfBoundsException();
        return getNode(idx).e;
    }

    public E set(int idx, E e){
        if (idx < 0 || idx >= size())
            throw new IndexOutOfBoundsException();
        Node<E> n = getNode(idx);
        E old = n.e;
        n.e = e;
        return old;
    }

    public E remove(int idx){
        if (idx < 0 || idx >= size())
            throw new IndexOutOfBoundsException();
        E r = remove(getNode(idx));
        return r;
    }

    private void addAfter(Node<E> p, E e){
        Node<E> newNode = new Node<>(p,e,p.next);
        if (p.next == null){
            last = newNode;
        }
    }

    private void addBefore(Node<E> p, E e){
        Node<E> newNode = new Node<>(p.pre,e,p);
        if (p.pre == null){
            first = newNode;
        }
    }

    private E remove(Node<E> p){
        Node<E> pre = p.pre;
        Node<E> next = p.next;

        if (pre != null){
            pre.next = next;
        }else {
            first = next;
        }

        if (next != null){
            next.pre = pre;
        }else {
            last = pre;
        }
        theSize--;
        return p.e;
    }

    private Node<E> getNode(int idx){
        if (idx <= size() / 2){
            Node<E> f = first;
            for (int i = 0; i < idx; i++){
                f = f.next;
            }
            return f;
        }else {
            Node<E> l = last;
            for (int i = size() - 1; i > idx; i++){
                l = l.pre;
            }
            return l;
        }
    }


    private static class Node<E> {
        E e;
        Node<E> pre;
        Node<E> next;
        Node(Node<E> pre, E e, Node<E> next){
            this.pre = pre;
            this.e = e;
            this.next = next;
        }
    }
}
