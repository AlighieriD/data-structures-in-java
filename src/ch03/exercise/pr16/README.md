## 3.16 提供另一种方式的ListIterator。
提供ListIterator的另一种方式是提供带有声明
`Iterator<AnyType> reverseIterator()`
的表，它返回一个Iterator，并被初始化至最后一项，其中next和hasNext
被实现成与迭代器向表的前端（而不是向后）推进一致。然后，你可以通过使用程序
```
    Iterator<AnyType> ritr = L.reverseIterator();
    while(ritr.hasNext())
        System.out.println(ritr.next());
```
反向打印MyArrayList L。用这种思路实现ArrayListReverseIterator类，让reverseIterator返回一个
新构造的ArrayListReverseIterator。

---