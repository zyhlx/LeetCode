/*
（小数，基准元素，大数）。在区间中随机挑选一个元素作基准，将小于基准的元素放在基准之前，大于基准的元素放在基准之后，再分别对小数区与大数区进行排序。
快速排序思路：
1. 选取第一个数为基准
2. 将比基准小的数交换到前面，比基准大的数交换到后面   到这步复杂度数n
3. 对左右区间重复第二步，直到各区间只有一个数

快速排序主要思想方法有两个：一趟排序和分治；
一趟排序完成数组的第一次排序，设置一个键值data,找到对应正确的位置，data的值插进去；
分治就是用分而治之的思想，将键值左右两侧分为两个部分，再调用递归，将左边的部分再分为两个部分，将右边的部分再分为两个部分，依此类推，直到将数组排列完。

快速排序是内排序中平均性能较好的排序，思想是每趟排序时选取一个数据（通常用数组的第一个数）作为关键数据，然后将所有比它小的数都放到它的左边，所有比它大的数都放到它的右边.

快速排序的特点：

1.不稳定；
2.快速排序过程中不会产生有序子序列，但每一趟排序后都有一个元素放在其最终位置上；
3.每次选择的关键值可以把数组分为两个子数组的时候，快速排序算法的速度最快，当数组已经是正序或逆序时速度最慢；
4.递归次数与每次划分后得到的分区的处理顺序无关；
5.对n个关键字进行快速排序，最大递归深度为n，最小递归深度为log2n；

在大多数实际情况中，快速排序是最佳选择。
快速排序之所以是最快的通用排序算法是因为它的内循环中指令很少，而且还能利用缓存，因为它总是顺序地访问数据。
所以它的运行时间增长数量级为约cNlgN，这里的c比其他线性对数级别的排序算法的相应常数都要小。
在使用三向切分快速排序后，对于实际应用中可能出现的某些分布的输入就变成线性级别的了，而其他排序算法依然需要线性对数时间。
但是，如果稳定性很重要而空间充足，归并排序是最好的选择。
而在运行时间至关重要的任何排序应用中，应考虑使用快速排序。
对于Java来说，会对原始数据类型使用三向切分的快速排序，而对引用类型使用归并排序。
这些选择实际上也表示了用速度和空间（对于原始数据类型）来换取稳定性（对于引用类型）。

*/

public class QuickSort{

    public static void QuickSort(int arr[], int low, int high) {
        if(low<high) {
            //防止发生栈溢出异常
            int index = PartSort(arr, low, high);
            QuickSort(arr, low, index - 1);
            QuickSort(arr, index + 1, high);
        }

    }


    public static int Partition(int arr[], int low, int high) {
        int data = arr[high];
        /*
         * 一次遍历的方法：插空法 定义一个data将arr[low]存起来，并把这个位置挖空
         */
        int i = low-1;
        for(int j = low;j<=high-1;j++){
            if(arr[j]<=data){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        arr[high] = arr[i+1];
        arr[i+1] = data;
        return i+1;
    }




    public static int PartSort(int arr[], int low, int high) {
        int data = arr[low];
        /*
         * 一次遍历的方法：插空法 定义一个data将arr[low]存起来，并把这个位置挖空
         */
        while (low < high) {
            while (low < high && arr[high] >= data) {
                high--;
            }
            arr[low] = arr[high];
            /**
             * 从high，也就是后面往前遍历 找到比键值小的数据 插入到前面留下的空中 high位再次留下空来
             */

            while (low < high && arr[low] <= data) {
                low++;
            }
            arr[high] = arr[low];

        }
        arr[low] = data;
        /*
         * 循环退出后 low和high重合 将将键值赋给第low，并将low返回
         */
        return low;
    }


    /*
    *void quickSort(vector<int> &s, int low, int high){
    if (low >= high)  return;
    int l = low, r = high, val = s[low];
    while (l < r){
        while (l < r&&s[r] >= val)  r--;
        if (l < r)  s[l++] = s[r];
        while (l < r&&s[l] <= val)  l++;
        if (l < r)  s[r--] = s[l];
    }
    s[l] = val;
    quickSort(s, low, l - 1);
    quickSort(s, r + 1, high);
}
    *
    *
    * */

}