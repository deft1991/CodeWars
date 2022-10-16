package com.codewars.leetcode.problems.medium;

/**
 * @author Sergey Golitsyn
 * created on 04.10.2022
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        MaximumSubarray ms = new MaximumSubarray();

        System.out.println(ms.maxSubArray(new int[]{1,2,3})); // 6
        System.out.println(ms.maxSubArray(new int[]{1,2, -3})); // 3
        System.out.println(ms.maxSubArray(new int[]{1,-2, 3})); // 3
        System.out.println(ms.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4})); // 6
        System.out.println(ms.maxSubArray(new int[]{5,4,-1,7,8})); // 6
    }

    public int maxSubArray(int[] nums) {
        if(nums == null){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }

        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int num : nums) {
            cur += num;
            if (cur <= 0) {
                cur = 0;
            }
            max = Math.max(max, cur);
        }
        return max;
    }
}
