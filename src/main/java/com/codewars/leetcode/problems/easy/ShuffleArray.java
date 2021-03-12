package com.codewars.leetcode.problems.easy;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 10.03.2021
 */
public class ShuffleArray {

    public static void main(String[] args) {
        ShuffleArray sa = new ShuffleArray();
        System.out.println(Arrays.toString(sa.shuffle(new int[]{2,5,1,3,4,7}, 3)));
        System.out.println(Arrays.toString(sa.shuffle(new int[]{1,2,3,4,4,3,2,1}, 4)));
        System.out.println(Arrays.toString(sa.shuffle(new int[]{1,1,2,2}, 2)));
    }

    public int[] shuffle(int[] nums, int n) {

        int readerStart = 0;
        int readerEnd = n;
        int writer = 0;
        int[] rez = new int[nums.length];
        while (readerStart < n){
            rez[writer++] = nums[readerStart++];
            rez[writer++] = nums[readerEnd++];
        }
        return rez;
    }
}
