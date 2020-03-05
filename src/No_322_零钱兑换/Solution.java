package No_322_零钱兑换;

import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        int [] f = new int[amount + 1];
        f[0] = 0;
        for(int i = 1; i <= amount; i++){
            int cost = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++){
                if(i - coins[j] >= 0){
                    if(f[i-coins[j]] != Integer.MAX_VALUE)
                        cost = Math.min(cost, f[i - coins[j]] + 1);
                }
            }
            f[i] = cost;
        }
        return  f[amount] == Integer.MAX_VALUE? -1 : f[amount];
    }
    public static void main(String[] args){
        int coins[] = {1,2,5};
        System.out.println(new Solution().coinChange(coins,11));
    }
}