package com.codewars.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 01.02.2024
 */
public class DivideArrayIntoArraysWithMaxDifference {

    public static void main(String[] args) {
        DivideArrayIntoArraysWithMaxDifference d = new DivideArrayIntoArraysWithMaxDifference();

        int[][] ints = d.divideArray(new int[]{1, 3, 4, 8, 7, 9, 3, 5, 1}, 2);

//        for (int[] arr : ints){
//            System.out.println(Arrays.toString(arr));
//        }
//        System.out.println("----");
        ints = d.divideArray(new int[]{1,3,3,2,7,3}, 3);

        for (int[] arr : ints){
            System.out.println(Arrays.toString(arr));
        }
    }

    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);

        int[][]rez = new int[nums.length / 3][3];

        for (int i = 0; i < nums.length - 2; i+=3){
            if (nums[i + 2] - nums[i] > k){
                return new int[0][0];
            }
            rez[i/3] = new int[] {nums[i], nums[i+1], nums[i+2]};
        }

        return rez;
    }
}
