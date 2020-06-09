package com.codewars.leetcode.handbook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
 * Created by sgolitsyn on 6/8/20
 */
public class MergeIntervals {

    public static void main(String[] args) {
//        0,4
//        Arrays.stream(merge(new int[][]{{1, 4}, {0, 2}})).forEach(arr -> System.out.println(Arrays.toString(arr)));
        // 4,5
//        Arrays.stream(merge(new int[][]{{1, 4}, {4, 5}})).forEach(arr -> System.out.println(Arrays.toString(arr)));
        // 1,10
        Arrays.stream(merge(new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}})).forEach(arr -> System.out.println(Arrays.toString(arr)));
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1){
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int[] cur = intervals[0];
        ArrayList<int[]> rez = new ArrayList<>();

        for (int i = 1; i< intervals.length; i++){

            if(isConnected(intervals[i], cur)){
                if (intervals[i][1] > cur[1]){
                    cur[1] = intervals[i][1];
                }
                if (intervals[i][0] < cur[0]){
                    cur[0] = intervals[i][0];
                }
            } else {
                rez.add(cur);
                cur = intervals[i];
            }
        }
        rez.add(cur);

        int[][] forReturn = new int [rez.size()][];
        return rez.toArray(forReturn);
    }

    // 1,5     2,8
    // 1,4     0, 2
    private static boolean isConnected(int[] interval, int[] current) {
        return (interval[0] >= current[0] && interval[0] <= current[1])
                ||

                (interval[0] == current[0] && interval[1] >= current[0]);

    }
}
