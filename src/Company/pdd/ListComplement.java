package Company.pdd;

import java.util.Scanner;
/*
* 在商城的某个位置有一个商品列表，该列表是由L1、L2两个子列表拼接而成。当用户浏览并翻页时，需要从列表L1、L2中获取商品进行展示。展示规则如下：

1. 用户可以进行多次翻页，用offset表示用户在之前页面已经浏览的商品数量，比如offset为4，表示用户已经看了4个商品

2. n表示当前页面需要展示的商品数量

3. 展示商品时首先使用列表L1，如果列表L1长度不够，再从列表L2中选取商品

4. 从列表L2中补全商品时，也可能存在数量不足的情况

请根据上述规则，计算列表L1和L2中哪些商品在当前页面被展示了


输入描述:
每个测试输入包含1个测试用例，包含四个整数，分别表示偏移量offset、元素数量n，列表L1的长度l1，列表L2的长度l2。

输出描述:
在一行内输出四个整数分别表示L1和L2的区间start1，end1，start2，end2，每个数字之间有一个空格。
注意，区间段使用半开半闭区间表示，即包含起点，不包含终点。如果某个列表的区间为空，使用[0, 0)表示，如果某个列表被跳过，使用[len, len)表示，len表示列表的长度。

输入例子1:
2 4 4 4
1 2 4 4
4 1 3 3

输出例子1:
2 4 0 2
1 3 0 0
3 3 1 2*/

public class ListComplement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) { //判断是否结束
            int offset = sc.nextInt();//读入整数
            int n = sc.nextInt();//读入整数
            int l1 = sc.nextInt();//读入整数
            int l2 = sc.nextInt();//读入整数
            int start1 = 0;
            int start2 = 0;
            int end1 = l1;
            int end2 = l2;
            // 如果offset >= l1，说明l1全部使用，更新l2的offset
            if (offset >= l1) {
                start1 = l1;
                end1 = l1;
                offset = offset - l1;
            }
            // 如果offset < l1，说明l2部分使用，使用部分为[offset, (l1与offset+n较小值)]
            // 更新offset和n
            else {
                start1 = offset;
                end1 = n + offset >= l1 ? l1 : offset + n;
                offset = 0;
                n = n - (end1 - start1);
            }
            // 对l2处理同l1
            // 只不过不用在结束时更新offset和n
            if (offset >= l2) {
                start2 = l2;
                end2 = l2;
            } else {
                start2 = offset;
                end2 = n + offset >= l2 ? l2 : offset + n;
            }
            System.out.println(start1 + " " + end1 + " " + start2 + " " + end2);
        }
    }

}
