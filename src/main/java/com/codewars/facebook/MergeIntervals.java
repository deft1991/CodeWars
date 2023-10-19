package com.codewars.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 17.08.2023
 */
public class MergeIntervals {

    public static void main(String[] args) {
        MergeIntervals m = new MergeIntervals();
        int[][] merge = m.merge(new int[][]{
                {2, 3},
                {4, 5},
                {6, 7},
                {8, 9},
                {1, 10}
        });
        System.out.println();
    }

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int[] currentInterval = intervals[0];
        List<Integer[]> rez = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];

            if (isIntersect(currentInterval, current)) {
                int a = Math.min(currentInterval[0], current[0]);
                int b = Math.max(currentInterval[1], current[1]);
                currentInterval = new int[]{a, b};
            } else {
                Integer[] tmp = new Integer[]{currentInterval[0], currentInterval[1]};
                rez.add(tmp);
                currentInterval = current;
            }
        }

        rez.add(new Integer[]{currentInterval[0], currentInterval[1]});
        int[][] rezArr = new int[rez.size()][2];
        int i = 0;
        for (Integer[] arr : rez) {
            int[] tmp = new int[]{arr[0], arr[1]};
            rezArr[i++] = tmp;
        }
        return rezArr;
    }

    private boolean isIntersect(int[] a, int[] b) {
        if (a[0] <= b[0] && a[1] >= b[0]) {
            return true;
        }
        if (b[0] <= a[0] && b[1] >= a[0]) {
            return true;
        }
        return false;
    }
}
