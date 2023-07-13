package com.codewars.neetcode.binarySearch;

/**
 * @author Sergey Golitsyn
 * created on 03.01.2023
 */
public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray f = new FindMinimumInRotatedSortedArray();
        System.out.println(f.findMin(new int[]{3, 4, 5, 1, 2})); // 1
        System.out.println(f.findMin(new int[]{4,5,6,7,0,1,2})); // 0
        System.out.println(f.findMin(new int[]{11,13,15,17})); // 11
        System.out.println(f.findMin(new int[]{0,1,2,3,4,5})); // 0
        System.out.println(f.findMin(new int[]{2,1})); // 1
    }

    public int findMin(int[] nums) {

        int start = 0;
        int end = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            min = Math.min(min, nums[mid]);
            if (nums[start] < nums[mid]) { // sorted part
                if (nums[mid] > nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
                min = Math.min(min, nums[start]);
            } else {
                if (nums[mid] > nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return min;
    }
}
