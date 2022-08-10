package com.codewars.leetcode.explore.arrays;

/**
 * @author Sergey Golitsyn
 * created on 16.11.2021
 */
public class SortArrayByParity {

    public static void main(String[] args) {

    }

    public int[] sortArrayByParity(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            if (arr[start] % 2 != 0 && arr[end] % 2 == 0){
                swap(arr, start, end);
                start ++;
                end --;
            } else if (arr[start] % 2 == 0){
                start ++;
            } else {
                end --;
            }
        }
        return arr;
    }

    private void swap(int[] arr, int aIdx, int bIdx){
        int tmp = arr[aIdx];
        arr[aIdx] = arr[bIdx];
        arr[bIdx] = tmp;
    }
}
