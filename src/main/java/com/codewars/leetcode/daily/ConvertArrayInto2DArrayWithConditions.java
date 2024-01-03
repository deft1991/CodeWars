package com.codewars.leetcode.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 03.01.2024
 */
public class ConvertArrayInto2DArrayWithConditions {

    public static void main(String[] args) {
        ConvertArrayInto2DArrayWithConditions c = new ConvertArrayInto2DArrayWithConditions();
        List<List<Integer>> matrix = c.findMatrix(new int[]{1, 3, 4, 1, 2, 3, 1});
        for (List<Integer> l : matrix){
            System.out.println(Arrays.toString(l.toArray()));
        }
    }

    public List<List<Integer>> findMatrix(int[] nums) {
        int[] freq = new int[nums.length];

        List<List<Integer>> rez = new ArrayList<>();

        for (int num : nums) {
            if (freq[num] >= rez.size()) {
                rez.add(new ArrayList<>());
            }
            rez.get(freq[num]).add(num);
            freq[num]++;
        }
        return rez;
    }
}
