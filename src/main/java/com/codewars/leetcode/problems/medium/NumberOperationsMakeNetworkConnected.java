package com.codewars.leetcode.problems.medium;

/**
 * @author Sergey Golitsyn
 * created on 23.04.2021
 */
public class NumberOperationsMakeNetworkConnected {

    public static void main(String[] args) {
        NumberOperationsMakeNetworkConnected n = new NumberOperationsMakeNetworkConnected();

        System.out.println(n.makeConnected(4, new int[][]{{0, 1}, {0, 2}, {1, 2}}));
        System.out.println(n.makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}}));
        System.out.println(n.makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}}));
        System.out.println(n.makeConnected(5, new int[][]{{0, 1}, {0, 2}, {3, 4}, {2, 3}}));
        System.out.println(n.makeConnected(12, new int[][]{{1, 5}, {1, 7}, {1, 2}, {1, 4}, {3, 7}, {4, 7}, {3, 5}, {0, 6}, {0, 1}, {0, 4}, {2, 6}, {0, 3}, {0, 2}}));
    }


    public int makeConnected(int n, int[][] connections) {
        int count = 0;
        int components = 0;
        UF uf = new UF(n);

        for (int[] connection : connections) {
            int a = connection[0];
            int b = connection[1];

            if (uf.isConnected(a, b)) {
                count++;
            } else {
                uf.connect(a, b);
            }
        }

        for (int i = 0; i < n; i++) {
            if (uf.parent[i] == i) {
                components++;
            }
        }

        return (count >= components - 1) ? components - 1 : -1;
    }

    static class UF {
        int[] parent;

        UF(int N) {
            parent = new int[N];

            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }
        }

        public boolean isConnected(int a, int b) {
            return root(a) == root(b);
        }

        private int root(int a) {
            while (a != parent[a]) {
                parent[a] = parent[parent[a]];
                a = parent[a];
            }
            return a;
        }

        public void connect(int a, int b) {
            int rootA = root(a);
            int rootB = root(b);

            parent[rootA] = rootB;
        }
    }
}
