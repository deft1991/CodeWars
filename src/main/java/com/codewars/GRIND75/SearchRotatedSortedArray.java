package com.codewars.GRIND75;

/**
 * @author Sergey Golitsyn
 * created on 18.09.2023
 */
public class SearchRotatedSortedArray {

    public static void main(String[] args) {
        SearchRotatedSortedArray s = new SearchRotatedSortedArray();
        System.out.println(s.search(new int[] {4,5,6,7,0,1,2}, 0)); // 4
        System.out.println(s.search(new int[] {4,5,6,7,0,1,2}, 3)); // -1
        System.out.println(s.search(new int[] {1}, 0)); // -1
        System.out.println(s.search(new int[] {1}, 1)); // 0
    }

    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        // 12345
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // sorted
            if (nums[start] < nums[mid]) {
                if (target < nums[start] || target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
                // 4 5 1 2 3
            } else { // unsorted
                if (target > nums[end] || target > nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
