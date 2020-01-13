package com.codewars.leetcode.array;

/*
 * Created by sgolitsyn on 11/26/19
 */
public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        BestTimeToBuyAndSellStockII buyAndSellStockII = new BestTimeToBuyAndSellStockII();

        System.out.println(buyAndSellStockII.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(buyAndSellStockII.maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(buyAndSellStockII.maxProfit(new int[]{7,6,4,3,1}));
    }

    public int maxProfit(int[] prices) {
        int profit = 0;

        if (prices.length <= 1){
            return profit;
        }

        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i-1];
            if (diff > 0){
                profit +=diff;
            }
        }
        return profit;
    }
}
