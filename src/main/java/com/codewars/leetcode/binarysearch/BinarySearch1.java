package com.codewars.leetcode.binarysearch;

/*
 * Created by sgolitsyn on 1/25/20
 */
public class BinarySearch1 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 9));
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 2));
    }

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                return mid;
            }
            if (nums[mid] > target){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
