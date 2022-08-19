package com.codewars.leetcode.problems.easy;

/**
 * @author Sergey Golitsyn
 * created on 17.08.2022
 */
public class SquaresSortedArray {

    public static void main(String[] args) {
        System.out.println(sortedSquares(new int[]{-7,-3,2,3,11}));
    }

    public static int[] sortedSquares(int[] nums) {
        int[] rez = new int[nums.length];

        int start = 0;
        int end = nums.length - 1;
        int writer = nums.length - 1;
        while (start <= end){
            int st = nums[start] * nums[start];
            int en = nums[end] * nums[end];

            if(st >= en){
                rez[writer--] = st;
                start++;
            } else {
                rez[writer--] = en;
                end--;
            }
        }
        return rez;
    }
}
