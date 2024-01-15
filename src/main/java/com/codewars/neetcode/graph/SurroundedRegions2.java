package com.codewars.neetcode.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Sergey Golitsyn
 * created on 12.01.2024
 */
public class SurroundedRegions2 {

    public static void main(String[] args) {
        SurroundedRegions2 s = new SurroundedRegions2();

        char[][] arr = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
        };
        s.solve(arr);
        Arrays.stream(arr).forEach(a -> System.out.println(Arrays.toString(a)));
    }

    public void solve(char[][] board) {
        Set<Point> visited = new HashSet<>();

        // todo join points from borders and mark them as T
        for (int i = 0; i < board.length; i++) {
            dfs(0, i, board, visited);
            dfs(board.length - 1, i, board, visited);

            dfs(i, 0, board, visited);
            dfs(i, board.length - 1, board, visited);
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

    private void dfs(int row, int col, char[][] board, Set<Point> visited) {
        if (row < 0 || row >= board.length
                || col < 0 || col >= board[0].length
                || board[row][col] != 'O'
                || visited.contains(new Point(row, col))){
            return;
        }
        board[row][col] = 'T';
        dfs(row + 1, col, board, visited);
        dfs(row - 1, col, board, visited);
        dfs(row, col + 1, board, visited);
        dfs(row, col - 1, board, visited);
    }

    record Point(int row, int col) {
    }
}
