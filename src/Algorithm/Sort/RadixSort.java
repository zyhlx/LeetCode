package Algorithm.Sort;

// 基数排序：一种多关键字的排序算法，可用桶排序实现。
//基数排序是一种非比较型整数排序算法，其原理是将数据按位数切割成不同的数字，然后按每个位数分别比较，在类似对百万级的电话号码进行排序的问题上，使用基数排序效率较高
//基数排序特点：稳定，时间复杂度为O (nlog(r)m)，其中r为所采取的基数，而m为堆数，在某些时候，基数排序法的效率高于其它的稳定性排序法。
public class RadixSort{
    //寻找数组中最大数的位数作为基数排序循环次数
    /*
    int KeySize(vector<int> &s, int n){
        int key = 1;
        for (int i = 0; i < n; i++){
            int temp = 1;
            int r = 10;
            while (s[i] / r > 0){
                temp++;
                r *= 10;
            }
            key = (temp > key) ? temp : key;
        }
        return key;
    }

    //基数排序
    void RadixSort(vector<int> &s, int n){
        int key = KeySize(s, n);
        int bucket[10][10] = { 0 };
        int order[10] = { 0 };
        for (int r = 1; key > 0; key--, r *= 10){
            for (int i = 0; i < n; i++){
                int lsd = (s[i] / r) % 10;
                bucket[lsd][order[lsd]++] = s[i];
            }
            int k = 0;
            for (int i = 0; i < 10; i++){
                if (order[i] != 0){
                    for (int j = 0; j < order[i]; j++)
                        s[k++] = bucket[i][j];
                }
                order[i] = 0;
            }
        }
    }

     */
}