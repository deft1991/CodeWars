package com.codewars.leetcode.problems.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 21.10.2022
 */
public class FindAllNumbersDisappearedArray {

    public static void main(String[] args) {
        FindAllNumbersDisappearedArray fa = new FindAllNumbersDisappearedArray();
        System.out.println(fa.findDisappearedNumbers(new int[]{2, 1, 1}));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
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

    private static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
