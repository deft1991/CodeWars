package com.codewars.leetcode.problems.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Sergey Golitsyn
 * created on 08.02.2021
 * <p>
 * There are n cities. Some of them are connected, while some are not.
 * If city a is connected directly with city b, and city b is connected directly with city c,
 * then city a is connected indirectly with city c.
 * <p>
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 * <p>
 * You are given an n x n matrix isConnected
 * where isConnected[i][j] = 1 if the ith city and the jth city are directly connected,
 * and isConnected[i][j] = 0 otherwise.
 * <p>
 * Return the total number of provinces.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 * Example 2:
 * <p>
 * <p>
 * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] is 1 or 0.
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 */
public class NumberOfProvinces {

    public static void main(String[] args) {

        NumberOfProvinces n = new NumberOfProvinces();
        System.out.println(n.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(n.findCircleNum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
        System.out.println(n.findCircleNum(new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}}));

    }

    public int findCircleNum(int[][] isConnected) {
        int[] arr = new int[isConnected.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1) {
                    if (i != j) {
                        if (!isConnect(arr, i, j)) {
                            connect(arr, i, j);
                        }
                    }
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i ++) {
            set.add(root(arr, i));
        }
        return set.size();
    }

    private void connect(int[] arr, int i, int j) {
        int rootI = root(arr, i);
        int rootJ = root(arr, j);
        arr[rootI] = rootJ;
    }

    private boolean isConnect(int[] arr, int i, int j) {

        return root(arr, i) == root(arr, j);
    }

    private int root(int[] arr, int elem) {
        int tmp = elem;
        while (tmp != arr[tmp]) {
            arr[tmp] = arr[arr[tmp]];
            tmp = arr[tmp];

        }
        return tmp;
    }
}
