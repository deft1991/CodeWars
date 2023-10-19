package com.codewars.GRIND75;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 14.09.2023
 */
public class CoinChange {

    public static void main(String[] args) {
        CoinChange c = new CoinChange();
        System.out.println(c.coinChange(new int[]{1,2,5}, 11));
    }

    public int coinChange(int[] coins, int amount) {
        return bottomUp(coins, amount);
    }

    private int bottomUp(int[] coins, int amount){
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int coin : coins){
            for(int i = coin; i < dp.length; i++){
                int prev = dp[i - coin];
                if (prev != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], prev + 1);
                }
            }
        }
        return dp[amount];
    }
}
