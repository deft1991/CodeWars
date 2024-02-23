package com.codewars.leetcode.daily;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 23.02.2024
 */
public class CheapestFlightsWithinKStops {

    public static void main(String[] args) {
        CheapestFlightsWithinKStops c = new CheapestFlightsWithinKStops();
        System.out.println(c.findCheapestPrice(4, new int[][]{
                {0,1,100}, {1,2,100}, {2,0,100}, {1,3,600}, {2,3,200}
        }, 0, 3, 1));

        System.out.println(c.findCheapestPrice(3, new int[][]{
                {0,1,100}, {1,2,100}, {0,2,500}
        }, 0, 2, 1));

        System.out.println(c.findCheapestPrice(3, new int[][]{
                {0,1,100}, {1,2,100}, {0,2,500}
        }, 0, 2, 0));
    }

    int curCost;
    int minCost;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if (src == dst) {
            return 0;
        }
        Map<Integer, List<Pair>> graph;
        Set<Integer> visited = new HashSet<>();
        curCost = 0;
        minCost = Integer.MAX_VALUE;
        graph = buildGraph(flights);
        dfs(graph, src, dst, k, visited);
        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }

    record Pair(int to, int cost) {
    }

    private Map<Integer, List<Pair>> buildGraph(int[][] flights) {
        Map<Integer, List<Pair>> graph = new HashMap<>();
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int cost = flight[2];
            graph.computeIfAbsent(from, el -> new ArrayList<>()).add(new Pair(to, cost));
        }
        return graph;
    }

    private void dfs(Map<Integer, List<Pair>> graph, int cur, int dst, int k, Set<Integer> visited) {
        if (cur == dst) {
            minCost = Math.min(minCost, curCost);
            return;
        }
        if (k < 0) {
            return;
        }
        if (!graph.containsKey(cur)) {
            return;
        }

        for (Pair p : graph.get(cur)) {
            if (!visited.contains(p.to)) {
                visited.add(p.to);
                curCost += p.cost;
                dfs(graph, p.to, dst, k - 1, visited);
                curCost -= p.cost;
                visited.remove(p.to);
            }
        }
    }
}
