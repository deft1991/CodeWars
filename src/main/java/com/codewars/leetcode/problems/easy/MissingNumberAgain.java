package com.codewars.leetcode.problems.easy;

/**
 * @author Sergey Golitsyn
 * created on 07.08.2022
 */
public class MissingNumberAgain {

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{9,6,4,2,3,5,7,0,1})); // 8
        System.out.println(missingNumber(new int[]{3,0,1})); // 2
        System.out.println(missingNumber(new int[]{0,1})); // 2
    }

    public static int missingNumber(int[] nums) {
        int rez = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (i + 1);
            rez += nums[i];
        }
        return sum - rez;
    }

}
