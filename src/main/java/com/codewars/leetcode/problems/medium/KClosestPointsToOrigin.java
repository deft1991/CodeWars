package com.codewars.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 24.02.2021
 */
public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        KClosestPointsToOrigin k = new KClosestPointsToOrigin();
        int[][] ints = k.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1);
        int[][] ints1 = k.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2);
        int[][] ints2 = k.kClosest(new int[][]{{0, 1}, {1, 0}}, 2);
        System.out.println();
    }

    /**
     * Distance between points sqrt((x2 - x1)2 + (y2 - y1)2)
     */
    public int[][] kClosest(int[][] points, int K) {
        double[] distances = new double[points.length];

        int[][] rez = new int[K][2];

        Map<Double, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            double distance = Math.pow(point[0], 2) + Math.pow(point[1], 2);
            distances[i] = distance;
            List<Integer> orDefault = map.getOrDefault(distance, new ArrayList<>());
            orDefault.add(i);
            map.put(distance, orDefault);
        }

        mergeSort(distances);
        int count = K;
        for (int i = 0; i < count;) {
            List<Integer> integers = map.get(distances[i]);
            for (Integer idx : integers) {
                if (K > 0) {
                    rez[i++] = points[idx];
                    K--;
                }
            }
        }

        return rez;
    }

    private void mergeSort(double[] distances) {
        int n = distances.length;
        double[] aux = new double[n];
        sort(distances, aux, 0, n - 1);
    }

    private void sort(double[] distances, double[] aux, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int mid = lo + (hi - lo) / 2;

        sort(distances, aux, lo, mid);
        sort(distances, aux, mid + 1, hi);
        merge(distances, aux, lo, mid, hi);
    }

    private void merge(double[] distances, double[] aux, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            aux[i] = distances[i];
        }

        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                distances[k] = aux[j++];
            } else if (j > hi) {
                distances[k] = aux[i++];
            } else if (aux[i] < aux[j]) {
                distances[k] = aux[i++];
            } else {
                distances[k] = aux[j++];
            }
        }
    }
}
