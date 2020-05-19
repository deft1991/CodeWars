package com.codewars.leetcode.array;

import java.util.Arrays;

/*
 * Created by sgolitsyn on 1/11/20
 *
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 */
public class MoveZeroes {
    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();

        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {

        int lastNonZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[lastNonZero];
                nums[lastNonZero++] = nums[i];
                nums[i] = tmp;
            }
        }
    }
}
