package com.codewars.leetcode.problems.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 06.10.2022
 */
public class CoinChangeDP {

    public static void main(String[] args) {
        CoinChangeDP cc = new CoinChangeDP();
        System.out.println(cc.coinChange(new int[]{1,2,5}, 5)); // 1
        System.out.println(cc.coinChange(new int[]{1,2,5}, 10)); // 2
        System.out.println(cc.coinChange(new int[]{1,2,5}, 11)); // 3
        System.out.println(cc.coinChange(new int[]{2}, 3)); // -1
    }

    public int coinChange(int[] coins, int amount) {
//        return bottomUp(coins, amount);
        return topDown(coins, amount);
    }

    private int bottomUp(int[] coins, int amount){
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int coin : coins){
            for (int i = coin; i <= amount; i++){
                int prevCoinValue = dp[i - coin];
                if (prevCoinValue != Integer.MAX_VALUE){
                    dp[i] = Math.min(prevCoinValue + 1, dp[i]);
                }
            }
        }
        return dp[amount];
    }

    private int topDown(int[] coins, int amount){
        Map<Integer, Integer> change = new HashMap<>();
        int rez = helper(coins, amount, change);
        return rez == Integer.MAX_VALUE ? -1 : rez;
    }

    private int helper(int[] coins, int amount, Map<Integer, Integer> map){
        if (amount == 0){
            return 0;
        }
        if (map.containsKey(amount)){
            return map.get(amount);
        }
        if (amount < 0){
            return Integer.MAX_VALUE - 1;
        }

        int minCount = Integer.MAX_VALUE;
        for (int coin : coins){
            int count = helper(coins, amount - coin, map);
            if (count == Integer.MAX_VALUE){
                count = Integer.MAX_VALUE - 1;
            }
            minCount = Math.min(minCount, count + 1);
        }
        map.put(amount, minCount);
        return map.get(amount);
    }
}
