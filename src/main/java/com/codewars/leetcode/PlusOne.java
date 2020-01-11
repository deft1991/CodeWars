package com.codewars.leetcode;

import java.util.Arrays;

/*
 * Created by sgolitsyn on 1/10/20
 *
 *
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.

Input: [9, 9]
Output: [1,0,0]
Explanation: The array represents the integer 4321.
 */
public class PlusOne {
    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        System.out.println(Arrays.toString(plusOne.plusOne(new int[]{9, 9})));
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9){
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] ints = new int[digits.length + 1];
        ints[0] = 1;
        System.arraycopy(digits, 0, ints, 1, digits.length);
        return ints;
    }
}
