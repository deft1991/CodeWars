package com.codewars.neetcode.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Sergey Golitsyn
 * created on 23.10.2023
 */
public class SurroundedRegions {

    public static void main(String[] args) {
        SurroundedRegions s = new SurroundedRegions();
        char[][] board = new char[][]{
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'},
        };
        s.solve(board);
        Arrays.stream(board).sequential().forEach(a -> System.out.println(Arrays.toString(a)));
    }

    public void solve(char[][] board) {

        // check only borders
        // mark as T
        // mark all O as X
        // mark all T as O
        Set<Pair> visited = new HashSet<>();
        int max = Math.max(board.length, board[0].length);
        for (int i = 0; i < max; i++) {
                dfs(board, visited, i, 0); // left
                dfs(board, visited, i, board[0].length - 1); // right

                dfs(board, visited, 0, i); // top
                dfs(board, visited, board.length - 1, i); // bottom
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, Set<Pair> visited, int row, int col) {
        if (row < 0 || col < 0 ||
                row >= board.length || col >= board[0].length ||
                visited.contains(new Pair(row, col))
                || board[row][col] != 'O') {
            return;
        }
        board[row][col] = 'T';
        visited.add(new Pair(row, col));
        dfs(board, visited, row + 1, col);
        dfs(board, visited, row - 1, col);
        dfs(board, visited, row, col + 1);
        dfs(board, visited, row, col - 1);
    }

    record Pair(int row, int col) {
    }

}
