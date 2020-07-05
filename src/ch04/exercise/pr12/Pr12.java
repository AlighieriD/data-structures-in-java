package ch04.exercise.pr12;

import ch04.exercise.pr11.Pr11;

import java.util.Map;
import java.util.TreeSet;

/**
 * Created by YH on 2020/7/4.
 */
public class Pr12 {

    public static class MyMapEntry<K extends Comparable<? super K>,V> implements Map.Entry<K,V> , Comparable<MyMapEntry<K,V>> {
        K k;
        V v;
        public MyMapEntry(K k, V v){
            this.k = k;
            this.v = v;
        }
        @Override
        public int compareTo(MyMapEntry<K, V> o) {
            return k.compareTo(o.k);
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }

        @Override
        public V setValue(V value) {
            V old = v;
            v = value;
            return old;
        }
    }

    public static class MyTreeMap<K extends Comparable<? super K>, V>{
        Pr11.MyTreeSet<MyMapEntry<K,V>> set = new Pr11.MyTreeSet<>();

        public void insert(K k, V v){
            MyMapEntry<K,V> entry = new MyMapEntry<>(k,v);
            set.remove(entry);
            set.insert(entry);
        }

        public void remove(K k){
            MyMapEntry<K,V> entry = new MyMapEntry<>(k,null);
            set.remove(entry);
        }

        public V get(K k){
            MyMapEntry<K,V> entry = new MyMapEntry<>(k,null);
            MyMapEntry<K,V> e = set.get(entry);
            if (e != null)
                return e.v;
            else
                return null;
        }

        public void print(){
            for (MyMapEntry<K,V> e : set){
                System.out.println(e.k + " : " + e.v);
            }
        }

    }
}
