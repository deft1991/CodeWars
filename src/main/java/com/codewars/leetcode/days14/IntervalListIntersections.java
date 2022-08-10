package com.codewars.leetcode.days14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 13.03.2022
 */
public class IntervalListIntersections {

    public static void main(String[] args) {
        IntervalListIntersections i = new IntervalListIntersections();
        System.out.println(Arrays.deepToString(i.intervalIntersection(new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}}, new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}})));
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        int firstReader = 0;
        int secondReader = 0;
        List<List<Integer>> rez = new ArrayList<>();


        while (firstReader < firstList.length && secondReader < secondList.length) {
            int[] first = firstList[firstReader];
            int[] second = secondList[secondReader];
            int a = -1;
            int b = -1;
            if (first[0] <= second[0]) {
                if (first[1] < second[0]) {
                    firstReader++;
                } else if (first[1] > second[1]) {
                    a = second[0];
                    b = second[1];
                    secondReader++;
                } else {
                    a = second[0];
                    b = first[1];
                    firstReader++;
                }

            } else { // second[0] <= first[0]
                if (second[1] < first[0]) {
                    secondReader++;
                } else if (second[1] < first[1]) {
                    a = first[0];
                    b = second[1];
                    secondReader++;
                } else {
                    a = first[0];
                    b = first[1];
                    firstReader++;
                }
            }
            if (a != -1 && b != -1) {
                rez.add(List.of(a, b));
            }
        }

        int[][] reaArr = new int[rez.size()][2];

        for (int i = 0; i < rez.size(); i ++){
            int[] tmp = new int[2];
            tmp[0] = rez.get(i).get(0);
            tmp[1] = rez.get(i).get(1);
            reaArr[i] = tmp;
        }


        return reaArr;
    }
}
