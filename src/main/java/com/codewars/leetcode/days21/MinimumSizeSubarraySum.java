package com.codewars.leetcode.days21;

/**
 * @author Sergey Golitsyn
 * created on 19.03.2022
 */
public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        MinimumSizeSubarraySum m = new MinimumSizeSubarraySum();
        System.out.println(m.minSubArrayLen(7, new int[] {2,3,1,2,4,3})); // 2
        System.out.println(m.minSubArrayLen(4, new int[] {1,4,4})); // 1
        System.out.println(m.minSubArrayLen(11, new int[] {1,1,1,1,1,1,1,1})); // 1
    }

    public int minSubArrayLen(int target, int[] nums) {

        int start = 0;
        int curSum = 0;
        int rez;
        int min = Integer.MAX_VALUE;
        for (int end = 0; end < nums.length; end++) {
            curSum += nums[end];

            while(curSum >= target && start < nums.length){
                rez = end - start;
                if (rez < min){
                    min = rez;
                }
                curSum -= nums[start];
                start ++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min + 1;
    }
}
