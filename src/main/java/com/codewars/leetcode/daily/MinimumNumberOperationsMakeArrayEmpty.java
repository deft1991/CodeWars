package com.codewars.leetcode.daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 04.01.2024
 */
public class MinimumNumberOperationsMakeArrayEmpty {

    public static void main(String[] args) {
        MinimumNumberOperationsMakeArrayEmpty m = new MinimumNumberOperationsMakeArrayEmpty();
        System.out.println(m.minOperations(new int[]{2,3,3,2,2,4,2,3,4}));
//        System.out.println(m.minOperations(new int[]{2,1,2,2,3,3}));
    }

    public int minOperations(int[] nums) {
        Arrays.sort(nums);

        int start = 0;
        int rez = 0;

        while(start < nums.length){
            int end = start;
            int count = 0;
            while(end < nums.length && nums[start] == nums[end]){
                count++;
                end++;
            }
            if (count == 1){
                return -1;
            }
            rez += count/3;
            if (count % 3 != 0){
                rez++;
            }
            start = end;
        }
        return rez;
    }
}
