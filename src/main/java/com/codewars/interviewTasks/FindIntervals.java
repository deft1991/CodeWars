package com.codewars.interviewTasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 25.01.2021
 * <p>
 * Найти все непрерывные интервалы и напечатать их.
 * Непрерывным считается интервал,
 * где каждое последующее число больше предыдущего на 1.
 * <p>
 * Пример 1:
 * [3, 7, 9, 2, 4, 1, 6]
 * 1-4, 6-7, 9
 * <p>
 * Пример 2:
 * [2, 3, 4, 5]
 * 2-5
 * <p>
 * Пример 3:
 * [1, 9]
 * 1,9
 * <p>
 * <p>
 * [1,2]
 * 1-2
 */
public class FindIntervals {

    public static void main(String[] args) {
        System.out.println(printIntervals(new int[]{3, 7, 9, 2, 4, 1, 6}));
    }

    public static String printIntervals(int[] arr) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        Arrays.sort(arr);

        for (int current : arr) {
            if (map.containsKey(current)) {
                List<Integer> integers = map.get(current);
                integers.add(current);
                map.put(current, integers);

            } else if (map.containsKey(current - 1)) {
                List<Integer> integers = map.get(current - 1);
                integers.add(current);

                map.remove(current - 1);
                map.put(current, integers);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(current);
                map.put(current, list);
            }
        }

        String rez = "";
        for (List<Integer> list : map.values()) {

            if (list.size() == 1) {
                rez += ", " + list.get(0);
            } else {
                rez += ", " + list.get(0) + "-" + list.get(list.size() - 1);
            }
        }

        return rez.substring(1);
    }
}
