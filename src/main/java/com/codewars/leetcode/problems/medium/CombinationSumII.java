package com.codewars.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 27.09.2022
 */
public class CombinationSumII {

    public static void main(String[] args) {
        CombinationSumII cs = new CombinationSumII();

        List<List<Integer>> lists = cs.combinationSum2(new int[]{1, 1, 2, 1, 1, 1}, 3);
        System.out.println();
        List<List<Integer>> lists1 = cs.combinationSum2(new int[]{1, 1, 2}, 2);
        System.out.println();
        List<List<Integer>> lists2 = cs.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println();
        List<List<Integer>> lists3 = cs.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5);
        System.out.println();

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        HashSet<List<Integer>> rez = new HashSet<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, rez, cur);
        return new ArrayList<>(rez);
    }

    private void backtrack(int[] candidates, int target, int idx, HashSet<List<Integer>> rez, List<Integer> cur) {
        if (target == 0) {
            rez.add(List.copyOf(cur));
        } else {
            /*
             * We just remove prev one and should ckip current if it is equal to prev.
             *
             * like in 1,1,1,1,2 target = 3
             * we parse 1,1,1 -> save
             * remove 1 --> 1, 1
             * then parse index 3
             * 1,1 and should skip 1 on index 3
             * and go to 2
             * 1,1,2
             * remove 2
             * remove 1
             * 1
             * skip all 1
             * and go to 2
             * 1, 2
             */
            for (int i = idx; i < candidates.length; ++i) {
                if (i > idx && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                if (candidates[i] > target) {
                    break;
                }

                cur.add(candidates[i]);
                backtrack(candidates, target - candidates[i], i + 1, rez, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
