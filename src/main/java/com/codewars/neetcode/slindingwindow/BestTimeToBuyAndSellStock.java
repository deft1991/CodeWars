package com.codewars.neetcode.slindingwindow;

/**
 * @author Sergey Golitsyn
 * created on 10.12.2022
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock b = new BestTimeToBuyAndSellStock();
        System.out.println(b.maxProfit(new int[]{7,1,5,3,6,4})); // 5
        System.out.println(b.maxProfit(new int[]{7,6,4,3,1})); // 0
    }

    public int maxProfit(int[] prices) {
        int rez = 0;

        int start = 0;
        int end = start + 1;

        while (end < prices.length){

            if (prices[end] > prices[start]){
                rez = Math.max(rez, prices[end] - prices[start]);
                end++;
            } else {
                start = end;
                end++;
            }
        }
        return rez;
    }
}
