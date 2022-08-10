package com.codewars.leetcode.days14;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Sergey Golitsyn
 * created on 24.02.2022
 */
public class Permute {

    public static void main(String[] args) {
        Permute p = new Permute();
        p.permute(new int[]{1, 2, 3});
    }

    List<List<Integer>> rez;
    List<Integer> cur;

    public List<List<Integer>> permute(int[] nums) {
        rez = new ArrayList<>();
        cur = new ArrayList<>();
        permute(nums, nums.length);
        return rez;
    }

    private void permute(int[] nums, int length) {
        if (length == 0) {
            List<Integer> tmp = new ArrayList<>(cur);
            rez.add(tmp);
        } else {

            for (int i = 0; i < nums.length; i++) {
                if (cur.contains(i)){
                    continue;
                }
                cur.add(nums[i]);
                permute(nums, length - 1);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
