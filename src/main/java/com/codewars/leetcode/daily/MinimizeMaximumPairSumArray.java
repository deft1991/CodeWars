package com.codewars.leetcode.daily;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 17.11.2023
 */
public class MinimizeMaximumPairSumArray {

    public static void main(String[] args) {
        MinimizeMaximumPairSumArray m = new MinimizeMaximumPairSumArray();
        System.out.println(m.minPairSum(new int[]{3,5,2,3})); // 7
        System.out.println(m.minPairSum(new int[]{3,5,4,2,4,6})); // 8
    }

    public int minPairSum(int[] nums) {
        int rez = Integer.MIN_VALUE;
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n/2; i++){
            int sum = nums[i] + nums[n-1-i];
            rez = Math.max(rez, sum);
        }

        return rez;
    }
}
