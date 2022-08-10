package com.codewars.leetcode.days14;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 23.02.2022
 */
public class Combinations {

    public static void main(String[] args) {
        Combinations c = new Combinations();
        c.combine(4,2);
    }

    static List<List<Integer>> list;
    static List<Integer> temp;

    public List<List<Integer>> combine(int n, int k) {
        list = new ArrayList<>();
        temp = new ArrayList<>();
        combination(1, n, k);
        return list;

    }

    void combination(int c, int n, int k) {

    }
}
