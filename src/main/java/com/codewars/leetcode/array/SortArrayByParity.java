package com.codewars.leetcode.array;

import java.util.Arrays;

/*
 * Created by sgolitsyn on 5/19/20
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.



Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.


Note:

1 <= A.length <= 5000
0 <= A[i] <= 5000
 */
public class SortArrayByParity {

    public static void main(String[] args) {
        SortArrayByParity sortArrayByParity = new SortArrayByParity();
        int[] ints = {3, 1, 2, 4};
        System.out.println(Arrays.toString(sortArrayByParity.sortArrayByParity(ints)));

    }

    public int[] sortArrayByParity(int[] A) {
        int posEven = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                int tmp = A[posEven];
                A[posEven] = A[i];
                A[i] = tmp;
                posEven++;
            }
        }
        return A;
    }
}
