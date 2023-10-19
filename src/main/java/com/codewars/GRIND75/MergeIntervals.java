package com.codewars.GRIND75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 20.09.2023
 */
public class MergeIntervals {

    public static void main(String[] args) {
        MergeIntervals m = new MergeIntervals();
        int[][] merge = m.merge(new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        });
        System.out.println();
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] current = intervals[0];
        List<int[]> rez = new ArrayList<>();
        for(int i = 1; i < intervals.length; i++){
            int[] tmp = intervals[i];
            if(isIntersect(current, intervals[i])){
                current[0] = Math.min(current[0], tmp[0]);
                current[1] = Math.max(current[1], tmp[1]);
            } else {
                rez.add(current);
                current = intervals[i];
            }
        }
        rez.add(current);
        int[][] arr = new int[rez.size()][2];
        return rez.toArray(arr);
    }

    private boolean isIntersect(int[] a, int[] b) {
        if(a[0] <= b[0] && a[1] >= b[0]){
            return true;
        }
        if(b[0] <= a[0] && b[1] >= a[0]){
            return true;
        }
        return false;
    }
}
