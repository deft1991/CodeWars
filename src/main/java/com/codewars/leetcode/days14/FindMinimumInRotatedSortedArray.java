package com.codewars.leetcode.days14;

/**
 * @author Sergey Golitsyn
 * created on 03.03.2022
 */
public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray f = new FindMinimumInRotatedSortedArray();

        System.out.println(f.findMin(new int[]{3, 4, 5, 1, 2})); // 1
        System.out.println(f.findMin(new int[]{4, 5, 6, 7, 0, 1, 2})); // 0
        System.out.println(f.findMin(new int[]{1})); // 1
        System.out.println(f.findMin(new int[]{11, 13, 15, 17})); // 11
        System.out.println(f.findMin(new int[]{1, 2, 3, 4, 5, 6})); // 1
        System.out.println(f.findMin(new int[]{2, 1})); // 1
        System.out.println(f.findMin(new int[]{3, 4, 5, 6, 1, 2})); // 1
    }

    public int findMin(int[] nums) {

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

}
