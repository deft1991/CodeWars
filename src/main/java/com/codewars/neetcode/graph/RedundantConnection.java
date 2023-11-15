package com.codewars.neetcode.graph;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 02.11.2023
 */
public class RedundantConnection {

    public static void main(String[] args) {
        RedundantConnection r = new RedundantConnection();
        System.out.println(Arrays.toString(r.findRedundantConnection(new int[][]{
                {1,2},
                {1,3},
                {2,3},
        })));
        System.out.println(Arrays.toString(r.findRedundantConnection(new int[][]{
                {1,2},
                {2,3},
                {3,4},
                {1,4},
                {1,5},
        })));
    }

    public int[] findRedundantConnection(int[][] edges) {
        int[] arr = new int[edges.length + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int[] pair : edges) {
            int a = pair[0];
            int b = pair[1];

            if (union(a, b, arr)) {

            } else {
                int[] rez = new int[2];
                rez[0] = a;
                rez[1] = b;
                return rez;
            }
        }
        return new int[0];
    }

    private boolean union(int a, int b, int[] arr) {
        int parA = getParent(a, arr);
        int parB = getParent(b, arr);

        if (parA == parB) {
            return false;
        }
        arr[parB] = parA;
        return true;
    }

    private int getParent(int x, int[] arr) {
        while (x != arr[x]) {
            arr[x] = arr[arr[x]];
            x = arr[x];
        }
        return x;
    }
}
