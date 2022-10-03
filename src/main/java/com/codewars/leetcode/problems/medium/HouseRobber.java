package com.codewars.leetcode.problems.medium;

/**
 * @author Sergey Golitsyn
 * created on 02.10.2022
 */
public class HouseRobber {

    public static void main(String[] args) {
        HouseRobber hr = new HouseRobber();
        System.out.println( hr.rob(new  int[]{1})); // 1
        System.out.println( hr.rob(new  int[]{1,2})); // 2
        System.out.println( hr.rob(new  int[]{1,2,3})); // 4
        System.out.println( hr.rob(new  int[]{1,2,3,4}));// 6
    }

    public int rob(int[] nums) {
        if (nums == null){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int[] rob = new int[nums.length];
        rob[0] = nums[0];
        rob[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++){
            int curAndPrev = nums[i] + rob[i-2];
            rob[i] = Math.max(curAndPrev, rob[i-1]);
        }
        return rob[rob.length-1];
    }
}
