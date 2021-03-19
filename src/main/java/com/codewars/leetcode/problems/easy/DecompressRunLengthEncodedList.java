package com.codewars.leetcode.problems.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 19.03.2021
 */
public class DecompressRunLengthEncodedList {

    public static void main(String[] args) {
        DecompressRunLengthEncodedList d = new DecompressRunLengthEncodedList();
        System.out.println(Arrays.toString(d.decompressRLElist(new int[]{1,2,3,4}))); // 2,4,4,4
        System.out.println(Arrays.toString(d.decompressRLElist(new int[]{1,1,2,3}))); // 1,1,2,3
    }

    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i += 2) {
            int a = nums[i];
            int b = nums[i + 1];

            for (int j = 0; j < a; j++){
                list.add(b);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
