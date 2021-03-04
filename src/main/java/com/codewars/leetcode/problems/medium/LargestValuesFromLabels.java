package com.codewars.leetcode.problems.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 24.02.2021
 * <p>
 * We have a set of items: the i-th item has value values[i] and label labels[i].
 * <p>
 * Then, we choose a subset S of these items, such that:
 * <p>
 * |S| <= num_wanted
 * For every label L, the number of items in S with label L is <= use_limit.
 * Return the largest possible sum of the subset S.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: values = [5,4,3,2,1], labels = [1,1,2,2,3], num_wanted = 3, use_limit = 1
 * Output: 9
 * Explanation: The subset chosen is the first, third, and fifth item.
 * Example 2:
 * <p>
 * Input: values = [5,4,3,2,1], labels = [1,3,3,3,2], num_wanted = 3, use_limit = 2
 * Output: 12
 * Explanation: The subset chosen is the first, second, and third item.
 * Example 3:
 * <p>
 * Input: values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 1
 * Output: 16
 * Explanation: The subset chosen is the first and fourth item.
 * Example 4:
 * <p>
 * Input: values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 2
 * Output: 24
 * Explanation: The subset chosen is the first, second, and fourth item.
 */
public class LargestValuesFromLabels {

    public static void main(String[] args) {
        LargestValuesFromLabels lv = new LargestValuesFromLabels();

//        System.out.println(lv.largestValsFromLabels(new int[] {5,4,3,2,1}, new int[] {1,1,2,2,3}, 3, 1));
        System.out.println(lv.largestValsFromLabels(new int[]{1, 2, 3, 4, 5}, new int[]{1, 1, 2, 2, 3}, 3, 1));
    }

    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        int n = values.length;
        mergeSort(values, labels);

        Map<Integer, Integer> labelsCount = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int value = values[i];
            int label = labels[i];

            if (num_wanted > 0 && labelsCount.getOrDefault(label, 0) < use_limit) {
                labelsCount.put(label, labelsCount.getOrDefault(label, 0) + 1);
                count += value;
                num_wanted--;
            }
        }
        return count;
    }

    private void mergeSort(int[] values, int[] labels) {
        int hi = values.length - 1;
        int[] aux = new int[values.length];
        int[] auxLablel = new int[values.length];

        sort(values, aux, labels, auxLablel, 0, hi);
    }

    private void sort(int[] values, int[] aux, int[] labels, int[] auxLablel, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(values, aux, labels, auxLablel, lo, mid);
        sort(values, aux, labels, auxLablel, mid + 1, hi);
        merge(values, aux, labels, auxLablel, lo, mid, hi);
    }

    private void merge(int[] values, int[] aux, int[] labels, int[] auxLablel, int lo, int mid, int hi) {

        for (int i = lo; i <= hi; i++) {
            aux[i] = values[i];
            auxLablel[i] = labels[i];
        }
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                labels[k] = auxLablel[j];
                values[k] = aux[j++];
            } else if (j > hi) {
                labels[k] = auxLablel[i];
                values[k] = aux[i++];
            } else if (aux[i] < aux[j]) { // if change it we will have DESC sort
                labels[k] = auxLablel[j];
                values[k] = aux[j++];
            } else {
                labels[k] = auxLablel[i];
                values[k] = aux[i++];
            }
        }

    }
}
