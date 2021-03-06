package ch06.learn;

import java.util.NoSuchElementException;

/**
 * Created by YH on 2020/9/1.
 */
public class LeftisHeap<AnyType extends Comparable<? super AnyType>> {

    public LeftisHeap(){
        root = null;
    }

    public void merge(LeftisHeap<AnyType> rhs){
        if (this == rhs)
            return;
        root = merge(root, rhs.root);
        rhs.root = null;
    }

    public void insert(AnyType x){
        root = merge(root,new Node<>(x));
    }

    public AnyType findMin(){
        if (isEmpty())
            throw new NoSuchElementException();
        return root.element;
    }

    public AnyType deleteMin(){
        if (isEmpty())
            throw new NoSuchElementException();
        AnyType min = root.element;
        root = merge(root.left,root.right);
        return min;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void makeEmpty(){
        root = null;
    }

    private static class Node<AnyType>{
        Node(AnyType theElement){
            this(theElement,null,null);
        }

        Node(AnyType theElement, Node<AnyType> lt, Node<AnyType> rt){
            element = theElement;
            left = lt;
            right = rt;
            npl = 0;
        }

        AnyType element;
        Node<AnyType> left;
        Node<AnyType> right;
        int npl;
    }

    private Node<AnyType> root;

    private Node<AnyType> merge(Node<AnyType> h1, Node<AnyType> h2){
        if (h1 == null)
            return h2;
        if (h2 == null)
            return h1;
        if (h1.element.compareTo(h2.element) < 0)
            return merge1(h1,h2);
        else
            return merge1(h2,h1);
    }

    private Node<AnyType> merge1(Node<AnyType> h1, Node<AnyType> h2){
        if (h1.left == null)
            h1.left = h2;
        else{
            h1.right = merge(h1.right,h2);
            if (h1.left.npl < h1.right.npl)
                swapChildren(h1);
            h1.npl = h1.right.npl + 1;
        }
        return h1;
    }

    private void swapChildren(Node<AnyType> t){
        Node<AnyType> n = t.left;
        t.left = t.right;
        t.right = n;
    }
}
