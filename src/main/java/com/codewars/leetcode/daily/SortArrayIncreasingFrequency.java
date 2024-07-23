package com.codewars.leetcode.daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Sergey Golitsyn
 * created on 22.07.2024
 */
public class SortArrayIncreasingFrequency {

    public static void main(String[] args) {
        SortArrayIncreasingFrequency s = new SortArrayIncreasingFrequency();
        System.out.println(Arrays.toString(s.frequencySort(new int[]{1, 1, 2, 2, 2, 3})));
    }

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> {
            int comp = Integer.compare(a.freq, b.freq);
            if (comp == 0) {
                return Integer.compare(b.val, a.val);
            } else {
                return comp;
            }
        });

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            q.add(new Pair(entry.getValue(), entry.getKey()));
        }

        int writer = 0;
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            for (int i = 0; i < pair.freq; i++) {
                nums[writer++] = pair.val;
            }
        }

        return nums;
    }

    record Pair(int freq, int val) {
    }
}
