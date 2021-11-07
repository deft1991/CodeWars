package com.codewars.leetcode.problems.medium;

/**
 * @author Sergey Golitsyn
 * created on 24.02.2021
 * <p>
 * Find the kth largest element in an unsorted array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 * <p>
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class KthLargestElementInAnArrayMergeSort {

    public static void main(String[] args) {
        KthLargestElementInAnArrayMergeSort kl = new KthLargestElementInAnArrayMergeSort();
        System.out.println(kl.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        mergeSort(nums);
        return nums[k - 1];
    }

    private void mergeSort(int[] nums) {
        int[] aux = new int[nums.length];

        sort(nums, aux, 0, nums.length - 1);

    }

    private void sort(int[] nums, int[] aux, int lo, int hi) {
        if (lo >= hi){
            return;
        }

        int mid = lo + (hi - lo) / 2;

        sort(nums, aux, lo, mid);
        sort(nums, aux, mid + 1, hi);
        merge(nums, aux, lo, mid, hi);

    }

    private void merge(int[] nums, int[] aux, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++){
            aux[i] = nums[i];
        }

        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++){
            if (i > mid) {
                nums[k] = aux[j++];
            } else if (j > hi){
                nums[k] = aux[i++];
            } else if (aux[i] > aux[j]){
                nums[k] = aux[j++];
            } else {
                nums[k] = aux[i++];
            }
        }
    }
}
