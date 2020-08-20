package com.codewars.leetcode.topInterviewQuestions.medium;

/*
 * Created by sgolitsyn on 8/18/20
 */
public class IncreasingTripletSubsequence {

    public static void main(String[] args) {

        IncreasingTripletSubsequence increasing = new IncreasingTripletSubsequence();
//        System.out.println(increasing.increasingTriplet(new int[]{1, 2, 3, 4, 5})); // true
        System.out.println(increasing.increasingTriplet(new int[]{5, 4, 3, 2, 1})); // false
        System.out.println(increasing.increasingTriplet(new int[]{5, 1, 5, 5, 2, 5, 4})); // true
        System.out.println(increasing.increasingTriplet(new int[]{1, 0, 0, 0, 10, 0, 0, 0, 0, 10000})); // true
    }

    public boolean increasingTriplet(int[] nums) {

        if (nums.length < 3) {
            return false;
        }

        int b = Integer.MAX_VALUE;
        int c = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= b) {
                b = num;
            } else if (num <= c) {
                c = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
