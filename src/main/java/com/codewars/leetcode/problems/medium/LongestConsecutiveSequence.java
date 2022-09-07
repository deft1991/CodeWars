package com.codewars.leetcode.problems.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Sergey Golitsyn
 * created on 06.09.2022
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        System.out.println(lcs.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2})); // 4
        System.out.println(lcs.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1})); // 9
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;

        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            int localMax = 0;
            if (set.contains(num)) {
                localMax++;
                while (set.contains(num + 1)) {
                    num++;
                    localMax++;
                }
            }
            max = Math.max(max, localMax);
        }
        return max;
    }
}
