package com.codewars.leetcode.explore.arrays;

/*
In a given integer array nums, there is always exactly one largest element.

Find whether the largest element in the array is at least twice as much as every other number in the array.

If it is, return the index of the largest element, otherwise return -1.

Example 1:

Input: nums = [3, 6, 1, 0]
Output: 1
Explanation: 6 is the largest integer, and for every other number in the array x,
6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.


Example 2:

Input: nums = [1, 2, 3, 4]
Output: -1
Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.
 * Created by sgolitsyn on 3/24/20
 */
public class LargestNumberAtLeastTwiceOfOthers {
    public static void main(String[] args) {
//        System.out.println(dominantIndex(new int[]{3, 6, 1, 0}));
//        System.out.println(dominantIndex(new int[]{1, 2, 3, 4}));
//        System.out.println(dominantIndex(new int[]{1, 0}));
        System.out.println(dominantIndex(new int[]{0, 0, 3, 2}));
    }

    public static int dominantIndex(int[] nums) {
        int largestIdx = 0;
        int prevLargeIdx = 0;

        if (nums.length == 1){
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[largestIdx]) {
                prevLargeIdx = largestIdx;
                largestIdx = i;
            } else if (nums[i] > nums[prevLargeIdx]){
                prevLargeIdx = i;
            } else if (prevLargeIdx == largestIdx){
                prevLargeIdx = i;
            }
        }

        if (nums[largestIdx] >= nums[prevLargeIdx] * 2) {
            return largestIdx;
        }
        return -1;
    }
}
