package com.codewars.leetcode.problems.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 09.08.2022
 */
public class NumbersDisappearedArray {

    public static void main(String[] args) {
//        System.out.println(findDisappearedNumbers(new int[]{1, 1}));
        System.out.println(findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }

    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> rez = new ArrayList<>();

        int reader = 0;

        while (reader < nums.length) {
            if (nums[reader] != nums[nums[reader] - 1]) {
                swap(nums, reader, nums[reader] - 1);
            } else {
                reader++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i] - 1) {
                rez.add(i + 1);
            }
        }
        return rez;
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> rez = new ArrayList<>();

        for(int i = 0; i < nums.length; i ++){
            int idx = Math.abs(nums[i])- 1;

            if (nums[idx] > 0){
                nums[idx] = - nums[idx];
            }
        }

        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0){
                rez.add(i+1);
            }
        }

        return rez;
    }

    private static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
