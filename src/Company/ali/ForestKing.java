package Company.ali;

import java.util.Scanner;

public class ForestKing {
/*
**第一道:**动物之王
选动物老大，n个小动物，编号1-n,代表武力值，值越小，武力值越高，每个小动物都有一票投票权，可以投给自己或者自己崇拜的动物，或者和自己崇拜的动物跟票。
* 只能崇拜武力值比自己厉害的动物。*/

    /**
     * Alibaba Exam1<br/>
     * 森林之王<br/>
     * 注意类名必须为Main, 不要有任何package xxx信息
     * @author Charles Song
     * @date 2020-4-13
     */

        public static void main (String[] args) {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNextInt()) {
                int num = sc.nextInt();
                int[] A = new int[num];
                for (int i = 0 ; i < num ; i++) {
                    A[i] = sc.nextInt();
                }
                count(num, A);
            }
        }

        /**
         * 计算每个动物可能收到的票数，并打印
         * @param num 动物数目
         * @param A 动物崇拜情况
         */
        public static void count (int num, int[] A) {
            int[] sum = new int[num];
            for (int i = 0; i < num ; i ++) {
                // 投票
                vote(A,i,sum );
            }
            for (int i = 0 ; i < num ; i ++) {
                System.out.println(sum[i]);
            }
        }

        /**
         * 递归投票
         * @param A 崇拜情况
         * @param idx 当前的动物
         * @param sum 投票情况
         */
        public static void vote (int[] A, int idx, int[] sum) {
            // 崇拜的对象
            int admIdx = A[idx] - 1;
            // 投自己
            sum[idx] ++;
            // 没有崇拜的对象
            if (admIdx >= 0) {
                // 有崇拜对象则和崇拜对象投一样
                vote(A, admIdx, sum);
            }
        }

}
