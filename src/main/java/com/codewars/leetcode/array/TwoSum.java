package com.codewars.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Created by sgolitsyn on 1/11/20
 */
public class TwoSum {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
//        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{2, 7, 11, 15}, 9)));
//        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{1,3,4,2}, 6)));
    }


    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remainder = target - nums[i];
            if (hash.containsKey(remainder)){
                return new int[]{hash.get(remainder), i};
            }
            hash.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
