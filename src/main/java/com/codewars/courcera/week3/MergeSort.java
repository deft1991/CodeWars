package com.codewars.courcera.week3;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 01.03.2021
 */
public class MergeSort {

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ms.sort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        ms.sort(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {1, 2, 4, 3, 5, 6, 8, 7, 0, 9};
        ms.sort(arr3);
        System.out.println(Arrays.toString(arr3));


    }

    public void sort(int[] arr) {
        int n = arr.length;

        int[] aux = new int[n];

        sort(arr, aux, 0, n - 1);
    }

    private void sort(int[] arr, int[] aux, int lo, int hi) {

        if (lo >= hi) {
            return;
        }

        int mid = lo + (hi - lo) / 2;

        sort(arr, aux, lo, mid);
        sort(arr, aux, mid + 1, hi);
        merge(arr, aux, lo, mid, hi);
    }

    private void merge(int[] arr, int[] aux, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            aux[i] = arr[i];
        }

        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                arr[k] = aux[j++];
            } else if (j > hi) {
                arr[k] = aux[i++];
            } else if (aux[i] < aux[j]) {
                arr[k] = aux[i++];
            } else {
                arr[k] = aux[j++];
            }
        }
    }
}
