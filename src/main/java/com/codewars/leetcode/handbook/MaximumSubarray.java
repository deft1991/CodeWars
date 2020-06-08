package com.codewars.leetcode.handbook;

/*
 * Created by sgolitsyn on 6/8/20
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        int tmpSum = 0;
        for(int i = 0; i < nums.length; i++) {
            tmpSum += nums[i];

            if (tmpSum > maxSum){
                maxSum = tmpSum;
            }
            if (tmpSum <= 0){
                tmpSum = 0;
            }
        }
        return maxSum;
    }
}
