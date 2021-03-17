package com.codewars.leetcode.problems.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 12.03.2021
 */
public class HowManyNumbersAreSmallerThanCurrentNumber {

    public static void main(String[] args) {
        HowManyNumbersAreSmallerThanCurrentNumber h = new HowManyNumbersAreSmallerThanCurrentNumber();
        System.out.println(Arrays.toString(h.smallerNumbersThanCurrent(new int[]{8,1,2,2,3}))); // 4,0,1,1,3
        System.out.println(Arrays.toString(h.smallerNumbersThanCurrent(new int[]{6,5,4,8}))); // 2,1,0,3
        System.out.println(Arrays.toString(h.smallerNumbersThanCurrent(new int[]{7,7,7,7}))); // 0,0,0,0
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {

        int[] tmp = nums.clone();
        int[] rez = new int[nums.length];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        Arrays.sort(tmp);

        map.put(tmp[0], 0);
        for (int i = 1; i < tmp.length; i++) {
            if (tmp[i] > tmp[i - 1]){
                map.put(tmp[i], i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            rez[i] = map.get(nums[i]);
        }
        return rez;
    }
}
