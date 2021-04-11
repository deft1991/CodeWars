package com.codewars.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 08.04.2021
 */
public class AllPathsFromSourceToTarget {

    public static void main(String[] args) {
        AllPathsFromSourceToTarget a = new AllPathsFromSourceToTarget();


        a.allPathsSourceTarget(new int[][]{
                {1, 2},
                {3},
                {3},
                {}
        });

        System.out.println();
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> rez = new ArrayList<>();

        int N = graph.length - 1;

        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(path, rez, 0, graph, N);
        return rez;
    }

    private void dfs(List<Integer> path, List<List<Integer>> rez, int curIdx, int[][] graph, int N) {

        if (curIdx == N) {
            rez.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < graph[curIdx].length; i++) {
            path.add(graph[curIdx][i]);
            dfs(path, rez, graph[curIdx][i], graph, N);
            path.remove(path.size() - 1);
        }
    }


}
