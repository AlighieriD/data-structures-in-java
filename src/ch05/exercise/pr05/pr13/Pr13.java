package ch05.exercise.pr05.pr13;

import ch03.exercise.pr12.Pr12;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;

/**
 * Created by YH on 2020/8/9.
 */
public class Pr13 {
    public static class Node implements Comparable<Node>{
        // a * x ^ b
        int a;
        int b;
        Node(int a, int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return a + "x^" + b;
        }

        @Override
        public int compareTo(Node o) {
            return b - o.b;
        }
    }
    public static void multiplyPolynomial(Pr12.MyLinkedList_PR12<Node> p1,Pr12.MyLinkedList_PR12<Node> p2){
        HashMap<Integer , Node> hashMap = new LinkedHashMap<>();
        for (Node n1 : p1){
            for (Node n2 : p2){
                int a = n1.a * n2.a ;
                int b = n1.b + n2.b;
                Node n = hashMap.get(b);
                if (n != null){
                    hashMap.put(b,new Node(a + n.a, b));
                } else {
                    hashMap.put(b,new Node(a, b));
                }
            }
        }
        for (Node n : hashMap.values()){
            System.out.println(n);
        }

    }
}
