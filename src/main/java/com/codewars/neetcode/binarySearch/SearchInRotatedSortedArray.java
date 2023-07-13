package com.codewars.neetcode.binarySearch;

/**
 * @author Sergey Golitsyn
 * created on 30.12.2022
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0)); // 4
        System.out.println(s.search(new int[]{4,5,6,7,0,1,2}, 3)); // -1
        System.out.println(s.search(new int[]{1}, 0)); // -1
        System.out.println(s.search(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8)); // 4
        System.out.println(s.search(new int[]{1,3}, 3)); // 1
        System.out.println(s.search(new int[]{5, 1, 3}, 3)); // 2
    }

    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            if (nums[start] <= nums[mid]) { // sorted
                if (target < nums[start] || target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (target > nums[end] || target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
