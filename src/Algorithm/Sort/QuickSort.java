/*
（小数，基准元素，大数）。在区间中随机挑选一个元素作基准，将小于基准的元素放在基准之前，大于基准的元素放在基准之后，再分别对小数区与大数区进行排序。
快速排序思路：
1. 选取第一个数为基准
2. 将比基准小的数交换到前面，比基准大的数交换到后面   到这步复杂度数n
3. 对左右区间重复第二步，直到各区间只有一个数

快速排序主要思想方法有两个：一趟排序和分治；
一趟排序完成数组的第一次排序，设置一个键值data,找到对应正确的位置，data的值插进去；
分治就是用分而治之的思想，将键值左右两侧分为两个部分，再调用递归，将左边的部分再分为两个部分，将右边的部分再分为两个部分，依此类推，直到将数组排列完。

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
}