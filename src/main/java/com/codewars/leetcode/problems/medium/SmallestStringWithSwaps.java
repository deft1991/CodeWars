package com.codewars.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Sergey Golitsyn
 * created on 19.03.2021
 */
public class SmallestStringWithSwaps {

    public static void main(String[] args) {
        SmallestStringWithSwaps s = new SmallestStringWithSwaps();

        String dcab = s.smallestStringWithSwaps("dcab", List.of(List.of(0, 3), List.of(1, 2)));
        assert dcab.equals("bacd");
        System.out.println(dcab); // bacd
        String abcd = s.smallestStringWithSwaps("dcab", List.of(List.of(0, 3), List.of(1, 2), List.of(0, 2)));
        assert abcd.equals("abcd");
        System.out.println(abcd);
        String abc = s.smallestStringWithSwaps("cba", List.of(List.of(0, 1), List.of(1, 2)));
        assert abc.equals("abc");
        System.out.println(abc);
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        char[] chars = s.toCharArray();
        Union union = new Union(n, chars);
        for (List<Integer> pair : pairs) {
            int first = pair.get(0);
            int second = pair.get(1);

            if (!union.isConnected(first, second)) {
                union.connect(first, second);
            }
        }

        Map<Integer, List<Character>> map = new HashMap<>();
        char[] sChar = s.toCharArray();
        for (int i = 0; i < sChar.length; i++) {
            int root = union.root(i);
            map.putIfAbsent(root, new ArrayList<>());
            map.get(root).add(sChar[i]);
        }

        map.values().forEach(Collections::sort);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sChar.length; i++) {
            sb.append(map.get(union.root(i)).remove(0));
        }
        return sb.toString();
    }

    static class Union {
        int[] arr;
        char[] chars;

        Union(int n, char[] chars) {
            this.chars = chars;
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i;
            }
        }

        public boolean isConnected(int a, int b) {
            return root(a) == root(b);
        }

        public int root(int idx) {
            while (arr[idx] != idx) {
                arr[idx] = arr[arr[idx]];
                idx = arr[idx];
            }
            return idx;
        }

        public void connect(int a, int b) {
            int idxA = root(a);
            int idxB = root(b);
            if (arr[idxA] > arr[idxB]) {
                arr[idxA] = idxB;
            } else {
                arr[idxB] = idxA;
            }
        }
    }
}
