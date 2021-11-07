package com.codewars.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 10.06.2021
 * <p>
 * Given the availability time slots arrays slots1 and slots2 of two people and a meeting duration,
 * return the earliest time slot that works for both of them and is of duration.
 * <p>
 * If there is no common time slot that satisfies the requirements,
 * return an empty array.
 * <p>
 * Example 1
 * Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
 * Output: [60,68]
 * <p>
 * Example 2
 * Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
 * Output: []
 */
public class MeetingScheduler {

    public static void main(String[] args) {
        MeetingScheduler ms = new MeetingScheduler();

        List<Integer> integers = ms.minAvailableDuration(new int[][]{
                        {10, 50},
                        {60, 120},
                        {140, 210}},
                new int[][]{
                        {0, 15},
                        {60, 70}
                }, 8);
        System.out.println(integers); // 60,68

        List<Integer> integer2 = ms.minAvailableDuration(new int[][]{
                        {10, 50},
                        {60, 120},
                        {140, 210}},
                new int[][]{
                        {0, 15},
                        {60, 70}
                }, 12);
        System.out.println(integer2); // []
    }

    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {

        Arrays.sort(slots1, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(slots2, Comparator.comparingInt(a -> a[0]));

        int firstPointer = 0;
        int secondPointer = 0;

        while (firstPointer < slots1.length && secondPointer < slots2.length) {
            int[] firstInterval = slots1[firstPointer];
            int[] secondInterval = slots2[secondPointer];

            int startInterval = Math.max(firstInterval[0], secondInterval[0]);
            int endInterval = Math.min(firstInterval[1], secondInterval[1]);

            if (endInterval - startInterval >= duration) {
                return List.of(startInterval, startInterval + duration);
            } else if (firstInterval[1] < secondInterval[1]) {
                firstPointer++;
            } else if (firstInterval[1] > secondInterval[1]) {
                secondPointer++;
            } else {
                firstPointer++;
                secondPointer++;
            }
        }

        return new ArrayList<>();
    }

}
