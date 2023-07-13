package com.codewars.neetcode.arraysAndHashing;

/**
 * @author Sergey Golitsyn
 * created on 05.12.2022
 */
public class ValidSudoku {

    public static void main(String[] args) {
        ValidSudoku vs = new ValidSudoku();

        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}

        };

        System.out.println(vs.isValidSudoku(board));

        board = new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(vs.isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            boolean isValidLine = isValidRow(board, i);
            boolean isValidRow = isValidColumn(board, i);
            boolean isValidSquare = isValidSquare(board, i);

            if (!isValidLine || !isValidRow || !isValidSquare) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidRow(char[][] board, int line) {
        int[] dict = new int[10];
        for (int i = 0; i < board[line].length; i++) {
            char cur = board[line][i];
            if (Character.isDigit(cur)) {
                int curInt = cur - '0';
                if (curInt < 1 || curInt > 9) {
                    return false;
                }
                if (dict[curInt] > 0) {
                    return false;
                }
                dict[curInt]++;
            }
        }
        return true;
    }

    private boolean isValidColumn(char[][] board, int row) {
        int[] dict = new int[10];
        for (int i = 0; i < board.length; i++) {
            char cur = board[i][row];
            if (Character.isDigit(cur)) {
                int curInt = cur - '0';
                if (curInt < 1 || curInt > 9) {
                    return false;
                }
                if (dict[curInt] > 0) {
                    return false;
                }
                dict[curInt]++;
            }
        }
        return true;
    }

    private boolean isValidSquare(char[][] board, int square) {
        int[] dict = new int[10];

        int startRow = (square * 3) % 9;
        int endRow = startRow + 3;

        int startCol = (square / 3) * 3;
        int endCol = startCol + 3;
        for (int i = startCol; i < endCol; i++) {
            for (int j = startRow; j < endRow; j++) {
                char cur = board[i][j];
                if (Character.isDigit(cur)) {
                    int curInt = cur - '0';
                    if (curInt < 1 || curInt > 9) {
                        return false;
                    }
                    if (dict[curInt] > 0) {
                        return false;
                    }
                    dict[curInt]++;
                }
            }
        }
        return true;
    }


}
