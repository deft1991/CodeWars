package com.codewars.leetcode.problems.easy;

/**
 * @author Sergey Golitsyn
 * created on 08.08.2022
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {

    }

    public int maxProfit2(int[] prices) {

        int max = 0;
        for(int i = 0; i < prices.length; i ++){
            for(int j = i+1; j < prices.length; j ++){
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }

    public int maxProfit(int[] prices) {

        int curMin = prices[0];
        int curMax = 0;
        for(int i = 0; i < prices.length; i ++){
            curMax = Math.max(curMax, prices[i]  - curMin);
            curMin = Math.min(curMin, prices[i]);
        }
        return curMax;
    }
}
