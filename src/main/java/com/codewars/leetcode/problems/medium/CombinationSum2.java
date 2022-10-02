package com.codewars.leetcode.problems.medium;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 27.09.2022
 */
public class CombinationSum2 {

    public static void main(String[] args) {
        CombinationSum2 cs = new CombinationSum2();
        List<List<Integer>> lists0 = cs.combinationSum(new int[]{1}, 1);
        System.out.println();
        List<List<Integer>> lists01 = cs.combinationSum(new int[]{1,1}, 1);
        System.out.println();
        List<List<Integer>> lists02 = cs.combinationSum(new int[]{1,1}, 2);
        System.out.println();
        List<List<Integer>> lists03 = cs.combinationSum(new int[]{1,2}, 3);
        System.out.println();
        List<List<Integer>> lists = cs.combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println();
        List<List<Integer>> lists2 = cs.combinationSum(new int[]{2,3,5}, 8);
        System.out.println();
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> rez = new HashSet<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, rez, current);
        return new ArrayList<>(rez);
    }

    private void backtrack(int[] candidates, int target, int index, Set<List<Integer>> rez, List<Integer> current) {
        if (target < 0){
            return;
        }
        if (target == 0){
            List<Integer> cur = new ArrayList<>(current);
            Collections.sort(cur);
            rez.add(cur);
            return;
        }

        for (int i = index; i < candidates.length; i++){
            current.add(candidates[i]);
            backtrack(candidates, target - candidates[i], index, rez, current);
            current.remove(current.size()-1);
        }
    }
}
