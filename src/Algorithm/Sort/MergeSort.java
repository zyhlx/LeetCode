// 归并排序：把数据分为两段，从两段中逐个选最小的元素移入新数据段的末尾。可从上到下或从下到上进行。

public class MergeSort{
    /*****************
     迭代版
     非递归的方法，避免了递归时深度为log2N的栈空间，空间只是用到归并临时申请的跟原来数组一样大小的空间，并且在时间性能上也有一定的提升，因此，使用归并排序是，尽量考虑用非递归的方法
     *****************/
    /*

    public static void MergeSort2(int[] arr)
    {
        //使用非递归的方式来实现归并排序
        int len = arr.length;
        int k = 1;

        while(k < len)
        {
            MergePass(arr, k, len);
            k *= 2;
        }
    }

    //MergePass方法负责将数组中的相邻的有k个元素的字序列进行归并
    private static void MergePass(int[] arr, int k, int n)
    {
        int i = 0;
        int j;

        //从前往后,将2个长度为k的子序列合并为1个
        while(i < n - 2*k + 1)
        {
            merge(arr, i, i + k-1, i + 2*k - 1);
            i += 2*k;
        }

        //这段代码保证了，将那些“落单的”长度不足两两merge的部分和前面merge起来。
        if(i < n - k )
        {
            merge(arr, i, i+k-1, n-1);
        }

    }

    //merge函数实际上是将两个有序数组合并成一个有序数组
    //因为数组有序，合并很简单，只要维护几个指针就可以了
    private static void merge(int[] arr, int low, int mid, int high)
    {
        //temp数组用于暂存合并的结果
        int[] temp = new int[high - low + 1];
        //左半边的指针
        int i = low;
        //右半边的指针
        int j = mid+1;
        //合并后数组的指针
        int k = 0;

        //将记录由小到大地放进temp数组
        for(; i <= mid && j <= high; k++)
        {
            if(arr[i] < arr[j])
                temp[k] = arr[i++];
            else
                temp[k] = arr[j++];
        }

        //接下来两个while循环是为了将剩余的（比另一边多出来的个数）放到temp数组中
        while(i <= mid)
            temp[k++] = arr[i++];

        while(j <= high)
            temp[k++] = arr[j++];

        //将temp数组中的元素写入到待排数组中
        for(int l = 0; l < temp.length; l++)
            arr[low + l] = temp[l];
    }
    *
    *
    *
    * */




    /*****************
     递归版
     *****************/
    public static void merge(int arr[],int low,int mid,int high ) {
        int temp[]=new int[high-low+1];
        /*
         * 创建数组的三种方法
         * 1.new int[数组长度];
         * 2.｛数组的数据｝；
         * 3.new int[]{数组的数据}
         */
        int i=low;
        //第一个数组的首索引
        int j=mid+1;
        //第二个数组的首索引
        int k=0;
        //新数组的首索引
        while(i<=mid&&j<=high) {
            if(arr[i]<arr[j]) {
                temp[k++]=arr[i++];
            }
            else {
                temp[k++]=arr[j++];
            }
        }
        //把两个有序数组剩下的部分合并到新数组中
        while(i<=mid) {
            temp[k++]=arr[i++];
        }
        while(j<=high) {
            temp[k++]=arr[j++];
        }
        for(int n=0;n<temp.length;n++) {
            arr[n+low]=temp[n];
        }
        //排序好的数组放置在temp中，要将其复制到arr中。
    }

    public static void MergeSort(int arr[],int low,int high) {
        int mid=(low+high)/2;
        if(low<high) {
            //防止栈溢出异常
            MergeSort(arr,low,mid);
            MergeSort(arr,mid+1,high);
            merge(arr, low, mid, high);
        }

    }

}




