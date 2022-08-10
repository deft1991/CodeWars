package com.codewars.leetcode.days14;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 24.02.2022
 */
public class Combinations2 {

    public static void main(String[] args) {
        Combinations2 c = new Combinations2();
        c.combine(4, 2);
    }

    private List<List<Integer>> rez;
    private List<Integer> current;

    public List<List<Integer>> combine(int n, int k) {
        rez = new ArrayList<>();
        current = new ArrayList<>();
        combine(1, n, k);

        return rez;
    }

    public void combine(int a, int num, int numbersCount) {
        if (numbersCount == 0) {
            List<Integer> tmp = new ArrayList<>(current);
            rez.add(tmp);
        } else {
            if (a > num){
                return;
            }

            for (int i = a; i <= num; i++) {
                current.add(i);
                combine(i + 1, num, numbersCount - 1);
                current.remove(current.size() - 1);
            }
        }
    }
}
