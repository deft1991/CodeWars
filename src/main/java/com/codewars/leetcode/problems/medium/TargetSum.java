package com.codewars.leetcode.problems.medium;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 02.10.2022
 */
public class TargetSum {

    public static void main(String[] args) {
        TargetSum ts = new TargetSum();
//        int targetSumWays1 = ts.findTargetSumWaysDP(new int[]{1, 1, 1, 1, 1}, 5);
//        System.out.println(targetSumWays1);
//        int targetSumWays2 = ts.findTargetSumWaysDP(new int[]{1, 1, 1, 1, 1}, 3);
//        System.out.println(targetSumWays2);
        int targetSumWays3 = ts.findTargetSumWaysDP(new int[]{1, 2}, 3);
        System.out.println(targetSumWays3);
    }

    int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        count = 0;
        calculate(nums, target, 0, 0);
        return count;
    }

    private void calculate(int[] nums, int target, int sum, int idx) {
        if (idx == nums.length) {
            if (target == sum) {
                count++;
            }
        } else {
            calculate(nums, target, sum - nums[idx], idx + 1);
            calculate(nums, target, sum + nums[idx], idx + 1);
        }
    }

    public int findTargetSumWaysDP(int[] nums, int S) {
        int total = Arrays.stream(nums).sum();
        int[][] dp = new int[nums.length][2 * total + 1];
        dp[0][nums[0] + total] = 1;
        dp[0][-nums[0] + total] += 1;

        for (int i = 1; i < nums.length; i++) {
            for (int sum = -total; sum <= total; sum++) {
                int position = sum + total;
                if (dp[i - 1][position] > 0) {
                    dp[i][position + nums[i]] += dp[i - 1][position];
                    dp[i][position - nums[i]] += dp[i - 1][position];
                }
            }
        }
        return Math.abs(S) > total ? 0 : dp[nums.length - 1][S + total];
    }
}
