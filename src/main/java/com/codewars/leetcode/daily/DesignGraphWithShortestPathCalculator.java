package com.codewars.leetcode.daily;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 11.11.2023
 */
public class DesignGraphWithShortestPathCalculator {

    public static void main(String[] args) {
        Graph g = new Graph(4, new int[][]{
                {0, 2, 5},
                {0, 1, 2},
                {1, 2, 1},
                {3, 0, 3},
        });
        System.out.println( g.shortestPath(3, 2));
        System.out.println( g.shortestPath(0, 3));
        g.addEdge(new int[]{1,3,4});
        System.out.println( g.shortestPath(0, 3));

    }

    static class Graph {

        private List<List<Pair>> adjList;

        public Graph(int n, int[][] edges) {
            adjList = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                adjList.get(edge[0]).add(new Pair(edge[1], edge[2]));
            }
        }

        public void addEdge(int[] edge) {
            adjList.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }

        public int shortestPath(int node1, int node2) {
            int n = adjList.size();
            int[] costForNode = new int[n];
            Arrays.fill(costForNode, Integer.MAX_VALUE);

            PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
            pq.add(new Pair(node1, 0));

            while (!pq.isEmpty()) {
                Pair p = pq.poll();
                int curNode = p.node;
                int curCost = p.val;

                if (curCost > costForNode[curNode]) {
                    continue;
                }
                if (curNode == node2) {
                    return curCost;
                }

                for (int i = 0; i < adjList.get(curNode).size(); i++) {
                    Pair neighbour = adjList.get(curNode).get(i);

                    int newCost = curCost + neighbour.val;

                    if (newCost < costForNode[neighbour.node]) {
                        costForNode[neighbour.node] = newCost;
                        pq.add(new Pair(neighbour.node, newCost));
                    }

                }


            }
            return -1;
        }
    }

    record Pair(int node, int val) {
    }
}
