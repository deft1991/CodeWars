package com.codewars.leetcode.topInterviewQuestions.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Created by sgolitsyn on 8/13/20
 *
 * Given an array nums of n integers, are there elements a, b, c in nums
 * such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
//        threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        threeSum.threeSum(new int[]{0, 0, 0, 0});
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> rez = new ArrayList<>();

        Arrays.sort(nums); // - 4 -1 -1 0 1 2
        for (int i = 0; i < nums.length - 2; i++) {

            while ((i > 0 && nums[i - 1] == nums[i]) && i < nums.length - 1) {
                i++;
            }

            int a = i;
            int b = i + 1;
            int c = nums.length - 1;

            while (b < c) {
                if (nums[a] + nums[b] + nums[c] == 0) {
                    rez.add(Arrays.asList(nums[a], nums[b], nums[c]));

                    b++;
                    while (nums[b - 1] == nums[b] && b < nums.length - 1) {
                        b++;
                    }
                    c--;
                    while ((c < nums.length - 2 && nums[c + 1] == nums[c])) {
                        c--;
                    }
                    continue;
                }

                if (nums[a] + nums[b] + nums[c] > 0) {
                    c--;
                } else {
                    b++;
                }
            }
        }
        return rez;
    }
}
