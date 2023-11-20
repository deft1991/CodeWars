package com.codewars.leetcode.daily;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 18.11.2023
 */
public class FrequencyMostFrequentElement {

    public static void main(String[] args) {
        FrequencyMostFrequentElement f = new FrequencyMostFrequentElement();
        System.out.println(f.maxFrequency(new int[]{1,2,4}, 5)); // 3
        System.out.println(f.maxFrequency(new int[]{1,4,8,13}, 5)); // 2
    }

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 0;
        int rez = 0;
        int cur = 0;
        for (int end = 0; end < nums.length; end++){
            int target = nums[end];
            cur += target;

            while ((end - start + 1) * target - cur > k){
                cur -= nums[start];
                start++;
            }
           rez = Math.max(rez, end - start + 1);
        }
        return rez;
    }
}
