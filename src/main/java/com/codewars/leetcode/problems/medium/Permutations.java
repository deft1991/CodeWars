package com.codewars.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 17.09.2022
 */
public class Permutations {

    public static void main(String[] args) {
        Permutations p = new Permutations();
        List<List<Integer>> permute = p.permute(new int[]{});
        System.out.println();
        List<List<Integer>> permute1 = p.permute(new int[]{1});
        System.out.println();
        List<List<Integer>> permute2 = p.permute(new int[]{1, 2});
        System.out.println();
        List<List<Integer>> permute3 = p.permute(new int[]{1,2,3});
        System.out.println();
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rez = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtrack(nums, 0, rez, cur);
        return rez;
    }

    private void backtrack(int[] nums, int idx, List<List<Integer>> rez, List<Integer> cur) {
        if (cur.size() == nums.length) {
            rez.add(List.copyOf(cur));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if(cur.contains(nums[i])){
                    continue;
                }
                cur.add(nums[i]);
                backtrack(nums, i + 1, rez, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
