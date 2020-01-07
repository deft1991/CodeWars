package com.codewars.leetcode;

import java.util.Arrays;

/*
 * Created by sgolitsyn on 11/27/19
 *
Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */
public class RotateArray {
    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotateArray.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{-1, -100, 3, 99};
        rotateArray.rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        if (nums.length < 1) {
            return;
        }
        int swaps = 0;
        int cur;
        int next = nums[0];
        int nextIdx = 0;
        int even = 0;
        boolean isEven = k % 2 == 0;
        while (swaps < nums.length) {
            if (even == k) {
                nextIdx++;
                if (nextIdx >= nums.length - 1) {
                    nextIdx = nextIdx - nums.length;
                }
                next = nums[nextIdx];
            }

            cur = next;
            if (nextIdx >= nums.length - 1 || k + nextIdx > nums.length - 1) {
                nextIdx = nextIdx - nums.length;
            }
            next = nums[k + nextIdx];
            nums[k + nextIdx] = cur;
            nextIdx = k + nextIdx;
            swaps++;
            if (isEven) {
                even++;
            }

        }
    }
}
