package com.codewars.leetcode.daily;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 10.11.2023
 */
public class RestoreArrayFromAdjacentPairs {

    public static void main(String[] args) {
        RestoreArrayFromAdjacentPairs r = new RestoreArrayFromAdjacentPairs();
        System.out.println(Arrays.toString(r.restoreArray(new int[][]{
                {2, 1},
                {3, 4},
                {3, 2},
        })));
        System.out.println(Arrays.toString(r.restoreArray(new int[][]{
                {4, -2},
                {1, 4},
                {-3, 1},
        })));
    }

    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] pair : adjacentPairs) {
            int x = pair[0];
            int y = pair[1];

            if (!graph.containsKey(x)) {
                graph.put(x, new ArrayList<>());
            }
            if (!graph.containsKey(y)) {
                graph.put(y, new ArrayList<>());
            }

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        int root = 0;
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            if (entry.getValue().size() == 1) {
                root = entry.getKey();
                break;
            }
        }

        int[] rez = new int[graph.size()];

        dfs(root, Integer.MAX_VALUE, 0, rez, graph);

        return rez;
    }

    private void dfs(int node, int neighbour, int position, int[] arr, Map<Integer, List<Integer>> graph) {
        arr[position] = node;

        for (int next : graph.get(node)) {
            if (neighbour != next) {
                dfs(next, node, position + 1, arr, graph);
            }
        }
    }
}
