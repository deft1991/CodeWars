package com.codewars.leetcode.problems.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 08.02.2021
 */
public class RedundantConnection {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        RedundantConnection r = new RedundantConnection();
        System.out.println(Arrays.toString(r.findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}})));
    }

    public int[] findRedundantConnection(int[][] edges) {

        int[] arr = new int[edges.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        int[] rez = new int[2];
        for (int[] edge : edges) {
            if (edge[0] != edge[1]) {
                if (isConnected(arr, edge[0] - 1, edge[1] - 1)) {
                    if (edge[0] < edge[1]) {
                        rez[0] = edge[0];
                        rez[1] = edge[1];
                    } else {
                        rez[0] = edge[1];
                        rez[1] = edge[0];
                    }
                } else {
                    connect(arr, edge[0] - 1, edge[1] - 1);
                }
            }
        }
        return rez;
    }

    private boolean isConnected(int[] arr, int i, int j) {
        return root(arr, i) == root(arr, j);
    }

    private int root(int[] arr, int elem) {
        while (elem != arr[elem]) {
            arr[elem] = arr[arr[elem]];
            elem = arr[elem];
        }
        return elem;
    }

    private void connect(int[] arr, int i, int j) {
        int rootI = root(arr, i);
        int rootJ = root(arr, j);
        arr[rootJ] = rootI;
    }
}
