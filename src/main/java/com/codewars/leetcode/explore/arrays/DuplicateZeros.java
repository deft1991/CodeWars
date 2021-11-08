package com.codewars.leetcode.explore.arrays;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 07.11.2021
 */
public class DuplicateZeros {

    public static void main(String[] args) {
        DuplicateZeros dz = new DuplicateZeros();

        int[] arr = new int[]{0, 0, 0, 0, 0};
        dz.duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));

//        arr = new int[]{0, 1, 7, 6, 0, 2, 0, 7};
//        dz.duplicateZeros(arr);
//        System.out.println(Arrays.toString(arr));

//        dz.duplicateZeros(new int[]{8, 4, 5, 0, 0, 0, 0, 7});
    }

    public void duplicateZeros(int[] arr) {

        int length = arr.length - 1;
        int possibleZeros = 0;

        for (int left = 0; left <= length - possibleZeros; left++) {
            if (arr[left] == 0) {

                if (left == length - possibleZeros) {
                    arr[length] = 0;
                    length--;
                    break;
                } else {
                    possibleZeros++;
                }
            }
        }

        int writer = length - possibleZeros;
        int last = length;
        for (int i = writer; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[last--] = 0;
                arr[last--] = 0;
            } else {
                arr[last--] = arr[i];
            }
        }
    }
}
