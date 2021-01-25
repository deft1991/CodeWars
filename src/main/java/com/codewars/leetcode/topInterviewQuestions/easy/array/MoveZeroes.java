package com.codewars.leetcode.topInterviewQuestions.easy.array;

/**
 * @author Sergey Golitsyn
 * created on 22.01.2021
 * <p>
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 * <p>
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZeroes {

    public static void main(String[] args) {
        moveZeroes(new int[] {0,1,0,3,12});
    }

    public static void moveZeroes(int[] nums) {

        int writer = 0;
        int reader = 1;

        while (reader < nums.length) {
            if (nums[writer] != 0) {
                writer++;
                reader++;
                continue;
            }
            if (nums[writer] == 0 && nums[reader] != 0) {
                nums[writer] = nums[reader];
                nums[reader] = 0;
                writer++;
            }
            reader++;
        }
    }
}
