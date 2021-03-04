package com.codewars.courcera.week3;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 01.03.2021
 */
public class QuickSort {

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        qs.sort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        qs.sort(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {1, 2, 4, 3, 5, 6, 8, 7, 0, 9};
        qs.sort(arr3);
        System.out.println(Arrays.toString(arr3));
    }

    public void sort(int[] arr) {
        // todo shuffle array

        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int pivot = pivot(arr, lo, hi);

        sort(arr, lo, pivot - 1);
        sort(arr, pivot + 1, hi);
    }

    private int pivot(int[] arr, int lo, int hi) {

        int i = lo + 1;
        int j = hi;

        while (true) {

            while (arr[i] < arr[lo]) {
                if (i >= hi) {
                    break;
                }
                i++;

            }

            while (arr[j] > arr[lo]) {
                if (j <= lo) {
                    break;
                }
                j--;
            }

            if (i >= j){
                break;
            }

            exchange(arr, i, j);
        }

        exchange(arr, lo, j);
        return j;
    }

    private void exchange(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
