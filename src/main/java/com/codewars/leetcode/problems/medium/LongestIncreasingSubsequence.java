package com.codewars.leetcode.problems.medium;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 11.10.2022
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        LongestIncreasingSubsequence li = new LongestIncreasingSubsequence();
        System.out.println(li.lengthOfLISOld(new int[]{1, 9, 9, 3, 4, 5})); //  5
        System.out.println(li.lengthOfLIS(new int[]{0,1,0,3,2,3})); //  4
        System.out.println(li.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18})); //  4
        System.out.println(li.lengthOfLIS(new int[]{7,7,7,7,7,7,7})); //  1
    }

    /*
    1,9,3,4,5

     */

    public int lengthOfLISOld(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int rez = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    rez = Math.max(rez, dp[i]);
                }
            }
        }
        return rez;
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;

    }
}
