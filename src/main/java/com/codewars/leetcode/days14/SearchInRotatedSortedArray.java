package com.codewars.leetcode.days14;

/**
 * @author Sergey Golitsyn
 * created on 01.03.2022
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();

        System.out.println(s.search(new int[]{1, 3}, 3)); // 1
        System.out.println(s.search(new int[]{4,5,6,7,0,1,2}, 0)); // 4
        System.out.println(s.search(new int[]{4,5,6,7,0,1,2}, 3)); // -1
        System.out.println(s.search(new int[]{1}, 3)); // -1
        System.out.println(s.search(new int[]{1,2,3,4,5}, 3)); // 2
        System.out.println(s.search(new int[]{1,2,3,4,5}, 5)); // 4
        System.out.println(s.search(new int[]{4,5, 1,2,3}, 5)); // 1
        System.out.println(s.search(new int[]{4,5, 1,2,3}, 1)); // 2
        System.out.println(s.search(new int[]{4,5, 1,2,3}, 2)); // 3
        System.out.println(s.search(new int[]{4,5,6,7,8,1,2,3}, 8)); // 4
        System.out.println(s.search(new int[]{5,1,2,3,4}, 1)); // 1
    }

    public int search(int[] nums, int target) {

        return binarySearch(nums, 0, nums.length - 1, target);

    }

    private int binarySearch(int[] nums, int start, int end, int target) {

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            } else {
                if (nums[mid] >= target) {
                    if (nums[start] > target) {
                        start = start + 1;
                    } else {
                        end = mid - 1;
                    }
                } else { // nums[mid] < target
                    if (nums[end] >= target) {
                        start = mid + 1;
                    } else {
                        end = end - 1;
                    }
                }
            }
        }
        return -1;
    }
}
