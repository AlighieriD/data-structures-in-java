## 1.1 编写一个程序解决选择问题。
编写一个程序解决选择问题。令k=N/2。画出表格显示程序对于N种不同的值的运行时间。

---

书中p1页提到，设有一组N个数而要确定其中第k个最大者，我们称之为***选择问题***（selection problem）。
并且给出了两个显而易见的解决办法:
1. 将这N个数读入一个数组中，再通过某种简单的算法，比如冒泡排序，以递减将数组排序，然后返回位置k上的元素。
2. 稍微好一点的解法可以先把前k个元素读入数组并递减排序。然后将剩下的元素逐个读入，如果小于数组中的第k个元素则忽略之
否则就将其放到数组中正确的位置上，同时将数组中的一个元素挤出数组。最终返回第k个元素。
3. 第七章将讨论一种算法，该算法将在一秒钟左右给出（N=3000万，k=1500万）问题的解。
