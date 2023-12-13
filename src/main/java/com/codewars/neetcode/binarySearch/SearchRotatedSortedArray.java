package com.codewars.neetcode.binarySearch;

/**
 * @author Sergey Golitsyn
 * created on 13.12.2023
 */
public class SearchRotatedSortedArray {

    public static void main(String[] args) {
        SearchRotatedSortedArray s = new SearchRotatedSortedArray();
        System.out.println(s.search(new int[]{4,5,6,7,0,1,2}, 0)); // 4
        System.out.println(s.search(new int[]{4,5,6,7,0,1,2}, 3)); // -1
        System.out.println(s.search(new int[]{1}, 1)); // 0
        System.out.println(s.search(new int[]{3,1}, 1)); // 1
        System.out.println(s.search(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8)); // 1
    }

    /**
     * [4,5,6,7,0,1,2], target = 0 rez = 4
     * [4,5,6,7,0,1,2], target = 3 rez = -1
     */
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[start] > nums[mid]) { // unsorted
                if (target > nums[end] || target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else { // sorted
                if (target > nums[mid] || target < nums[start]){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
