package com.codewars.leetcode.problems.easy;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 23.02.2021
 */
public class MajorityElement {

    public static void main(String[] args) {
        MajorityElement me = new MajorityElement();
        System.out.println(me.majorityElement(new int[]{2,2}));
        System.out.println(me.majorityElement(new int[]{3,2,3}));
        System.out.println(me.majorityElement(new int[]{2,2,1,1,1,2,2}));
    }

    public int majorityElement(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int majorityEl = nums.length / 2;

        // sort array
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i; j > 0 && isLess(nums[j], nums[j - 1]); j--) {
//                swap(nums, j, j-1);
//            }
//        }
        Arrays.sort(nums);

        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] == nums[i]){
                count ++;
            } else {
                count = 1;
            }
            if (count > majorityEl){
                return nums[i];
            }
        }
        return 0;
    }

    private void swap(int[] nums, int idxA, int idxB) {
        int tmp = nums[idxA];
        nums[idxA] = nums[idxB];
        nums[idxB] = tmp;
    }

    private boolean isLess(int num, int num1) {
        return num < num1;
    }
}
