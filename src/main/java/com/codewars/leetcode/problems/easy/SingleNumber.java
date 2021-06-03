package com.codewars.leetcode.problems.easy;

/**
 * @author Sergey Golitsyn
 * created on 02.06.2021
 */
public class SingleNumber {

    public static void main(String[] args) {
        SingleNumber sn = new SingleNumber();
//        System.out.println(sn.singleNumber(new int[]{1}));
        System.out.println(sn.singleNumber(new int[]{1,2,2}));
    }

    public int singleNumber(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int rez = nums[0];
        for (int i = 1; i < nums.length; i++) {
            rez ^= nums[i];
        }
        return rez;
    }
}
