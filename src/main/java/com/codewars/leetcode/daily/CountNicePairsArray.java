package com.codewars.leetcode.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 21.11.2023
 */
public class CountNicePairsArray {

    public static void main(String[] args) {
        CountNicePairsArray c = new CountNicePairsArray();
//        System.out.println(c.rev(123));
//        System.out.println(c.rev(321));
        System.out.println(c.countNicePairs(new int[]{42,11,1,97}));
        System.out.println(c.countNicePairs(new int[]{13,10,35,24,76}));
    }

    /*
    x - rev(x) = y - rev(y);

    42,11,1,97

    42 - 24
    11 - 11
    1 - 1
    97 - 79
     */
    public int countNicePairs(int[] nums) {
        int rez = 0;

        int[] count = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            count[i] = nums[i] - rev(nums[i]);
        }

        Map<Integer, Integer> map = new HashMap<>();
        int MOD = (int) 1e9+7;
        for (int c : count) {
            rez += map.getOrDefault(c, 0) % MOD;
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        return rez;
    }

    private int rev(int i) {
        int rez = 0;
        while (i != 0) {
            rez *= 10;
            rez += i % 10;
            i /= 10;
        }
        return rez;
    }
}
