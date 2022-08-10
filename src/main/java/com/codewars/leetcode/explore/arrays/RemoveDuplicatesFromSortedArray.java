package com.codewars.leetcode.explore.arrays;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 08.11.2021
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray r = new RemoveDuplicatesFromSortedArray();

        int[] arr = new int[] {1,1,2};
        r.removeDuplicates(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[] {1,1,2,2,3,3};
        r.removeDuplicates(arr);
        System.out.println(Arrays.toString(arr));
    }

    public int removeDuplicates(int[] nums) {

        int reader = 0;
        int writer = 1;

        if(nums.length == 1){
            return 1;
        }

        while (writer < nums.length){
            if (nums[reader] == nums[writer]){
                writer ++;
            } else {
                nums[++reader] = nums[writer++];
            }
        }
        return reader + 1;
    }
}
