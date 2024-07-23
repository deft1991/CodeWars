package com.codewars.leetcode.daily;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 04.04.2024
 */
public class SelectionSort {

    public static void main(String[] args) {
        SelectionSort s = new SelectionSort();
        int[] arr = {5, 4, 3, 2, 1};
        s.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sort(int[] arr) {
        sort(arr, 0);
    }

    private void sort(int[] arr, int start) {
        for (int i = start; i < arr.length; i++) {
            int min = findMin(arr, i);
            swap(arr, i, min);
        }
    }

    private int findMin(int[] arr, int start){
        int min = start;
        for (int i = start + 1; i < arr.length; i++){
            if (arr[i] < arr[min]){
                min = i;
            }
        }
        return min;
    }

    private void swap(int arr[], int from, int to){
        int tmp = arr[from];
        arr[from] = arr[to];
        arr[to] = tmp;
    }
}
