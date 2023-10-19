package com.codewars.facebook;

/**
 * @author Sergey Golitsyn
 * created on 20.08.2023
 */
public class FindMinimumRotatedSortedArray {

    public static void main(String[] args) {
        FindMinimumRotatedSortedArray f = new FindMinimumRotatedSortedArray();
        System.out.println(f.findMin(new int[]{3, 4, 5, 1, 2})); // 1
        System.out.println(f.findMin(new int[]{4, 5, 6, 7, 0, 1, 2})); // 0
        System.out.println(f.findMin(new int[]{11, 13, 15, 17})); // 11
    }

    /*
    1,2,3,4,5
        ^
     5 6 7 1 2 3 4
         ^
     */
    public int findMin(int[] nums) {

        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            // sorted
            if (nums[start] < nums[end]) {
                end = mid;
            } else { // unsorted nums[start] > nums[end]
                if (nums[mid] >= nums[start]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
        }

        return nums[start];
    }
}
