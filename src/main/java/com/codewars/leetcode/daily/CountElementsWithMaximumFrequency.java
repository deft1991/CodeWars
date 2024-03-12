package com.codewars.leetcode.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 08.03.2024
 */
public class CountElementsWithMaximumFrequency {

    public static void main(String[] args) {
        CountElementsWithMaximumFrequency c = new CountElementsWithMaximumFrequency();
        System.out.println(c.maxFrequencyElements(new int[]{1,2,2,3,1,4}));
        System.out.println(c.maxFrequencyElements(new int[]{1,2,3,4,5}));
    }

    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int max = 0;
        for(int i : nums){
            int cur = map.getOrDefault(i, 0) + 1;
            max = Math.max(max, cur);
            map.put(i, cur);
        }

        int rez = 0;
        for(int i : map.values()){
            if(i == max){
                rez += max;
            }
        }
        return rez;
    }
}
