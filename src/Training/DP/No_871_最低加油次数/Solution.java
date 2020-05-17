package Training.DP.No_871_最低加油次数;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public static int minRefuelStops1(int target, int startFuel, int[][] stations) {
        //建立最大堆模拟后备箱
        Queue<Integer> priorityQueue = new PriorityQueue<>((Integer i1, Integer i2) -> Integer.compare(i2, i1));
        int currentFuel = startFuel;
        int times = 0;
        int currentPosition = 0;
        int stationsnums = stations.length;

        //在汽车当前油量无法到达终点，不断进行加油前进至一个最远可达的加油站
        while (currentFuel < target) {
            //将车子开至当前油量能够到达的最远加油站，将途径所有加油站的油装至后备箱
            while (currentPosition < stationsnums && stations[currentPosition][0] <= currentFuel) {
                priorityQueue.add(stations[currentPosition++][1]);
            }
            //如果没有途径加油站，汽车将无法到达终点
            if (priorityQueue.isEmpty())
                return -1;
            //贪心：将后备箱当前最多的一桶油给汽车加上，继续前进
            currentFuel += priorityQueue.poll();
            times++;
        }

        return times;
    }
}
/*
*
* class Solution {
   public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int N = stations.length;
        long[] dp = new long[N + 1];
        dp[0] = startFuel;
        for (int i = 0; i < N; ++i)
            for (int t = i; t >= 0; --t)
                if (dp[t] >= stations[i][0])
                    dp[t+1] = Math.max(dp[t+1], dp[t] + (long) stations[i][1]);

        for (int i = 0; i <= N; ++i)
            if (dp[i] >= target) return i;
        return -1;
    }
}*/
