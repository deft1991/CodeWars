package com.codewars.leetcode.problems.medium;

/**
 * @author Sergey Golitsyn
 * created on 10.02.2021
 * <p>
 * In a N x N grid composed of 1 x 1 squares, each 1 x 1 square consists of a /, \, or blank space.  These characters divide the square into contiguous regions.
 * <p>
 * (Note that backslash characters are escaped, so a \ is represented as "\\".)
 * <p>
 * Return the number of regions.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * " /",
 * "/ "
 * ]
 * Output: 2
 * Explanation: The 2x2 grid is as follows:
 * <p>
 * Example 2:
 * <p>
 * Input:
 * [
 * " /",
 * "  "
 * ]
 * Output: 1
 * Explanation: The 2x2 grid is as follows:
 * <p>
 * Example 3:
 * <p>
 * Input:
 * [
 * "\\/",
 * "/\\"
 * ]
 * Output: 4
 * Explanation: (Recall that because \ characters are escaped, "\\/" refers to \/, and "/\\" refers to /\.)
 * The 2x2 grid is as follows:
 * <p>
 * Example 4:
 * <p>
 * Input:
 * [
 * "/\\",
 * "\\/"
 * ]
 * Output: 5
 * Explanation: (Recall that because \ characters are escaped, "/\\" refers to /\, and "\\/" refers to \/.)
 * The 2x2 grid is as follows:
 * <p>
 * Example 5:
 * <p>
 * Input:
 * [
 * "//",
 * "/ "
 * ]
 * Output: 3
 * Explanation: The 2x2 grid is as follows:
 */
public class RegionsCutBySlashes {

    public static void main(String[] args) {
        RegionsCutBySlashes r = new RegionsCutBySlashes();
        System.out.println(r.regionsBySlashes(new String[]{"\\/", "/\\"}));
        System.out.println(r.regionsBySlashes(new String[]{"/\\", "\\/"}));
    }

    public int regionsBySlashes(String[] grid) {
        int N = grid.length;
        DSU dsu = new DSU( 4 * N * N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char c = grid[i].charAt(j);

                int root = 4 * (i * N + j); // это верхний элемент разделенной клетки
                int left = root + 1;
                int bottom = root + 2;
                int right = root + 3;
                if (c == ' ') {
                    dsu.union(root, left);
                    dsu.union(root, right);
                    dsu.union(root, bottom);
                } else if (c == '\\') {
                    dsu.union(root, right);
                    dsu.union(left, bottom);
                } else if (c == '/') {
                    dsu.union(root, left);
                    dsu.union(bottom, right);
                }

                if (i - 1 >= 0) {
                    dsu.union(root, (root - 4 * N) + 2);
                }
                if (j + 1 < N) {
                    dsu.union(right, right + 2);
                }

            }
        }
        return dsu.regions;
    }

    class DSU {
        private int[] arr;
        private int regions;

        DSU(int N) {
            arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = i;
            }
            regions = N;
        }

        private void union(int i, int j) {
            int rootI = root(i);
            int rootJ = root(j);
            if (rootI != rootJ) {
                regions--;
            }


            arr[rootI] = rootJ;
        }

        private int root(int j) {
            while (j != arr[j]) {
                arr[j] = arr[arr[j]];
                j = arr[j];
            }
            return j;
        }
    }
}
