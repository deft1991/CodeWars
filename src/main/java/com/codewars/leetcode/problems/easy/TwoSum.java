package com.codewars.leetcode.problems.easy;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 15.08.2022
 */
public class TwoSum {

    public static void main(String[] args) {
//        System.out.println(twoSum(new int[]{3,2,4}, 6));
//        System.out.println(twoSum(new int[]{3,3}, 6));
        System.out.println(twoSum(new int[]{2,5,5, 11}, 10));
    }

    public static int[] twoSum(int[] nums, int target) {

        int[] nums2 = Arrays.copyOf(nums, nums.length);

        int start = 0;
        int end = nums.length - 1;

        Arrays.sort(nums);
        int[] tmpRez = new int[2];
        while(start < end){
            if(nums[start] + nums[end] == target){
                tmpRez[0] = nums[start];
                tmpRez[1] = nums[end];
                break;
            }  else if (nums[start] + nums[end] < target){
                start++;
            } else {
                end --;
            }
        }
        int lo = tmpRez[0];
        int hi = tmpRez[1];
        int[] rez = new int[2];

        for(int i = 0; i < nums.length; i++){
            if(lo == nums2[i]){
                rez[0] = i;
                break;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(hi == nums2[i] && rez[0] != i){
                rez[1] = i;
               break;
            }
        }
        return rez;
    }
}
