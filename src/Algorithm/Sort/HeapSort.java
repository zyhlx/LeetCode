/*
* 堆排序是基于选择排序的一种排序算法，堆是一个近似完全二叉树的结构，且满足子结点的键值或索引总是小于（或者大于）它的父节点。
* 这里采用最大堆方式：位于堆顶的元素总是整棵树的最大值，每个子节点的值都比父节点小，堆要时刻保持这样的结构，所以一旦堆里面的数据发生变化，要对堆重新进行一次构建。
* 不稳定，最坏，最好，平均时间复杂度均为O(nlogn)
* 应用就是优先队列适合topn
* */
public class HeapSort{
    // 构建大根堆：将array看成完全二叉树的顺序存储结构
    private static int[] buildMaxHeap(int[] array) {
        // 从最后一个节点array.length-1的父节点（array.length-1-1）/2开始，直到根节点0，反复调整堆
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            adjustDownToUp(array, i, array.length);
        }
        return array;
    }


    // 将元素array[k]自下往上逐步调整树形结构
    private static void adjustDownToUp(int[] array, int k, int length) {
        int temp = array[k];
        for (int i = 2 * k + 1; i < length; i = 2 * i + 1) {
            // i为初始化为节点k的左孩子，沿节点较大的子节点向下调整
            if (i < length-1 && array[i] < array[i + 1]) {
                // 取节点较大的子节点的下标
                i++; // 如果节点的右孩子>左孩子，则取右孩子节点的下标
            }
            if (temp >= array[i]) {
                // 根节点 >=左右子女中关键字较大者，调整结束
                break;
            } else { // 根节点 <左右子女中关键字较大者
                // 将左右子结点中较大值array[i]调整到双亲节点上
                array[k] = array[i];
                k = i; // 【关键】修改k值，以便继续向下调整
            }
        }
        array[k] = temp; // 被调整的结点的值放在最终位置
    }

    // 堆排序
    public static int[] heapSort(int[] array) {
        array = buildMaxHeap(array); // 初始建堆，array[0]为第一趟值最大的元素
        for (int i = array.length - 1; i > 1; i--) {
            // 将堆顶元素和堆低元素交换，
            // 即得到当前最大元素正确的排序位置
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            adjustDownToUp(array, 0, i); // 整理，将剩余的元素整理成堆
        }
        return array;
    }

    // 插入操作:向大根堆array中插入数据data
    public int[] insertData(int[] array, int data) {
        array[array.length - 1] = data; // 将新节点放在堆的末端
        int k = array.length - 1; // 需要调整的节点
        int parent = (k - 1) / 2; // 双亲节点
        while (parent >= 0 && data > array[parent]) {
            array[k] = array[parent]; // 双亲节点下调
            k = parent;
            if (parent != 0) {
                parent = (parent - 1) / 2; // 继续向上比较
            } else { // 根节点已调整完毕，跳出循环
                break;
            }
        }
        array[k] = data; // 将插入的结点放到正确的位置
        return array;
    }

    // 删除堆顶元素操作
    public int[] deleteMax(int[] array) {
        // 将堆的最后一个元素与堆顶元素交换，堆底元素值设为-99999
        array[0] = array[array.length - 1];
        array[array.length - 1] = -99999;
        // 对此时的根节点进行向下调整
        adjustDownToUp(array, 0, array.length);
        return array;
    }

    //测试
    public static void main(String args[]) {
        HeapSort hs = new HeapSort();
        int[] array = { 87, 45, 78, 32, 17, 65, 53, 9, 122 };
        System.out.print("构建大根堆：");
        hs.toString(hs.buildMaxHeap(array));
        System.out.print("\n" + "删除堆顶元素：");
        hs.toString(hs.deleteMax(array));
        System.out.print("\n" + "插入元素63:");
        hs.toString(hs.insertData(array, 63));
        System.out.print("\n" + "大根堆排序：");
        hs.toString(hs.heapSort(array));
    }

}
/*
*
* void max_heapify(vector<int> &arr, int start, int end) {
    //建立父节点指标和子节点指标
    int dad = start;
    int son = dad * 2 + 1;
    while (son <= end) { //若子节点指标在范围内才做比较
        if (son + 1 <= end && arr[son] < arr[son + 1]) //先比较两个子节点大小，选择最大的
            son++;
        if (arr[dad] > arr[son]) //如果父节点大於子节点代表调整完毕，直接跳出函数
            return;
        else { //否则交换父子内容再继续子节点和孙节点比较
            swap(arr[dad], arr[son]);
            dad = son;
            son = dad * 2 + 1;
        }
    }
}

void heap_sort(vector<int> &arr, int len) {
    //初始化，i从最後一个父节点开始调整
    for (int i = len / 2 - 1; i >= 0; i--)
        max_heapify(arr, i, len - 1);
    //先将第一个元素和已经排好的元素前一位做交换，再从新调整(刚调整的元素之前的元素)，直到排序完毕
    for (int i = len - 1; i > 0; i--) {
        swap(arr[0], arr[i]);
        max_heapify(arr, 0, i - 1);
    }
}
*
*
* */