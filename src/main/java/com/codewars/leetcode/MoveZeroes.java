package com.codewars.leetcode;

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

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] == 0) {
                    if (nums[j] != 0) {
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                        break;
                    }
                } else
                    break;
            }
        }
    }
}
