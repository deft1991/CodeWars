package com.codewars.leetcode.array;

/*
 * Created by sgolitsyn on 1/9/20
 */
public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(2^2^1);
    }

    public int singleNumber(int[] nums) {
        int rez = 0;
        for(int i : nums){
            rez^=i;
        }
        return rez;
    }

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
