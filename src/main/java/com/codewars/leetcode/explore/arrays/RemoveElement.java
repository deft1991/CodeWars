package com.codewars.leetcode.explore.arrays;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 08.11.2021
 */
public class RemoveElement {

    public static void main(String[] args) {
        RemoveElement re = new RemoveElement();

        int[] arr = new int[] {3,2,2,3};
//        re.removeElement(arr, 3);
//        System.out.println(Arrays.toString(arr));
//
//        arr = new int[] {2};
//        re.removeElement(arr, 3);
//        System.out.println(Arrays.toString(arr));
//
        arr = new int[] {3,3};
        re.removeElement(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    public int removeElement(int[] nums, int val) {

        int writer = nums.length - 1;
        int reader = 0;

        while (reader < writer) {
            if (nums[reader] == val) {
                nums[reader] = nums[writer--];
            } else {
                reader ++;
            }
        }
        return reader;
    }

    public int removeElement2(int[] nums, int val) {
        int writer = 0;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] != val){
                nums[writer++] = nums[i];
            }
        }
        return writer;
    }
}
