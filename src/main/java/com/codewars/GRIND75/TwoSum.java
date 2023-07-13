package com.codewars.GRIND75;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 13.07.2023
 */
public class TwoSum {

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        System.out.println(Arrays.toString(ts.twoSum(new int[]{2,7,11,15}, 9))); // 0 1
        System.out.println(Arrays.toString(ts.twoSum(new int[]{3,2,4}, 6))); // 1, 2
        System.out.println(Arrays.toString(ts.twoSum(new int[]{3,3}, 6))); // 0 1
    }

    public int[] twoSum(int[] nums, int target) {
        int[] rez = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (map.containsKey(cur)){
                rez[0] = map.get(cur);
                rez[1] = i;
                return rez;
            } else {
                map.put(target- cur, i);
            }
        }
        return rez;
    }
}
