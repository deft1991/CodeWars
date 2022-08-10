package com.codewars.leetcode.problems.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 24.11.2021
 *
 * You are given a sorted unique integer array nums.
 *
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
 *
 * Each range [a,b] in the list should be output as:
 *
 * "a->b" if a != b
 * "a" if a == b
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: The ranges are:
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * Example 2:
 *
 * Input: nums = [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: The ranges are:
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * Example 3:
 *
 * Input: nums = []
 * Output: []
 * Example 4:
 *
 * Input: nums = [-1]
 * Output: ["-1"]
 * Example 5:
 *
 * Input: nums = [0]
 * Output: ["0"]
 */
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0){
            return new ArrayList();
        }

        List<String> rez = new ArrayList<>();
        if (nums.length == 1){
            rez.add(String.valueOf(nums[0]));
            return rez;
        }

        int start = nums[0];
        int cur = nums[0];
        int prev = nums[0];

        for (int i = 1; i < nums.length; i++) {
            cur = nums[i];
            if (cur - 1 != prev){

                if (start != prev){
                    rez.add(start+ "->" + prev);
                } else {
                    rez.add(String.valueOf(start));
                }

                start = cur;
                prev = cur;

            } else {
                prev = cur;
            }
        }

        if (start != prev){
            rez.add(start+ "->" + prev);
        } else {
            rez.add(String.valueOf(start));
        }

        return rez;
    }
}
