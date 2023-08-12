package com.codewars.GRIND75;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 27.07.2023
 */
public class InsertInterval {

    public static void main(String[] args) {

    }

    /*

    1  5
      2  7

    3  8
   1  5

    3 8
   1    10
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        for (int[] current : intervals) {
            // lower than current
            if (current[0] > newInterval[1]) {
                result.add(newInterval);
                newInterval = current;
            } else if (current[1] < newInterval[0]) {
                result.add(current);
            } else {
                // intersection
                int start = Math.min(current[0], newInterval[0]);
                int end = Math.max(current[1], newInterval[1]);
                result.add(new int[]{start, end});
            }
        }

        int[][] rez = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++){
            rez[i] = result.get(i);
        }
        return rez;
    }
}
