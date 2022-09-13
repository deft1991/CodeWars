package com.codewars.leetcode.problems.medium;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Sergey Golitsyn
 * created on 06.09.2022
 */
public class WordSearch {

    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(ws.exist(board, "ABCCED"));
        System.out.println(ws.exist(board, "ABCCEX"));
    }

    public boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean isExists = backtrack(i, j, word, 0, board, visited);
                if (isExists) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean backtrack(int i, int j, String word, int offset, char[][] board, boolean[][] visited) {
        if (offset == word.length()) {
            return true;
        }
        if (i < 0 || j < 0) {
            return false;
        }
        if (i >= board.length || j >= board[i].length) {
            return false;
        }
        if (visited[i][j]) {
            return false;
        }
        char cur = word.charAt(offset);
        if (board[i][j] != cur) {
            return false;
        }
        int nextOffset = offset + 1;
        visited[i][j] = true;
        boolean rez = backtrack(i + 1, j, word, nextOffset, board, visited)
                || backtrack(i - 1, j, word, nextOffset, board, visited)
                || backtrack(i, j + 1, word, nextOffset, board, visited)
                || backtrack(i, j - 1, word, nextOffset, board, visited);
        visited[i][j] = false;
        return rez;
    }
}
