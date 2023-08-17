package com.codewars.facebook;

/**
 * @author Sergey Golitsyn
 * created on 12.08.2023
 */
public class WordSearch {

    public static void main(String[] args) {
        WordSearch w = new WordSearch();
        char[][] board = new char[][]{{'a'}};
        System.out.println(w.exist(board, "a"));
    }

    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                visited[i][j] = true;
                boolean isExists = exist(board, chars, i, j, 0, 0, visited);
                visited[i][j] = false;
                if (isExists) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, char[] chars, int i, int j, int curLength, int curIdx, boolean[][] visited) {
        boolean right = false;
        boolean left = false;
        boolean down = false;
        boolean top = false;

        if (chars[curIdx] == board[i][j]) {
            curLength++;
            if (curLength == chars.length){
                return true;
            }
            if (i + 1 < board.length && !visited[i + 1][j]) {
                visited[i + 1][j] = true;
                right = exist(board, chars, i + 1, j, curLength, curIdx + 1, visited);
                visited[i + 1][j] = false;
            }
            if (right) {
                return true;
            }
            if (i - 1 >= 0 && !visited[i - 1][j]) {
                visited[i - 1][j] = true;
                left = exist(board, chars, i - 1, j, curLength, curIdx + 1, visited);
                visited[i - 1][j] = false;
            }
            if (left) {
                return true;
            }

            if (j + 1 < board[0].length && !visited[i][j + 1]) {
                visited[i][j + 1] = true;
                down = exist(board, chars, i, j + 1, curLength, curIdx + 1, visited);
                visited[i][j + 1] = false;
            }
            if (down) {
                return true;
            }
            if (j - 1 >= 0 && !visited[i][j - 1]) {
                visited[i][j - 1] = true;
                top = exist(board, chars, i, j - 1, curLength, curIdx + 1, visited);
                visited[i][j - 1] = false;
            }
            if (top) {
                return true;
            }
        }
        return false;
    }
}
