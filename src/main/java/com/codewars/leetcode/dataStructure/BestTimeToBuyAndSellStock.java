package com.codewars.leetcode.dataStructure;

/**
 * @author Sergey Golitsyn
 * created on 03.04.2022
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock b = new BestTimeToBuyAndSellStock();
        System.out.println(b.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int prev = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prev < prices[i]) {
                dp[i] = Math.max(dp[i - 1], prices[i] - prev);
            } else {
                dp[i] = dp[i - 1];
                prev = prices[i];
            }
        }
        return dp[dp.length - 1];
    }
}
