package com.codewars.facebook;

/**
 * @author Sergey Golitsyn
 * created on 15.08.2023
 */
public class TargetSum {

    public static void main(String[] args) {
        TargetSum t = new TargetSum();
        t.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(rez);
    }

    private static int rez = 0;

    public int findTargetSumWays(int[] nums, int target) {
        rez = 0;
        backtrack(nums, 0, target, 0);
        return rez;
    }

    private void backtrack(int[] nums, int sum, int target, int idx) {
        if (idx == nums.length) {
            if (sum == target) {
                rez++;
            }
        } else {
            backtrack(nums, sum + nums[idx], target, idx + 1);
            backtrack(nums, sum - nums[idx], target, idx + 1);
        }
    }
}
