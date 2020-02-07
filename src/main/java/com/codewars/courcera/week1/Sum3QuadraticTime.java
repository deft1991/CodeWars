package com.codewars.courcera.week1;

import java.util.Arrays;

/*
 * Created by sgolitsyn on 2/7/20
 *
 * 3-SUM in quadratic time. Design an algorithm for the 3-SUM problem that takes time proportional to n^2n
 * in the worst case. You may assume that you can sort the nn integers in time proportional to n^2n
 * or better.


 */
public class Sum3QuadraticTime {
    int[] arr;

    Sum3QuadraticTime(int[] arr) {
        this.arr = arr;
    }

    public void threeSum(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int base = i;
            int start = i + 1;
            int end = arr.length - 1;

            while (start < end){
                int sum = arr[i] + arr[start] + arr[end];
                if (sum == 0){
                    System.out.println(i + " " + start + " " + end);
                } else if (sum < 0){
                    start += 1;
                } else {
                    end -= 1;
                }
            }
        }
    }
}
