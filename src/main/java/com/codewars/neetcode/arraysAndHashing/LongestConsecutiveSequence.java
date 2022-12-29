package com.codewars.neetcode.arraysAndHashing;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Sergey Golitsyn
 * created on 05.12.2022
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        LongestConsecutiveSequence l = new LongestConsecutiveSequence();
        System.out.println(l.longestConsecutive(new int[]{1, 2, 3, 4})); // 4
        System.out.println(l.longestConsecutive(new int[]{4, 3, 2, 1})); // 4
        System.out.println(l.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2})); // 4
        System.out.println(l.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1})); // 9
        System.out.println(l.longestConsecutive(new int[]{0, -1}));
    }

    public int longestConsecutive2(int[] nums) {
        int max = 0;
        int curMax = 0;
        Set<Integer> set = new TreeSet<>((a, b) -> a - b);

        for (int num : nums) {
            set.add(num);
        }
        int prev = Integer.MIN_VALUE;
        for (Integer i : set) {
            if (prev > i || prev + 1 != i) {
                max = Math.max(max, curMax);
                curMax = 0;
            }
            curMax++;
            prev = i;
        }
        max = Math.max(max, curMax);
        return max;
    }

    public int longestConsecutive(int[] nums) {
        int max = 0;

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }
        for (Integer i : set) {
            if (!set.contains(i - 1)) {
                int prev = i;
                int curMax = 1;
                while (set.contains(prev + 1)) {
                    prev++;
                    curMax++;
                }
                max = Math.max(max, curMax);
            }
        }
        return max;
    }
}
