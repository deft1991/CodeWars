package com.codewars.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 08.04.2021
 */
public class MinimumNumberVerticesToReachAllNodes {

    public static void main(String[] args) {
        MinimumNumberVerticesToReachAllNodes m = new MinimumNumberVerticesToReachAllNodes();

        System.out.println(Arrays.toString(getSmallestSetOfVertices(m).toArray()));
        System.out.println(Arrays.toString(getSmallestSetOfVertices2(m).toArray()));
    }

    private static List<Integer> getSmallestSetOfVertices(MinimumNumberVerticesToReachAllNodes m) {
        return m.findSmallestSetOfVertices2(6,
                List.of(
                        List.of(0, 1),
                        List.of(0, 2),
                        List.of(2, 5),
                        List.of(3, 4),
                        List.of(4, 2)));
    }

    private static List<Integer> getSmallestSetOfVertices2(MinimumNumberVerticesToReachAllNodes m) {
        return m.findSmallestSetOfVertices2(5,
                List.of(
                        List.of(0, 1),
                        List.of(2, 1),
                        List.of(3, 1),
                        List.of(1, 4),
                        List.of(2, 4)));
    }

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> rez = new ArrayList<>();
        // prepare matrix
        int[][] matrix = new int[n][n];

        for (List<Integer> list : edges) {
            int from = list.get(0);
            int to = list.get(1);

            matrix[from][to] = 1;
        }

        // check columns to find edges

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {

                if (matrix[j][i] == 1) {
                    count++;
                }
            }
            if (count == 0) {
                rez.add(i);
            }
        }
        return rez;
    }

    public List<Integer> findSmallestSetOfVertices2(int n, List<List<Integer>> edges) {
        List<Integer> rez = new ArrayList<>();
        // prepare inDegree array
        boolean[] inDegree = new boolean[n];

        for (List<Integer> list : edges) {
            int from = list.get(0);
            int to = list.get(1);

            inDegree[to] = true;
        }

        // check columns to find edges

        for (int i = 0; i < n; i++) {
            if (!inDegree[i]) {
                rez.add(i);
            }
        }
        return rez;
    }
}
