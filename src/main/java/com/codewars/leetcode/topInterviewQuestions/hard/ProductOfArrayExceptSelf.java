package com.codewars.leetcode.topInterviewQuestions.hard;

import java.util.Arrays;

/*
 * Created by sgolitsyn on 8/25/20
 *
 Given an array nums of n integers where n > 1,
 return an array output such that output[i]
 is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Constraint: It's guaranteed that the product of the elements
of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity?
(The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        System.out.println(Arrays.toString(productOfArrayExceptSelf.productExceptSelf(new int[]{1, 2, 3, 4})));
//        System.out.println(Arrays.toString(productOfArrayExceptSelf.productExceptSelf(new int[]{9, 0, -2})));

    }

    public int[] productExceptSelf(int[] nums) {

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = 1;
        right[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = nums[i + 1] * right[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = left[i] * right[i];
        }

        return nums;
    }
}
