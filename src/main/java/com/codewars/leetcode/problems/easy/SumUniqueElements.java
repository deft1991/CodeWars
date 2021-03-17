package com.codewars.leetcode.problems.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Sergey Golitsyn
 * created on 12.03.2021
 */
public class SumUniqueElements {

    public static void main(String[] args) {
        SumUniqueElements s = new SumUniqueElements();
        System.out.println(s.sumOfUnique(new int[]{1,2,3,2}));
        System.out.println(s.sumOfUnique(new int[]{1,1,1,1,1}));
        System.out.println(s.sumOfUnique(new int[]{1,2,3,4,5}));
    }

    public int sumOfUnique(int[] nums) {
        int[] freq = new int[101];
        for(int num: nums)
            freq[num]++;

        int count = 0;

        for(int n: nums){
            if(freq[n]==1) count += n;
        }

        return count;
    }
}
