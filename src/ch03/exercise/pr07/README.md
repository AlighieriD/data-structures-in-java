## 3.7 下列程序的运行时间是多少？
```
public static int makeList(int N)
{
    ArrayList<Integer> lst = new ArrayList<>();
    for ( int i = 0; i < N; i++ ){
        lst.add(i);
        lst.trimToSize();
    }
}
```

---

O(N2). 
不管是add隐含的扩容还是trimToSize，都需要调用Arrays.copyOf方法，调用N次，所以为O(N2)