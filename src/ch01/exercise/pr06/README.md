## 1.6 输出str中的字符的所有排列
编写带有下列声明的例程：
public void permute(String str);
private void permute(char[] str, int low, int high);
第一个例程是个驱动程序，它调用第二个例程并显示String str中的字符的所有排列。
如果str是"abc"，那么输出的串则是abc,acb,bac,bca,cab和cba。第二个例程使用递归。

---
