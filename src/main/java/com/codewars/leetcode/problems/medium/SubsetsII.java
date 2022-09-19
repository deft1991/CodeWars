package com.codewars.leetcode.problems.medium;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 17.09.2022
 */
public class SubsetsII {

    public static void main(String[] args) {
        SubsetsII s = new SubsetsII();
//        List<List<Integer>> lists = s.subsetsWithDup(new int[]{});
//        System.out.println();
//        List<List<Integer>> lists1 = s.subsetsWithDup(new int[]{1});
//        System.out.println();
//        List<List<Integer>> lists2 = s.subsetsWithDup(new int[]{1, 2});
//        System.out.println();
//        List<List<Integer>> lists3 = s.subsetsWithDup(new int[]{1, 1, 1});
//        System.out.println();
        List<List<Integer>> lists4 = s.subsetsWithDup(new int[]{4, 1, 0});
        System.out.println();

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<List<Integer>> rez = new HashSet<>();
        List<Integer> cur = new ArrayList<>();
        backtrack(nums, rez, 0, cur);
        return new ArrayList<>(rez);
    }

    private void backtrack(int[] nums, HashSet<List<Integer>> rez, int idx, List<Integer> cur){
        List<Integer> copy = new ArrayList<>(cur);
        Collections.sort(copy);
        rez.add(copy);

        for (int i = idx; i < nums.length; i ++){
            cur.add(nums[i]);
            backtrack(nums, rez, i + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        HashSet<List<Integer>> rez = new HashSet<>();
        List<Integer> cur = new ArrayList<>();
        /*
        if we can modify nums array
        we can sort nums instead of copy
         */
        Arrays.sort(nums);
        backtrack(nums, rez, 0, cur);
        return new ArrayList<>(rez);
    }

    private void backtrack2(int[] nums, HashSet<List<Integer>> rez, int idx, List<Integer> cur){
        List<Integer> copy = new ArrayList<>(cur);
//        Collections.sort(copy);
        rez.add(copy);

        for (int i = idx; i < nums.length; i ++){
            cur.add(nums[i]);
            backtrack(nums, rez, i + 1, cur);
            cur.remove(cur.size() - 1);
            // check for any duplicate record
            while(i<nums.length-1 && nums[i] == nums[i+1]){
                i++;
            }
        }
    }
}
