package com.codewars.leetcode.dataStructure;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Sergey Golitsyn
 * created on 05.04.2022
 */
public class ValidSudoku {

    public static void main(String[] args) {
        ValidSudoku v = new ValidSudoku();
        System.out.println(v.isValidSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        }));
//        System.out.println(v.isValidSudoku(new char[][]{
//                {'8','3','.','.','7','.','.','.','.'},
//                {'6','.','.','1','9','5','.','.','.'},
//                {'.','9','8','.','.','.','.','6','.'},
//                {'8','.','.','.','6','.','.','.','3'},
//                {'4','.','.','8','.','3','.','.','1'},
//                {'7','.','.','.','2','.','.','.','6'},
//                {'.','6','.','.','.','.','2','8','.'},
//                {'.','.','.','4','1','9','.','.','5'},
//                {'.','.','.','.','8','.','.','7','9'},
//        }));
//        System.out.println(v.isValidSudoku(new char[][]{
//                {'.','.','.','.','5','.','.','1','.'},
//                {'.','4','.','3','.','.','.','.','.'},
//                {'.','.','.','.','.','3','.','.','1'},
//                {'8','.','.','.','.','.','.','2','.'},
//                {'.','.','2','.','7','.','.','.','.'},
//                {'.','1','5','.','.','.','.','.','.'},
//                {'.','.','.','.','.','2','.','.','.'},
//                {'.','2','.','9','.','.','.','.','.'},
//                {'.','.','4','.','.','.','.','.','.'},
//        }));
    }

    public boolean isValidSudoku(char[][] board) {
        if (board.length != 9) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i].length != 9) {
                return false;
            }
            boolean validRow = isValidRow(board, i);
            boolean validColumn = isValidColumn(board, i);
            boolean validSquare = isValidSquare(board, i);

            if (!validRow || !validColumn || !validSquare) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidRow(char[][] board, int rowIdx) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            if (Character.isDigit(board[i][rowIdx])) {
                if (set.contains(board[i][rowIdx])) {
                    return false;
                }
                set.add(board[i][rowIdx]);
            }
        }
        return true;
    }

    private boolean isValidColumn(char[][] board, int columnIdx) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < board[columnIdx].length; i++) {
            if (Character.isDigit(board[columnIdx][i])) {
                if (set.contains(board[columnIdx][i])) {
                    return false;
                }
                set.add(board[columnIdx][i]);
            }
        }
        return true;
    }

    private boolean isValidSquare(char[][] board, int square) {
        int startR = (square / 3) * 3;
        int endR = startR + 3;

        int startCol = square * 3 % 9;
        int endCol = startCol + 3;
        int end = (square + 1) * 3 % 9;
        if (end == 0) {
            end = 9;
        }
        Set<Character> set = new HashSet<>();
        for (int i = startR; i < endR; i++) {
            for (int j = startCol; j < endCol; j++) {
                if (Character.isDigit(board[i][j])) {
                    if (set.contains(board[i][j])) {
                        return false;
                    }
                    set.add(board[i][j]);
                }
            }
        }
        return true;
    }
}
