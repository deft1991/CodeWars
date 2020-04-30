package com.codewars.leetcode.array;

import java.util.Arrays;

/*
 * Created by sgolitsyn on 4/30/20
 *
 * Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
*
*
* Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 */
public class SortedSquares {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(new SortedSquares().sortedSquares(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(new SortedSquares().sortedSquares(new int[]{-7, -3, 2, 3, 11})));
    }

    public int[] sortedSquares(int[] A) {
        int[] rez = new int[A.length];

        int i = 0;

        while (A[i] < 0) {
            i++;
        }
        int j = i + 1;
        int t = 0;
        while (i >= 0 && j < A.length) {
            if (A[i] * A[i] > A[j] * A[j]) {
                rez[t++] = A[j] * A[j];
                j++;
            } else {
                rez[t++] = A[i] * A[i];
                i--;
            }
        }

        while (i >= 0) {
            rez[t++] = A[i] * A[i];
            i++;
        }

        while (j < A.length) {
            rez[t++] = A[j] * A[j];
            j++;
        }
        return rez;
    }
}
