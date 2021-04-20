package com.codewars.leetcode.problems.medium;

/**
 * @author Sergey Golitsyn
 * created on 19.04.2021
 */
public class IsGraphBipartite {

    public static void main(String[] args) {
        IsGraphBipartite is = new IsGraphBipartite();

        System.out.println(is.isBipartite(new int[][]{
                {1, 2, 3},
                {0, 2},
                {0, 1, 3},
                {0, 2}}));

//        System.out.println(is.isBipartite(new int[][]{
//                {1, 3},
//                {0, 2},
//                {1, 3},
//                {0, 2}}));
    }

    public boolean isBipartite(int[][] graph) {
        UF uf = new UF(graph.length);

        for (int i = 0; i < graph.length; i++) {
            int[] vertex = graph[i];

            for (int k : vertex) {
                if (uf.isConnect(i, k)) {
                    return false;
                } else {
                    uf.connect(vertex[0], k);
                }
            }
        }

        return true;
    }

    static class UF {
        int[] parent;

        UF(int N) {
            parent = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }
        }

        public boolean isConnect(int a, int b) {
            return root(a) == root(b);
        }

        public void connect(int a, int b) {
            int rootA = root(a);
            int rootB = root(b);

            parent[rootA] = rootB;
        }

        private int root(int a) {
            if (parent[a] == a) {
                return parent[a];
            }
            parent[a] = root(parent[a]);
            return parent[a];
        }
    }
}
