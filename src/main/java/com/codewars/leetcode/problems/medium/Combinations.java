package com.codewars.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 20.09.2022
 */
public class Combinations {

    public static void main(String[] args) {
        Combinations c = new Combinations();
        List<List<Integer>> combine = c.combine(1, 1);
        System.out.println();
        List<List<Integer>> combine1 = c.combine(2, 2);
        System.out.println();
        List<List<Integer>> combine2 = c.combine(4, 2);
        System.out.println();
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> rez = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtrack(n, k, 1, rez, cur);
        return rez;
    }

    private void backtrack(int n, int k, int idx, List<List<Integer>> rez, List<Integer> cur) {
        if (k == 0) {
            List<Integer> tmp = new ArrayList<>(cur);
            rez.add(tmp);
        } else {
            for (int i = idx; i <= n; i++) {
                cur.add(i);
                backtrack(n, k - 1, i + 1, rez, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }


}
