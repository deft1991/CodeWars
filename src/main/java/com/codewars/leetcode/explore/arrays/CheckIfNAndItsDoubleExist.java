package com.codewars.leetcode.explore.arrays;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 12.11.2021
 */
public class CheckIfNAndItsDoubleExist {

    public static void main(String[] args) {
        CheckIfNAndItsDoubleExist c = new CheckIfNAndItsDoubleExist();

        System.out.println(c.checkIfExist(new int[] {10,2,5,3})); // true
        System.out.println(c.checkIfExist(new int[] {7,1,14,11}));// true
        System.out.println(c.checkIfExist(new int[] {3,1,7,11})); // false
        System.out.println(c.checkIfExist(new int[] {-10,12,-20,-8,15})); // true
        System.out.println(c.checkIfExist(new int[]{-2, 0, 10, -19, 4, 6, -8})); // false
    }

    public boolean checkIfExist(int[] arr) {
        if (arr.length < 2) {
            return false;
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            boolean isExist = binarySearch(arr, 0, arr.length - 1, i);

            if (isExist) {
                return true;
            }
        }
        return false;
    }


    private boolean binarySearch(int[] arr, int start, int end, int curIdx) {
        int val = arr[curIdx] * 2;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == val && mid != curIdx) {
                return true;
            } else if (arr[mid] > val) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return false;
    }
}
