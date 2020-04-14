/*
（有序区，无序区）。在无序区里找一个最小的元素跟在有序区的后面。对数组：比较得多，换得少。
选择排序就是把无序区的最小元素与首元素互换位置，然后将有序区的区间扩大一位，直到所有无序区都变成有序区。
选择排序思路：
1. 在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
2. 从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾
3. 以此类推，直到所有元素均排序完毕
*/
public class SelectionSort{
    public void SelectionSort(int[] arr){
        for(int i=0;i<arr.length-1;i++) {
            int min=i;
            //位置还不确定的数据
            //找到无序区里的最小元素  不稳定的因为后面的相同的数会被换到前面来
            for(int j=i+1;j<arr.length;j++) {
                if(arr[j]<arr[min]) {
                    min=j;
                    //遍历找到比k小的索引，然后把j赋给k；
                }
            }
            //交换
            if(i!=min) {
                int temp=arr[i];
                arr[i]=arr[min];
                arr[min]=temp;
            }
        }
    }

}