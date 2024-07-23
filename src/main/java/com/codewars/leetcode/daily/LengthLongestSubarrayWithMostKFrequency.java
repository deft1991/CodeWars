package com.codewars.leetcode.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 28.03.2024
 */
public class LengthLongestSubarrayWithMostKFrequency {

    public static void main(String[] args) {
        LengthLongestSubarrayWithMostKFrequency l = new LengthLongestSubarrayWithMostKFrequency();

        System.out.println(l.maxSubarrayLength(new int[]{1,2,3,1,2,3,1,2}, 2)); // 6
        System.out.println(l.maxSubarrayLength(new int[]{1,2,1,2,1,2,1,2}, 1)); // 2
        System.out.println(l.maxSubarrayLength(new int[]{5,5,5,5,5,5,5}, 4)); // 4
    }

    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int max = 0;
        int start = 0;

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
                while(map.get(nums[i]) > k){
                    map.put(nums[start], map.get(nums[start]) - 1);
                    start++;
                }
            } else {
                map.put(nums[i], 1);
            }
            max = Math.max(max, i - start +1);
        }

        return Math.max(max, nums.length - start);
    }
}
