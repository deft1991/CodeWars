package com.codewars.leetcode.problems.medium;

/**
 * @author Sergey Golitsyn
 * created on 26.05.2021
 */
public class CoinChange {

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();

        System.out.println(cc.coinChange(new int[]{1, 2, 5}, 11)); // 3
//        System.out.println(cc.coinChange(new int[]{2}, 3)); // -1
//        System.out.println(cc.coinChange(new int[]{1}, 0)); // 0
//        System.out.println(cc.coinChange(new int[]{1}, 1)); // 1
//        System.out.println(cc.coinChange(new int[]{1}, 2)); // 2
//        System.out.println(cc.coinChange(new int[]{1,2}, 4)); // 2
//        System.out.println(cc.coinChange(new int[]{1,2}, 6)); // 3
//        System.out.println(cc.coinChange(new int[]{1,2,3}, 6)); // 2
//        System.out.println(cc.coinChange(new int[]{1,2,3}, 8)); // 3
//        System.out.println(cc.coinChange(new int[]{1,2}, 8)); // 4
//        System.out.println(cc.coinChange(new int[]{186, 419, 83, 408}, 6249)); // 4
    }

    public int coinChange(int[] coins, int amount) {

        int[] changeArr = new int[amount + 1];

        changeArr[0] = 0;
        for (int coin : coins) {
            if (coin < changeArr.length) {
                changeArr[coin] = 1;
            }
        }

        return getCoinCount(amount, coins, changeArr);
    }

    public int getCoinCount(int amount, int[] coins, int[] changeArr) {
        int min = Integer.MAX_VALUE;

        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (changeArr[amount] != 0) {
            return changeArr[amount];
        }

        for (int coin : coins) {
            int rest = amount - coin;
            int localMin = getCoinCount(rest, coins, changeArr);
            if (localMin >= 0 && localMin < min) {
                min = 1 + localMin;
            }
        }
        changeArr[amount] = (min == Integer.MAX_VALUE) ? -1 : min;
        return changeArr[amount];
    }


    private int helper(int rem, int[] coins, int[] count) { // rem: remaining coins after the last step; count[rem]: minimum number of coins to sum up to rem
        int min = Integer.MAX_VALUE;

        if (rem < 0) {
            return -1; // not valid
        }
        if (rem == 0) {
            return 0; // completed
        }
        if (count[rem] != 0) {
            return count[rem]; // already computed, so reuse
        }

        for (int coin : coins) {
            int res = helper(rem - coin, coins, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem];
    }
}
