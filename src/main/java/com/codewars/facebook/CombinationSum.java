package com.codewars.facebook;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 15.08.2023
 */
public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum c = new CombinationSum();
        List<List<Integer>> lists = c.combinationSum(new int[]{2, 3, 6, 7}, 7);
        for (List<Integer> list : lists){
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> rez = new HashSet<>();
        List<Integer> visited = new ArrayList<>();
        backtracking(candidates, target, rez, visited);
        return new ArrayList<>(rez);
    }

    private void backtracking(int[] candidates, int target, Set<List<Integer>> rez, List<Integer> cur){
        if(target == 0){
            List<Integer> e = new ArrayList<>(cur);
            Collections.sort(e);
            rez.add(e);
        }
        if(target < 0){
            return;
        }

        for (int candidate : candidates) {
            cur.add(candidate);
            backtracking(candidates, target - candidate, rez, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
