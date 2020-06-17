## 3.20 懒惰删除法。
不同于我们已经给出的删除方法，另一种是使用**懒惰删除**的删除方法。
要删除一个元素，我们只是标记上该元素被删除（使用一个附加的位（bit）域）。
表中被删除和非被删除元素的个数作为数据结构的一部分被保留。
如果被删除元素和非被删除元素一样多，则遍历整个表，对所有被标记的节点执行标准的删除算法。
a. 列出懒惰删除的优点和缺点。
b. 编写使用懒惰删除实现标准链表操作的相应例程。

---

a. 
    优点：对于删除操作更容易编码
    缺点：需要更多的空间，遍历需要更多时间
    
b. 
    只实现了部分方法。
    增强for循环未实现