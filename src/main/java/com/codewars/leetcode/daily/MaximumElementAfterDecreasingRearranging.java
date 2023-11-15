package com.codewars.leetcode.daily;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 15.11.2023
 */
public class MaximumElementAfterDecreasingRearranging {

    public static void main(String[] args) {
        MaximumElementAfterDecreasingRearranging m = new MaximumElementAfterDecreasingRearranging();
        System.out.println(m.maximumElementAfterDecrementingAndRearranging(new int[]{2, 2, 1, 2, 1})); // 2
        System.out.println(m.maximumElementAfterDecrementingAndRearranging(new int[]{100,1,1000})); // 3
        System.out.println(m.maximumElementAfterDecrementingAndRearranging(new int[]{1,2,3,4,5})); // 3
    }

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;

        int[]counts = new int[n + 1];

        for (int el : arr){
            counts[Math.min(el, n)]++;
        }

        int ans = 1;
        for (int i = 2; i <= n; i++){
            ans = Math.min(ans + counts[i], i);
        }
        return ans;
    }

}
