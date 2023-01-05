package com.codewars.neetcode.binarySearch;

/**
 * @author Sergey Golitsyn
 * created on 27.12.2022
 */
public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch b = new BinarySearch();
        System.out.println(b.search(new int[]{1,2,3,4,5,6}, 1)); // 0
        System.out.println(b.search(new int[]{1,2,3,4,5,6}, 2)); // 1
        System.out.println(b.search(new int[]{1,2,3,4,5,6}, 6)); // 5
        System.out.println(b.search(new int[]{1,2,3,4,5,6}, -1)); // -1
        System.out.println(b.search(new int[]{-1,0,3,5,9,12}, 9)); // 4
        System.out.println(b.search(new int[]{-1,0,3,5,9,12}, 2)); // -1
    }

    public int search(int[] nums, int target) {
        return binarySearch2(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int start, int end) {
        if (end < start){
            return -1;
        }
        int mid = start + (end - start) / 2;

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return binarySearch(nums, target, start, mid - 1);
        } else {
            return binarySearch(nums, target, mid + 1, end);
        }
    }

    private int binarySearch2(int[] nums, int target, int start, int end) {
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
