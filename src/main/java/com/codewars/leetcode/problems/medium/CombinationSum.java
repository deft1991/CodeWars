package com.codewars.leetcode.problems.medium;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 20.09.2022
 */
public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum c = new CombinationSum();

//        List<List<Integer>> lists = c.combinationSum(new int[]{2}, 1);
//        System.out.println();
//        List<List<Integer>> lists1 = c.combinationSum(new int[]{1}, 1);
//        System.out.println();
//        List<List<Integer>> lists2 = c.combinationSum(new int[]{1, 2}, 2);
//        System.out.println();
//        List<List<Integer>> lists3 = c.combinationSum(new int[]{1, 2}, 3);
//        System.out.println();
//        List<List<Integer>> lists4 = c.combinationSum(new int[]{1, 2}, 4);
//        System.out.println();
        List<List<Integer>> lists5 = c.combinationSum(new int[]{2,3,6,7}, 7);
        System.out.println();

        List<List<Integer>> lists6 = c.combinationSum(new int[]{2,3,5}, 8);
        System.out.println();
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> rez = new HashSet<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, 0, rez, current);
        return new ArrayList<>(rez);
    }

    private void backtrack(int[] candidates, int target, int index, int sum, Set<List<Integer>> rez, List<Integer> current) {
        if (sum == target) {
            List<Integer> copy = new ArrayList<>(current);
            Collections.sort(copy);
            rez.add(copy);
        } else {
            for (int i = index; i < candidates.length; i++) {
                int cur = candidates[i];
                sum += cur;
                if (sum > target){
                    return;
                }
                current.add(cur);

                backtrack(candidates, target, index, sum, rez, current);

                sum -= cur;
                current.remove(current.size() - 1);
            }
        }

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> rez = new HashSet<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack2(candidates, target, 0, rez, current);
        return new ArrayList<>(rez);
    }

    private void backtrack2(int[] candidates, int target, int index, Set<List<Integer>> rez, List<Integer> current) {
        if (target == 0) {
            List<Integer> copy = new ArrayList<>(current);
            rez.add(copy);
        } else {
            for (int i = index; i < candidates.length; i++) {
                if (candidates[i] > target) {
                    break;
                }
                current.add(candidates[i]);

                backtrack2(candidates, target - candidates[i], i, rez, current);

                current.remove(current.size() - 1);
            }
        }

    }
}
