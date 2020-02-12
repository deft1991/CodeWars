package com.codewars.leetcode.binarysearch;

/*
 * Created by sgolitsyn on 2/12/20
 */
public class FindMinimumRotatedSortedArray {

    public static int findMin(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[start] > nums[end]) {
                if (nums[mid] >= nums[start]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            } else {
                end = mid;
            }
        }
        return nums[start];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{2, 1}));
//        System.out.println(findMin(new int[]{1, 2}));
//        System.out.println(findMin(new int[]{1, 2, 3, 4}));
//        System.out.println(findMin(new int[]{1, 2, 3, 5, 6, 7}));
    }
}
