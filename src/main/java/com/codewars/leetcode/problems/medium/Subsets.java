package com.codewars.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 13.09.2022
 */
public class Subsets {

    public static void main(String[] args) {
        Subsets s = new Subsets();
//        List<List<Integer>> subsets1 = s.subsets(new int[0]);
//        System.out.println();
//        List<List<Integer>> subsets2 = s.subsets(new int[]{1});
//        System.out.println();
//        List<List<Integer>> subsets3 = s.subsets(new int[]{1, 2});
//        System.out.println();
        List<List<Integer>> subsets4 = s.subsets(new int[]{1, 2, 3});
        System.out.println();
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rez = new ArrayList<>();

        backtrack(nums, 0, rez,  new ArrayList<>());
        return rez;
    }

    private void backtrack(int[] nums, int index, List<List<Integer>> rez, List<Integer> cur) {
        rez.add(List.copyOf(cur));
        for(int i = index; i < nums.length; i ++){
            cur.add(nums[i]);
            backtrack(nums, i+1, rez, cur);
            cur.remove(cur.size()-1);
        }
    }


}
