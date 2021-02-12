package com.codewars.leetcode.problems.medium;

/**
 * @author Sergey Golitsyn
 * created on 12.02.2021
 * <p>
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * <p>
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * <p>
 * Example:
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Explanation:
 * <p>
 * Surrounded regions shouldn’t be on the border,
 * which means that any 'O' on the border of the board are not flipped to 'X'.
 * Any 'O' that is not on the border and it
 * is not connected to an 'O' on the border will be flipped to 'X'.
 * Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
public class SurroundedRegions {

    public static void main(String[] args) {
        SurroundedRegions s = new SurroundedRegions();
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
//        s.solve(board);
//        System.out.println();

        board = new char[][]{
                {'O', 'O', 'O'},
                {'O', 'O', 'O'},
                {'O', 'O', 'O'},
        };
        s.solve(board);
        System.out.println();

        /*
        Expected

        [['O','X','X','O','X'],
        ['X','X','X','X','O'],
        ['X','X','X','O','X'],
        ['O','X','O','O','O'],
        ['X','X','O','X','O']]
         */
        board = new char[][]{
                {'O', 'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'X', 'O', 'X'},
                {'O', 'X', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'O'}
        };
        s.solve(board);
        System.out.println();

        /**
         [['X','O','X','O','X','O'],
         ['O','X','X','X','X','X'],
         ['X','X','X','X','X','O'],
         ['O','X','O','X','O','X']]
         */
        board = new char[][]{
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'}
        };
        s.solve(board);
        System.out.println();

        /**
         [['O','O','O','O','X','X'],
         ['O','O','O','O','O','O'],
         ['O','X','O','X','O','O'],
         ['O','X','O','O','X','O'],
         ['O','X','O','X','O','O'],
         ['O','X','O','O','O','O']]
         */
        board = new char[][]{
                {'X', 'O', 'X', 'X'},
                {'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X'}};
        s.solve(board);
        System.out.println();
    }

    public void solve(char[][] board) {

        int n = board.length;
        if (n < 3) {
            return;
        }

        int m = board[0].length;
        if (m < 3) {
            return;
        }

        int N = n * m;
        DSU dsu = new DSU(N);

        checkLeftAndRight(board, n, m, dsu);

        checkTopAndBottom(board, n, m, dsu);

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (board[i][j] == 'O') {
                    if (board[i - 1][j] == 'O') {
                        dsu.union(m * (i - 1) + j, m * i + j);
                    }

                    if (board[i][j - 1] == 'O') {
                        dsu.union(m * i + j - 1, m * i + j);
                    }
                }
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                if (board[i][j] == 'O' && dsu.root(i * m + j) != -1)
                    board[i][j] = 'X';
            }
        }
    }

    /**
     * check to and bottom
     */
    private void checkTopAndBottom(char[][] board, int n, int m, DSU dsu) {
        for (int i = 0; i < m; i++) {
            //top line
            if (board[0][i] == 'O') {
                dsu.parent[i] = -1;
                if (board[1][i] == 'O') {
                    dsu.union(i, m - 1 + i);
                }
            }
            // bottom line
            if (board[n - 1][i] == 'O') {
                dsu.parent[m * (n - 1) + i] = -1;

                if (board[n - 2][i] == 'O') {
                    dsu.union(m * (n - 1) + i, m * (n - 2) + i);
                }
            }
        }
    }

    /**
     * check top and bottom
     */
    private void checkLeftAndRight(char[][] board, int n, int m, DSU dsu) {

        for (int i = 0; i < n; i++) {
            // left
            if (board[i][0] == 'O') {
                dsu.parent[m * i] = -1;

                if (board[i][1] == 'O') {
                    dsu.union(m * i, m * i + 1);
                }
            }
            // right
            if (board[i][m - 1] == 'O') {
                dsu.parent[m * i + m - 1] = -1;

                if (board[i][m - 2] == 'O') {
                    dsu.union(m * i + m - 1, m * i + m - 2);
                }
            }

        }
    }


    class DSU {
        private int[] parent;

        DSU(int N) {
            parent = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }
        }

        // returns true if the node are already connected
        private void union(int i, int j) {
            int rootI = root(i);
            int rootJ = root(j);
            if (rootI == rootJ)
                return;
            if (rootI == -1)
                parent[rootJ] = -1;
            else
                parent[rootI] = rootJ;
        }

        private int root(int i) {
            while (i != -1 && parent[i] != -1 && parent[i] != i) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }

            if (i == -1 || parent[i] == -1)
                return -1;

            return i;
        }
    }
}
