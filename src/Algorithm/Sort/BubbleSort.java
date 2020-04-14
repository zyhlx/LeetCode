

/*
（无序区，有序区）。从无序区通过交换找出最大元素放到有序区前端。
选择排序思路：
1. 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
2. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
3. 针对所有的元素重复以上的步骤，除了最后一个。
4. 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。


第一次会是最大的往后跑交换到最后
第二次会是第二大的被交换到最后
……
*/

public class BubbleSort{
    public void bubbleSort(int[] arr){
        for(int i = 0;i < arr.length;i++){
            for(int j = 0;j < arr.length - 1 -i;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

    }
}