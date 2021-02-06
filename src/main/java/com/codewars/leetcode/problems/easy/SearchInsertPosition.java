package com.codewars.leetcode.problems.easy;

/**
 * @author Sergey Golitsyn
 * created on 04.02.2021
 *
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * Example 1:
 *
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * Example 3:
 *
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 * Example 4:
 *
 * Input: nums = [1,3,5,6], target = 0
 * Output: 0
 * Example 5:
 *
 * Input: nums = [1], target = 0
 * Output: 0
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        SearchInsertPosition s = new SearchInsertPosition();

        System.out.println(s.searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(s.searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(s.searchInsert(new int[]{1,3,5,6}, 7));
        System.out.println(s.searchInsert(new int[]{1,3,5,6}, 0));
        System.out.println(s.searchInsert(new int[]{1}, 0));
        System.out.println(s.searchInsert(new int[]{1, 3}, 2));
        System.out.println(s.searchInsert(new int[]{3, 5, 7, 9, 10}, 8));

    }

    public int searchInsert(int[] nums, int target) {

        return searchInsert(nums, target, 0, nums.length - 1);
    }

    public int searchInsert(int[] nums, int target, int left, int right) {
        int middle = (right + left + 1) / 2;

        if (left > right){
            return left;
        }
        if (nums[middle] == target) {
            return middle;
        }
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        if (nums[0] > target) {
            return 0;
        } else {
            if (nums[middle] > target) {
                return searchInsert(nums, target, left, middle - 1);
            } else {
                return searchInsert(nums, target, middle + 1, right);
            }
        }
    }
}
