package com.codewars.neetcode.twoPointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 08.12.2022
 */
public class TwoSum {

    public static void main(String[] args) {
        TwoSum t = new TwoSum();
        System.out.println(Arrays.toString(t.twoSum(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(t.twoSum(new int[]{3,2,4}, 6)));
        System.out.println(Arrays.toString(t.twoSum(new int[]{3,3}, 6)));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] rez = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            int rest = target - nums[i];
            if(map.containsKey(rest)){
                rez[0] = map.get(rest);
                rez[1] = i;
                return rez;
            } else {
                map.put(nums[i], i);
            }
        }
        return rez;
    }
}
