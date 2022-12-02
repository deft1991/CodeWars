package com.codewars.leetcode.problems.medium;

/**
 * @author Sergey Golitsyn
 * created on 09.10.2022
 */
public class MaximumProductSubarray {

    public static void main(String[] args) {
        MaximumProductSubarray mp = new MaximumProductSubarray();
        System.out.println(mp.maxProduct(new int[]{1})); // 1
        System.out.println(mp.maxProduct(new int[]{2})); // 2
        System.out.println(mp.maxProduct(new int[]{2, 0})); // 2
        System.out.println(mp.maxProduct(new int[]{0, 3})); // 2
        System.out.println(mp.maxProduct(new int[]{1, 0, 3})); // 3
        System.out.println(mp.maxProduct(new int[]{-2, 0, -1})); // 0
        System.out.println(mp.maxProduct(new int[]{2, 3, -2, 4})); // 6
        System.out.println(mp.maxProduct(new int[]{-2, 3, -4})); // 24
    }

    public int maxProduct(int[] nums) {

        int[] max = new int[nums.length];
        int[] min = new int[nums.length];

        max[0] = nums[0];
        min[0] = nums[0];
        int result = nums[0];

        for(int i = 1; i < nums.length; i++){
            if (nums[i] > 0){
                max[i] = Math.max(nums[i], nums[i] * max[i-1]);
                min[i] = Math.min(nums[i], nums[i] * min[i-1]);
            } else {
                max[i] = Math.max(nums[i], nums[i] * min[i-1]);
                min[i] = Math.min(nums[i], nums[i] * max[i-1]);
            }
            result = Math.max(result, max[i]);
        }

        return max[nums.length-1];
    }
}
