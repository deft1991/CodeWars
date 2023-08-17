package com.codewars.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 14.08.2023
 */
public class Subsets {

    public static void main(String[] args) {
        Subsets s = new Subsets();
        List<List<Integer>> subsets = s.subsets(new int[]{1, 2, 3});
        for (List<Integer> list : subsets) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rez = new ArrayList<>();
        bfs(nums, rez, new ArrayList<>(), 0);
        return rez;
    }

    private void bfs(int[] nums, List<List<Integer>> rez, List<Integer> current, int startIdx) {
        rez.add(List.copyOf(current));

        for (int i = startIdx; i < nums.length; i++) {
            current.add(nums[i]);
            bfs(nums, rez, current, i + 1);
            current.remove(current.size() - 1);
        }
    }
}
