## 3.8 下列例程删除作为参数被传递的表的前半部分:
```
public static void removeFirstHalf(List<?> lst)
{
    int theSize = lst.size() / 2;
    for ( int i = 0; i < theSize; i++ ){
        lst.remove(0);
    }
}
```

a. 为什么在进入for循环前存储theSize？
b. 如果lst是一个ArrayList，removeFirstHalf的运行时间是多少？
c. 如果lst是一个LinkedList，removeFirstHalf的运行时间是多少？
d. 对于这两种类型的List使用迭代器都能使removeFirstHalf更快吗？

---

a. 因为remove会改变lst.size()返回的值。
b. O(N2)，因为ArrayList的remove方法（尤其是在数组头部的）会引起resize
c. O(N)，因为remove总是发生在链表头部，所以没有发生遍历
d. 不会，对于数组，迭代器不会使其变快，而对于链表，迭代器会加快其遍历的速度，但是removeFirstHalf没有发生遍历