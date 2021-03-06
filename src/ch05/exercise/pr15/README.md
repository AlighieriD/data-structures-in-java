## 5.15 
设欲找出在长输入串A1A2A3...An中串P1P2...Pk的第一次出现。我们可以通过散列模式串（pattern string）
得到一个散列值Hp,并将该值与从A1A2...Ak, A2A3...Ak+1,A3A4...Ak+2,等等直到A(n-k+1)A(n-k+2)...An
形成的散列值比较来解决这个问题。
如果得到散列值的一个匹配,那么再逐个字符地对串进行比较以检验这个匹配。
如果串实际上确实匹配,那么返回其(在A中的)位置,而在匹配失败这种不大可能的情况下继续进行查找。

 *a. 证明如果A(i)A(i+1)...A(i+k-1)的散列值已知,那么A(i+1)A(i+2)...A(i+k)的散列值可以以常数时间算出。

  b. 证明运行时间为O(k + N)加上排除错误匹配所消耗的时间。

 *c. 证明错误匹配的期望次数是微不足道的。

  d. 编写一个程序实现该算法。

**e. 描述一个算法，其最坏情形的运行时间为O(k + N)。

**f. 描述一个算法，其平均运行时间为O(N/k)。

---
