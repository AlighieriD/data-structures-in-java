package ch03.exercise.pr06;

import java.util.LinkedList;

/**
 * Created by YH on 2020/6/1.
 */
public class Pr06 {

    private static class Node{
        private int i;
        private Node pre;
        private Node next;
        Node(Node pre, int i, Node next){
            this.i = i;
            this.pre = pre;
            this.next = next;
        }
    }
    public int josephus(int n, int m){
        Node head = new Node(null,-1,null);
        Node curr = head;
        for (int i = 0; i < n; i++) {
            curr.next = new Node(curr,i+1,null);
            curr = curr.next;
        }
        curr.next = head.next;
        head.next.pre = curr;
        curr = curr.next;
        while (curr.next != curr){
            int start = 0;
            while (start++ < m){
                curr = curr.next;
            }
            curr.pre.next = curr.next;
            curr.next.pre = curr.pre;
            curr = curr.next;
        }
        return curr.i;
    }

    public static void main(String[] args) {
        Pr06 p = new Pr06();
        System.out.println(p.josephus(5,1));

    }
}
