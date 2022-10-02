package com.codewars.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 27.09.2022
 */
public class CombinationSumIII {

    public static void main(String[] args) {
        CombinationSumIII cs = new CombinationSumIII();
//        List<List<Integer>> lists = cs.combinationSum3(3, 7);
//        System.out.println();
//        List<List<Integer>> lists1 = cs.combinationSum3(3, 9);
//        System.out.println();
//        List<List<Integer>> lists2 = cs.combinationSum3(4, 1);
//        System.out.println();
        List<List<Integer>> lists3 = cs.combinationSum3(9, 45);
        System.out.println();
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> rez = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        backtrack(k, n, 1, rez, cur);
        return rez;
    }

    private void backtrack(int k, int n, int idx, List<List<Integer>> rez, List<Integer> cur) {
        if (cur.size() == k && n == 0){
            rez.add(List.copyOf(cur));
            return;
        }
        if (cur.size() == k || n == 0){
            return;
        }
        for (int i = idx; i <= 9; i++ ){
            cur.add(i);
            backtrack(k, n - i, i + 1, rez, cur);
            cur.remove(cur.size()-1);
        }
    }
}
