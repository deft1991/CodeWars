package com.codewars.leetcode.explore.arrays;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 07.11.2021
 */
public class DuplicateZeros {

    public static void main(String[] args) {
        DuplicateZeros dz = new DuplicateZeros();

        dz.duplicateZeros(new int[]{8, 4, 5, 0, 0, 0, 0, 7});
    }

    public void duplicateZeros(int[] arr) {

        int zeroCount = 0;
        int length = 0;

        for (int i = 0; i < arr.length - zeroCount; i++) {
            if (arr[i] == 0) {
                if (length + 2 < arr.length) {
                    zeroCount++;
                    length++;
                }
            }
            length++;
        }

        int start = arr.length - 1 - zeroCount;

        for (int i = start; i >= 0; i--) {
            if (arr[i] == 0 && zeroCount > 0) {
                arr[i + zeroCount] = 0;
                zeroCount--;
                arr[i + zeroCount] = 0;
            } else {
                arr[i + zeroCount] = arr[i];
            }
        }
    }
}
