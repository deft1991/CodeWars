package com.codewars.leetcode.problems.easy;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 17.06.2021
 */
public class MoveZeroes {

    public static void main(String[] args) {
        MoveZeroes mz = new MoveZeroes();
        int[] arr = new int[] {0,1,0,3,12};
        mz.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void moveZeroes(int[] arr) {
        if (arr != null && arr.length > 1){
            int zeroIdx = -1;
            int nonZeroIdx = -1;

            for (int i = 0; i < arr.length; i++ ) {
                if (arr[i] != 0) {
                    nonZeroIdx = i;
                } else if (arr[i] == 0 && zeroIdx == -1)  {
                    zeroIdx = i;
                }

                if (zeroIdx != -1 && nonZeroIdx != -1 && zeroIdx < nonZeroIdx){
                    swap(zeroIdx, nonZeroIdx, arr);
                    i = zeroIdx;
                    zeroIdx = -1;
                    nonZeroIdx = -1;
                }
            }
        }
    }

    private void swap(int a, int b, int[] arr){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
