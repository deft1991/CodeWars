package com.codewars.leetcode.problems.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 28.03.2021
 */
public class NumberGoodPairs {

    public static void main(String[] args) {
        NumberGoodPairs n = new NumberGoodPairs();
        System.out.println(n.numIdenticalPairs(new int[] {1,2,3,1,1,3})); // 4
        System.out.println(n.numIdenticalPairs(new int[] {1,1,1,1})); // 6
        System.out.println(n.numIdenticalPairs(new int[] {1,2,3})); // 0
    }

    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int rez = 0;
        for (int num : nums) {
            if (map.containsKey(num)){
                int val = map.get(num);
                rez += val;
                map.put(num, val + 1);
            } else {
                map.put(num, 1);
            }
        }


        return rez;
    }
}
