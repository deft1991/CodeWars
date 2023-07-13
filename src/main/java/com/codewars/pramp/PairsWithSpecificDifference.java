package com.codewars.pramp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Sergey Golitsyn
 * created on 01.02.2023
 * <p>
 * Given an array arr of distinct integers and a nonnegative integer k,
 * write a function findPairsWithGivenDifference that returns an array of all pairs [x,y] in arr,
 * such that x - y = k. If no such pairs exist, return an empty array.
 * Note: the order of the pairs in the output array should maintain the order of the y element in the original array.
 * Examples:
 * input:  arr = [0, -1, -2, 2, 1], k = 1
 * output: [[1, 0], [0, -1], [-1, -2], [2, 1]]
 * input:  arr = [1, 7, 5, 3, 32, 17, 12], k = 17
 * output: []
 */
public class PairsWithSpecificDifference {

    public static void main(String[] args) {
        PairsWithSpecificDifference p = new PairsWithSpecificDifference();
        int[][] pairsWithGivenDifference = p.findPairsWithGivenDifference(new int[]{0, -1, -2, 2, 1}, 1);
        System.out.println();
    }

    static int[][] findPairsWithGivenDifference(int[] arr, int k) {
        /*
        x - y = k
        - y = k - x -->
        y = x - k

        x = y + k
         */
        Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        Set<Integer> map = new HashSet<>();
        for (int y : arr) {
            int x = y + k;
            if (set.contains(x)) {
                map.add(x);
            }
        }

        int[][] rez = new int[map.size()][2];
        int i = 0;
        for (int y : arr) {
            if (set.contains(y + k)) {
                rez[i][0] = y + k;
                rez[i][1] = y;
                i++;
            }
        }
        return rez;
    }
}
