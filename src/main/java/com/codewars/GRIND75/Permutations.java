package com.codewars.GRIND75;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Sergey Golitsyn
 * created on 20.09.2023
 */
public class Permutations {

    public static void main(String[] args) {
        Permutations p = new Permutations();
        List<List<Integer>> permute = p.permute(new int[]{1, 2, 3});
        System.out.println();
    }


    /*
    Example 1:

    Input: nums = [1,2,3]
    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rez = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtrack(nums, rez, cur);
        return rez;
    }

    private void backtrack(int[] nums, List<List<Integer>> rez, List<Integer> cur) {
        if(nums.length == cur.size()){
            rez.add(List.copyOf(cur));
        }
        for(int i = 0; i < nums.length; i++){
            if(!cur.contains(nums[i])){
                cur.add(nums[i]);
                backtrack(nums, rez, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
