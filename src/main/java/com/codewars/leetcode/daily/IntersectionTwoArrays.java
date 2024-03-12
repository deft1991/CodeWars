package com.codewars.leetcode.daily;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Sergey Golitsyn
 * created on 10.03.2024
 */
public class IntersectionTwoArrays {

    public static void main(String[] args) {
        IntersectionTwoArrays i = new IntersectionTwoArrays();
        System.out.println(Arrays.toString(i.intersection(new int[]{1,2,2,1}, new int[]{2,2})));
        System.out.println(Arrays.toString(i.intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> one = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> rez = new HashSet<>();

        for(int i : nums2){
            if (one.contains(i)){
                rez.add(i);
            }
        }

        return rez.stream().mapToInt(el -> el).toArray();
    }
}
