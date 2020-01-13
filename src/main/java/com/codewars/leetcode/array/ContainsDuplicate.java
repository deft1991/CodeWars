package com.codewars.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/*
 * Created by sgolitsyn on 1/9/20
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        int[] nums = {1,2,3,4};

        System.out.println(containsDuplicate.containsDuplicate(nums));
        nums = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

        System.out.println(containsDuplicate.containsDuplicate(nums));
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                return true;
            } else {
                set.add(i);
            }

        }
        return false;
    }
}
