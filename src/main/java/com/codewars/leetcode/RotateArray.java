package com.codewars.leetcode;

import java.util.Arrays;

/*
 * Created by sgolitsyn on 11/27/19
 *
Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */
public class RotateArray {
    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
//        int[] nums = {1, 2, 3, 4, 5, 6, 7};
//        rotateArray.rotate(nums, 3);
//        System.out.println(Arrays.toString(nums));
//        nums = new int[]{-1, -100, 3, 99};
//        rotateArray.rotate(nums, 2);
//        System.out.println(Arrays.toString(nums));
        int[] nums = {1, 2};
        rotateArray.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        if (k != 0 && nums.length > 1){
            int [] arr = new int[nums.length];

            for (int i = 0; i < nums.length; i ++){
                int alligment = 0;
                if (i + k > nums.length - 1) {
                    alligment = (i + k)- nums.length;
                    while (alligment > nums.length - 1){
                        alligment -= nums.length;
                    }
                } else {
                    alligment = i + k;
                }
                arr[alligment] = nums[i];
            }
            System.arraycopy(arr, 0, nums, 0, nums.length);
        }
    }
}
