package com.codewars.leetcode.problems.easy;

/**
 * @author Sergey Golitsyn
 * created on 23.02.2021
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        MaximumSubarray ms = new MaximumSubarray();
        System.out.println(ms.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currSum = 0;

        for (int num : nums) {
            if (currSum < 0) {
                currSum = 0;
            }
            currSum += num;

            max = Math.max(max, currSum);
        }
        return max;
    }
}
