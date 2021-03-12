package com.codewars.leetcode.problems.medium;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 10.03.2021
 */
public class SortArrayHeap {

    public static void main(String[] args) {
        SortArrayHeap sa = new SortArrayHeap();
        System.out.println(Arrays.toString(sa.sortArray(new int[]{5, 2, 3, 1})));
        System.out.println(Arrays.toString(sa.sortArray(new int[]{1,2,3,4,5})));
        System.out.println(Arrays.toString(sa.sortArray(new int[]{1,3,5,4,2})));
        System.out.println(Arrays.toString(sa.sortArray(new int[]{5,1,1,2,0,0})));
        System.out.println(Arrays.toString(sa.sortArray(new int[]{642814604, -337297128, 1602524879, 361581667, 438765226, 145466599, -2051999160, -630028733, 1871074055, -507507233, -687947359, -2023142031, 1157845102, -705031775, 782124449, -541338565, 1967236326, 1996546954})));
        System.out.println(Arrays.toString(sa.sortArray(new int[]{20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1})));
    }

    public int[] sortArray(int[] nums) {
        int N = nums.length;

        for (int i = N / 2; i >= 0; i--) {
            sink(nums, i, N - 1);
        }

        while (N > 0) {
            sink(nums, 0, --N);
            exch(nums, 0, N);
        }
        return nums;
    }

    private void exch(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    private void sink(int[] nums, int idx, int N) {
        while (idx != N && idx * 2 + 1 <= N) {
            int left = idx * 2 + 1;
            int right = idx * 2 + 2;
            while (left < N && less(nums, left, right)) {
                left++;
            }

            if (!less(nums, idx, left)) {
                break;
            }
            exch(nums, idx, left);
            idx = left;
        }
    }

    private boolean less(int[] nums, int a, int b) {
        return nums[a] < nums[b];
    }
}
