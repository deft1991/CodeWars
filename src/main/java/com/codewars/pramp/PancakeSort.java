package com.codewars.pramp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sergey Golitsyn
 * created on 26.01.2023
 */
public class PancakeSort {

    public static void main(String[] args) {
        PancakeSort p = new PancakeSort();
        System.out.println(Arrays.toString(PancakeSort.pancakeSortInner(new int[]{1, 5, 4, 3, 2})));
        System.out.println(Arrays.toString(p.pancakeSort(new int[]{1, 5, 4, 3, 2}).toArray()));
    }

    public List<Integer> pancakeSort(int[] arr) {

        return Arrays.stream(pancakeSortInner(arr))
                .boxed()
                .collect(Collectors.toList());
    }

    static int[] pancakeSortInner(int[] arr) {

        for (int i = arr.length - 1; i >= 0; i--) {
            int maxElIdx = findMaxElIdx(arr, i);
            flip(arr, maxElIdx); // set max el to start
            flip(arr, i); // set max el to end
        }
        return arr;
    }

    private static int findMaxElIdx(int[] arr, int length) {
        int maxIdx = 0;

        for (int i = 0; i <= length; i++) {
            if (arr[i] > arr[maxIdx]) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    static void flip(int[] arr, int k) {
        int i = 0;
        while (i < k) {
            int tmp = arr[i];
            arr[i] = arr[k];
            arr[k] = tmp;
            i++;
            k--;
        }
    }

}
