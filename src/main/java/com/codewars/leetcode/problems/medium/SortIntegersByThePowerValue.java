package com.codewars.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Sergey Golitsyn
 * created on 12.04.2021
 */
public class SortIntegersByThePowerValue {

    public static void main(String[] args) {
        SortIntegersByThePowerValue s = new SortIntegersByThePowerValue();

//        System.out.println(s.getKth(12, 15, 2)); // 13
//        System.out.println(s.getKth(1, 1, 1)); // 13
//        System.out.println(s.getKth(7, 11, 4)); // 7
//        System.out.println(s.getKth(10, 20, 5)); // 13
        System.out.println(s.getKth(1, 1000, 777)); // 570
//        System.out.println(s.getKth2(1, 1000, 777)); // 570
    }

    public int getKth(int lo, int hi, int k) {

        List<Integer> powers = new ArrayList<>(hi - lo + 1);
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = lo; i <= hi; i++) {
            int power = power(i);
            powers.add(power);
            map.computeIfAbsent(power, x -> new ArrayList<>()).add(0, i);
        }

        Collections.sort(powers);

        Integer integer = powers.get(k - 1);
        List<Integer> collect = map.values().stream().flatMap(integers -> integers.stream()).collect(Collectors.toList());
        return map.get(integer).get(0);
    }

    private int power(int i) {
        int count = 0;

        while (i != 1) {
            if (i % 2 == 0) {
                i /= 2;
            } else {
                i = 3 * i + 1;
            }
            count++;
        }

        return count;
    }

    private Map<Integer, Integer> map = new HashMap<>();

    {
        map.put(1, 0);
    }

    public int getKth2(int lo, int hi, int k) {

        List<Pair> powers = new ArrayList<>();

        for (int i = 1; i <= hi; i++) {
            getPower(i);

            if (i >= lo) {
                powers.add(new Pair(i, map.getOrDefault(i, 0)));
            }
        }

        powers.sort((p1, p2) -> p1.value == p2.value ? p1.key - p2.key : p1.value - p2.value);

        return powers.get(k-1).key;
    }

    private int getPower(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        int r = n % 2 == 0 ? getPower(n / 2) : getPower(3 * n + 1);
        map.put(n, r + 1);

        return map.get(n);
    }

    class Pair {
        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}
