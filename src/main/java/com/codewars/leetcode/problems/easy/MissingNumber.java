package com.codewars.leetcode.problems.easy;

/**
 * @author Sergey Golitsyn
 * created on 02.06.2021
 */
public class MissingNumber {

    public static void main(String[] args) {
        MissingNumber mn = new MissingNumber();
        System.out.println(mn.missingNumber(new int[] {3,0,1}));
    }

    public int missingNumber(int[] nums) {
        int realSum = 0;
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        for (int i = 0; i <= nums.length; i++) {
            realSum += i;
        }
        return realSum - sum;
    }
}
