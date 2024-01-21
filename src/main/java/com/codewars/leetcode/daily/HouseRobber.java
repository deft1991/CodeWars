package com.codewars.leetcode.daily;

/**
 * @author Sergey Golitsyn
 * created on 21.01.2024
 */
public class HouseRobber {

    public static void main(String[] args) {
        HouseRobber h = new HouseRobber();
        System.out.println(h.rob(new int[]{1,2,3,1}));
        System.out.println(h.rob(new int[]{2,7,9,3,1}));
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = nums[1];

        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }

        return dp[dp.length - 1];
    }
}
