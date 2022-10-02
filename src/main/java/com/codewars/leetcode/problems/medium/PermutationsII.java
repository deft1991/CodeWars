package com.codewars.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 19.09.2022
 */
public class PermutationsII {

    public static void main(String[] args) {
        PermutationsII p = new PermutationsII();
//        List<List<Integer>> lists = p.permuteUnique(new int[]{});
//        System.out.println();
//        List<List<Integer>> lists1 = p.permuteUnique(new int[]{1});
//        System.out.println();
//        List<List<Integer>> lists2 = p.permuteUnique(new int[]{1, 2});
//        System.out.println();
        List<List<Integer>> lists3 = p.permuteUnique(new int[]{1, 1});
        System.out.println();
//        List<List<Integer>> lists4 = p.permuteUnique(new int[]{1, 1, 2});
//        System.out.println();
    }

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> rez = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, rez, current);

        return List.copyOf(rez);
    }

    private void backtrack(int[] nums, int idx, List<List<Integer>> rez, List<Integer> current) {
        if (current.size() == nums.length){
            rez.add(List.copyOf(current));
        }

        for(int i = 0; i < nums.length; i++){
            if (i == idx){
                continue;
            }
            current.add(nums[i]);
            backtrack(nums, i + 1, rez, current);
            current.remove(current.size() - 1);
            while (i + 1 < nums.length && nums[i] == nums[i+1]){
                i++;
            }
        }
    }
}
