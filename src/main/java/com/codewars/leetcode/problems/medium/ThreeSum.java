package com.codewars.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @author Sergey Golitsyn
 * created on 16.03.2021
 */
public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum t = new ThreeSum();
        t.threeSum(new int[]{-1,0,1,2,-1,-4});

    }

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> rez = new HashSet<>();
        if (nums.length < 3){
            return new ArrayList<>(rez);
        }
        Map<Integer, Three> map = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i ++){
            for (int j = 0; j < i; j ++){
                int sum = 0 - nums[i] - nums[j];
                Three three = new Three();
                three.a = i;
                three.b = j;
                map.put(sum, three);
            }
        }

        // 1 + 2 - 3 = 0
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i])){
                Three three = map.get(nums[i]);
                if (three.a != i && three.b != i){
                    three.c = i;
                    rez.add(three.toList(nums));
                }
            }
        }
        return new ArrayList<>(rez);
    }

    class Three {
        int a, b, c;

        List<Integer> toList(int[] nums){
            Integer[] ints = {nums[a], nums[b], nums[c]};
            Arrays.sort(ints);
            return Arrays.asList(ints);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Three three = (Three) o;
            return a == three.a && b == three.b && c == three.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b, c);
        }
    }
}
