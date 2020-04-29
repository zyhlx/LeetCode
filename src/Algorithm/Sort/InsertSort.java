package Algorithm.Sort;

/*
（有序区，无序区）。把无序区的第一个元素插入到有序区的合适的位置。对数组：比较得少，换得多。
插入排序思路：
1. 从第一个元素开始，该元素可以认为已经被排序
2. 取出下一个元素，在已经排序的元素序列中从后向前扫描
3. 如果该元素（已排序）大于新元素，将该元素移到下一位置
4. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
5. 将新元素插入到该位置后
6. 重复步骤2~5


插入排序的特点：

1.稳定;

2.最坏情况下比较n*(n-1)/2次，最好情况下比较n-1次;

3.第k次排序后，前k个元素已经是从小到大排好序的
*/
public class InsertSort{
    public void insertSort(int[] arr){
        for(int i=1;i<arr.length;i++) {
            int temp=arr[i];
            //temp存放将要插入的数据
            if(arr[i]<arr[i-1]) {
                int j;
                for(j=i-1;j>=0&&arr[j]>temp;j--) {
                    arr[j+1]=arr[j];
                    //temp的位置空出来，把第j个的值赋给第j+1个；
                }
                arr[j+1]=temp;
            }
        }
    }
}