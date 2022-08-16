package com.codewars.leetcode.problems.easy;

/**
 * @author Sergey Golitsyn
 * created on 12.08.2022
 */
public class BinarySearch {

    public static void main(String[] args) {
//        System.out.println(search(new int[]{1,2,3}, 2)); // 1
//        System.out.println(search(new int[]{1,2,3,4,5}, 3)); // 2
//        System.out.println(search(new int[]{1,2,3,4,5}, 5)); // 4
//        System.out.println(search(new int[]{1,2}, 1)); // 0
//        System.out.println(search(new int[]{1,2}, 2)); // 1
//        System.out.println(search(new int[]{2,5}, 5)); // 1
        System.out.println(search(new int[]{-1,0,5}, 5)); // 2
    }

    public static int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            return nums[0] == target ? 0 : -1;
        }

        int start =  0;
        int end = nums.length - 1;

        while (start <= end){
            int mid = start + (end-start)/2;

            if(nums[mid] == target){
                return mid;
            }
            if (nums[mid] < target){
                start = mid + 1;
                continue;
            }
            if(nums[mid] > target){
                end = mid - 1;
            }
        }
        return -1;
    }
}
