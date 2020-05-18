package com.codewars.leetcode.array;


import java.util.Arrays;

/*
 * Created by sgolitsyn on 5/18/20
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        mergeSortedArray.merge(nums1, 3, nums2, 3);

        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int count = m + n - 1;
        --m;
        --n;

        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[count--] = nums1[m--];
            } else {
                nums1[count--] = nums2[n--];
            }
        }

        while (n >= 0){
            nums1[count--] = nums2[n--];
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        // using 3 pointers
        int pointer = m + n - 1; // keeps track of our final array where elements would be inserted
        int i = m - 1; // starts at the end of nums1 arr
        int j = n - 1; //starts at the end of nums2 arr

        while(i >=0 && j >=0) {
            if(nums1[i] <= nums2[j]) {
                nums1[pointer] = nums2[j];
                pointer--;
                j--;
            } else {
                nums1[pointer] = nums1[i];
                pointer--; // decrement final arr position
                i--; //decrease nums1 position
            }
        }

        while (j >= 0) { // once one arr is done, combine the rest in final arr
            nums1[pointer] = nums2[j];
            pointer--;
            j--;
        }
    }
}
