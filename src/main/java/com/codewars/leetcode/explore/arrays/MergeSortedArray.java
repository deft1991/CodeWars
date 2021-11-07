package com.codewars.leetcode.explore.arrays;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 07.11.2021
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        MergeSortedArray msa = new MergeSortedArray();

        int[] nums1 = {4, 5, 6, 0, 0, 0};
        msa.merge(nums1, 3, new int[]{1, 2, 3}, 3);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int aReader = m - 1;
        int bReader = n - 1;
        int writer = n + m - 1;

        while (aReader >= 0 && bReader >= 0) {
            if (nums1[aReader] > nums2[bReader]) {
                nums1[writer--] = nums1[aReader];
                nums1[aReader--] = 0;
            } else {
                nums1[writer--] = nums2[bReader--];
            }
        }
        while (aReader >= 0) {
            nums1[writer--] = nums1[aReader--];
        }
        while (bReader >= 0) {
            nums1[writer--] = nums2[bReader--];
        }
    }
}
