package com.codewars.neetcode.twoPointers;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 07.12.2022
 */
public class TwoSumIIInputArrayIsSorted {

    public static void main(String[] args) {
        TwoSumIIInputArrayIsSorted t = new TwoSumIIInputArrayIsSorted();
        System.out.println(Arrays.toString(t.twoSum(new int[]{2, 7, 11, 15}, 9))); // 1 2
        System.out.println(Arrays.toString(t.twoSum(new int[]{2, 3, 4}, 6))); // 1 3
        System.out.println(Arrays.toString(t.twoSum(new int[]{-1,0}, -1))); // 1 2
    }

    public int[] twoSum(int[] numbers, int target) {

        int[] rez = new int[2];

        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            int a = numbers[start];
            int b = numbers[end];
            if (a + b == target) {
                rez[0] = start + 1;
                rez[1] = end + 1;
                return rez;
            } else if (a + b > target) {
                end--;
            } else {
                start++;
            }
        }
        return rez;
    }
}
