package com.codewars.leetcode.explore.arrays;

/**
 * @author Sergey Golitsyn
 * created on 15.11.2021
 */
public class MoveZeroes {

    public static void main(String[] args) {

    }

    public void moveZeroes(int[] arr) {
        int lastZeroIdx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int tmp = arr[lastZeroIdx];
                arr[lastZeroIdx++] = arr[i];
                arr[i] = tmp;
            }
        }
    }
}
