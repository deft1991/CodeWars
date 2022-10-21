package com.codewars.leetcode.problems.medium;

/**
 * @author Sergey Golitsyn
 * created on 04.10.2022
 */
public class HouseRobberII {

    public static void main(String[] args) {
        HouseRobberII hr = new HouseRobberII();
        System.out.println(hr.rob(new int[]{2,3,2})); // 3
        System.out.println(hr.rob(new int[]{1,2,3,1})); // 4
        System.out.println(hr.rob(new int[]{1,2,3})); // 3
    }

    public int rob(int[] nums) {
        int startRob = rob(nums, 0, nums.length-2);
        int endRob = rob(nums, 1, nums.length -1);
        return Math.max(startRob, endRob);
    }

    public int rob(int[] nums, int lo, int hi){
        int include = 0;
        int exclude = 0;

        for(int i = lo; i <= hi; i++){
            int inc = include;
            int ex = exclude;
            include = nums[i] + ex; // current + step step ago
            exclude = Math.max(inc, ex); // max for prev step
        }
        return Math.max(include, exclude);
    }
}
