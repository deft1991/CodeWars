package com.codewars.leetcode.dataStructure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 30.03.2022
 */
public class TwoSum {

    public static void main(String[] args) {
        TwoSum t = new TwoSum();

        System.out.println(Arrays.toString(t.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(t.twoSum(new int[]{1,1,1,1,1,4,1,1,1,1,1,7,1,1,1,1,1}, 11)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int rest = target - nums[i];

            if (map.containsKey(rest)) {
                return new int[]{map.get(rest), i};
            }
//            else if (map.containsKey(nums[i])) {
//                return new int[]{map.get(nums[i]), i};
//            }
            else {
                map.put(nums[i], i);
            }
        }
        return new int[]{0, 0};
    }
}
