# LeetCode

## 📑 目录

* [〽️ 数据结构](#️-数据结构)
* [⚡️ 算法](#️-算法)
* [❓ Problems](#-problems)
* [💻 操作系统](#-操作系统)
* [☁️ 计算机网络](#️-计算机网络)
* [🌩 网络编程](#-网络编程)
* [💾 数据库](#-数据库)
* [📏 设计模式](#-设计模式)
* [⚙️ 链接装载库](#️-链接装载库)
* [📚 书籍](#-书籍)
* [🔱 C/C++ 发展方向](#-cc-发展方向)
* [💯 复习刷题网站](#-复习刷题网站)


## ⚡️ 算法

### 排序

排序算法 | 平均时间复杂度 | 最差时间复杂度 | 空间复杂度 | 数据对象稳定性 | 适用范围
---|---|---|---|---|---
[冒泡排序](Algorithm/Sort/BubbleSort.java) | O(n<sup>2</sup>)|O(n<sup>2</sup>)|O(1)|稳定|数据量量不大，对稳定性有要求，且数据基本有序的情况下
[选择排序](Algorithm/Sort/SelectionSort.java) | O(n<sup>2</sup>)|O(n<sup>2</sup>)|O(1)|数组不稳定、链表稳定|当数据量不大，且对稳定性没有要求的时候
[插入排序](Algorithm/Sort/InsertSort.java) | O(n<sup>2</sup>)|O(n<sup>2</sup>)|O(1)|稳定|数据量不大，对算法的稳定性有要求，且数据局部或者整体有序的情况，小规模如10个数平均时间最快，可以在快排中调用
[快速排序](Algorithm/Sort/QuickSort.java) | O(n*log<sub>2</sub>n) |  O(n<sup>2</sup>) | O(log<sub>2</sub>n) | 不稳定 | 数值范围较大，相同值的概率较小，数据量大且不考虑稳定性的情况，数值远大于数据量时威力更大。由于快速排序的原理，常用于查找一组中前k大的数据
[堆排序](Algorithm/Sort/HeapSort.java) | O(n*log<sub>2</sub>n)|O(n*log<sub>2</sub>n)|O(1)|不稳定|数据量较大，且对稳定性无要求，不如用快排或归并，但取前几个最值时可以不用排序完，奇效。（快排有空间需求，所以STL的SORT就是当快排深度太深的时候就用堆排了）也适用于多核并行处理;
[归并排序](Algorithm/Sort/MergeSort.java) | O(n*log<sub>2</sub>n) | O(n*log<sub>2</sub>n)|O(n)|稳定|数据规模较大，对稳定性有要求，一般用于总体无序，但是各子项相对有序的数列
[希尔排序](Algorithm/Sort/ShellSort.java) | O(n*log<sup>2</sup>n)|O(n<sup>2</sup>)|O(1)|不稳定|数据量较大，不要求稳定性
[计数排序](Algorithm/Sort/CountSort.java) | O(n+m)|O(n+m)|O(n+m)|稳定
[桶排序](Algorithm/Sort/BucketSort.java) | O(n)|O(n)|O(m)|稳定|仅适用于数据的分布相对比较集中的时候，其原理是建立一个包含一定数目桶的表，将待排序的数据通过散列算法散列到桶中，然后再遍历桶的到有序的数据。
[基数排序](Algorithm/Sort/RadixSort.java) | O(k*n)|O(n<sup>2</sup>)| |稳定|数值都是非负整数，且范围较小的情况，尤其适用于256位的ASCII码，用作字符串的字典顺序排序

> * 均按从小到大排列
> * k：代表数值中的 “数位” 个数
> * n：代表数据规模
> * m：代表数据的最大值减最小值
> * 来自：[wikipedia . 排序算法](https://zh.wikipedia.org/wiki/%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95)

```text
各种排序算法的使用范围总结：

      (1)当数据规模较小的时候，可以使用简单的排序算法如直接插入排序或直接选择排序。

      (2)当待排序表的初始状态已经基本有序时，可以使用直接插入排序（希尔排序）或冒泡排序。

当数据规模较大时，应采用时间复杂度为O(nlogn)的排序方法：快速排序、堆排序、归并排序。

      (3)当数据规模较大时，应用速度快的排序算法。可以考虑快速排序。当记录随机分布的时候，快排的平均时间最短，但可能出现最坏的情况，这时候的时间复杂度是O(n^2)，且递归深度为n，所需的栈空间为O(n)。

      (4)堆排序不会出现快排那样的最坏情况，且堆排序所需的辅助空间比快排要少。但这两种算法都不是稳定的，若要求排序时稳定，可以考虑用归并排序。

       (5)归并排序可以用于内部排序，也可以用于外部排序。在外部排序时，通常采用多路归并，并且通过解决长顺串的合并，产生长的初始串，提高主机与外设并行能力等措施，以减少访问外存次数，提高外排序的效率。

     （6）当数据规模很大，记录的关键字位数较少且可以分解时，采用基数排序较好。
```

### 查找

查找算法 | 平均时间复杂度 | 空间复杂度 | 查找条件
---|---|---|---
[顺序查找](Algorithm/Find/SequentialSearch.java) | O(n) | O(1) | 无序或有序
[二分查找（折半查找）](Algorithm/BinarySearch.h) | O(log<sub>2</sub>n)| O(1) | 有序
[插值查找](Algorithm/InsertionSearch.h) | O(log<sub>2</sub>(log<sub>2</sub>n)) | O(1) | 有序
[斐波那契查找](Algorithm/FibonacciSearch.cpp) | O(log<sub>2</sub>n) | O(1) | 有序
[哈希查找](DataStructure/HashTable.cpp) | O(1) | O(n) | 无序或有序
[二叉查找树（二叉搜索树查找）](Algorithm/BSTSearch.h) |O(log<sub>2</sub>n) |   | 
[红黑树](DataStructure/RedBlackTree.cpp) |O(log<sub>2</sub>n) | |
2-3树 | O(log<sub>2</sub>n - log<sub>3</sub>n) |   | 
B树/B+树 |O(log<sub>2</sub>n) |   | 

### 图搜索算法

图搜索算法 |数据结构| 遍历时间复杂度 | 空间复杂度
---|---|---|---
[BFS广度优先搜索](https://zh.wikipedia.org/wiki/%E5%B9%BF%E5%BA%A6%E4%BC%98%E5%85%88%E6%90%9C%E7%B4%A2)|邻接矩阵<br/>邻接链表|O(\|v\|<sup>2</sup>)<br/>O(\|v\|+\|E\|)|O(\|v\|<sup>2</sup>)<br/>O(\|v\|+\|E\|)
[DFS深度优先搜索](https://zh.wikipedia.org/wiki/%E6%B7%B1%E5%BA%A6%E4%BC%98%E5%85%88%E6%90%9C%E7%B4%A2)|邻接矩阵<br/>邻接链表|O(\|v\|<sup>2</sup>)<br/>O(\|v\|+\|E\|)|O(\|v\|<sup>2</sup>)<br/>O(\|v\|+\|E\|)

### 其他算法

算法 |思想| 应用
---|---|---
[分治法](https://zh.wikipedia.org/wiki/%E5%88%86%E6%B2%BB%E6%B3%95)|把一个复杂的问题分成两个或更多的相同或相似的子问题，直到最后子问题可以简单的直接求解，原问题的解即子问题的解的合并|[循环赛日程安排问题](https://github.com/huihut/interview/tree/master/Problems/RoundRobinProblem)、排序算法（快速排序、归并排序）
[动态规划](https://zh.wikipedia.org/wiki/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92)|通过把原问题分解为相对简单的子问题的方式求解复杂问题的方法，适用于有重叠子问题和最优子结构性质的问题|[背包问题](https://github.com/huihut/interview/tree/master/Problems/KnapsackProblem)、斐波那契数列
[贪心法](https://zh.wikipedia.org/wiki/%E8%B4%AA%E5%BF%83%E6%B3%95)|一种在每一步选择中都采取在当前状态下最好或最优（即最有利）的选择，从而希望导致结果是最好或最优的算法|旅行推销员问题（最短路径问题）、最小生成树、哈夫曼编码