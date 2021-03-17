package com.codewars.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/**
 * @author Sergey Golitsyn
 * created on 13.03.2021
 */
public class FourSum2 {

    public static void main(String[] args) {
        FourSum2 fourSum = new FourSum2();
//        List<List<Integer>> lists = fourSum.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
//        System.out.println();
//        lists = fourSum.fourSum(new int[]{}, 0);
//        System.out.println();
//
//        lists = fourSum.fourSum(new int[]{-2, -1, -1, 1, 1, 2, 2}, 0);
//        System.out.println();
//
//        lists = fourSum.fourSum(new int[]{0, 0, 0, 0}, 0);
//        System.out.println();
//
//        List<List<Integer>> lists2 = fourSum.fourSum(new int[]{-3, -1, 0, 2, 4, 5}, 0);
//        System.out.println();

        List<List<Integer>> lists3 = fourSum.fourSum(new int[]{-4,-3,-2,-1,0,0,1,2,3,4}, 0);
        System.out.println();
    }

    public List<List<Integer>> fourSum(int[] array, int target) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, List<Pair>> sums = new HashMap<>();
        int n = array.length;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                // add current sum to solution
                Pair cur = new Pair(j, i);
                int sum = array[j] + array[i];
                List<Pair> pairs = sums.getOrDefault(sum, new ArrayList<Pair>());
                pairs.add(cur);
                sums.put(sum, pairs);

                // find if there are any match pairs
                pairs = sums.get(target - sum);
                if (pairs != null) {
                    for (Pair p : pairs) {
                        if (p.second < j) {
                            List<Integer> candidate = Arrays.asList(array[p.first], array[p.second], array[j], array[i]);
                            Collections.sort(candidate);
                            if (!res.contains(candidate)) {
                                res.add(candidate);
                            }
                        }
                    }
                }
            }
        }

        return res;
    }

    public List<List<Integer>> fourSumOld(int[] nums, int target) {
        List<List<Integer>> rez = new ArrayList<>();
        if (nums.length < 4){
            return rez;
        }

        int n = nums.length;
        // Store sums of all pairs in a hash table
        HashMap<Integer, Pair> mp = getSumPairHashMap(nums, n);
        HashSet<Rez> set = new HashSet<>();
        // Traverse through all pairs and search
        // for X - (current pair sum).
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = nums[i] + nums[j];

                // If X - sum is present in hash table,
                if (mp.containsKey(target - sum)) {

                    // Making sure that all elements are
                    // distinct array elements and an
                    // element is not considered more than
                    // once.
                    Pair p = mp.get(target - sum);

                    if (p.first != i && p.first != j
                            && p.second != i && p.second != j) {
//                        System.out.print(
//                                nums[i] + ", " + nums[j] + ", "
//                                        + nums[p.first] + ", "
//                                        + nums[p.second]);
                        set.add(new Rez(nums[i], nums[j], nums[p.first], nums[p.second]));
                    }
                }
            }
        }
        for(Rez r : set){
            rez.add(List.of(r.a,r.b, r.c, r.d));
        }

        return rez;
    }

    private HashMap<Integer, Pair> getSumPairHashMap(int[] nums, int n) {
        HashMap<Integer, Pair> mp = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                mp.put(nums[i] + nums[j], new Pair(i, j));
            }
        }
        return mp;
    }

    static class Pair {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    class Rez {
        int a, b, c, d;

        public Rez(int a, int b, int c, int d) {
            int[] ints = {a, b, c, d};
            Arrays.sort(ints);
            this.a = ints[0];
            this.b = ints[1];
            this.c = ints[2];
            this.d = ints[3];
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Rez rez = (Rez) o;
            return a == rez.a && b == rez.b && c == rez.c && d == rez.d;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b, c, d);
        }
    }
}
