package com.codewars.leetcode.problems.easy;

/**
 * @author Sergey Golitsyn
 * created on 01.09.2022
 */
public class SetMatrixZeroes {

    public static void main(String[] args) {
        SetMatrixZeroes s = new SetMatrixZeroes();
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        s.setZeroes(matrix);
        System.out.println();
    }

    public void setZeroes(int[][] matrix) {

        boolean isFirstRow = false;
        boolean isFirstColumn = false;

        for(int i = 0; i < matrix.length; i++){
            if (matrix[i][0] == 0){
                isFirstColumn = true;
            }
        }
        for(int i = 0; i < matrix[0].length; i++){
            if (matrix[0][i] == 0){
                isFirstRow = true;
            }
        }

        for(int i = 1; i < matrix.length; i++){
            for (int j = 1; j < matrix[i].length; j ++){
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < matrix.length; i ++){
            if (matrix[i][0] == 0){
                for (int j = 1; j < matrix[i].length; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int j = 1; j < matrix[0].length; j ++){
            if (matrix[0][j] == 0){
                for (int i = 1; i < matrix.length; i++){
                    matrix[i][j] = 0;
                }
            }
        }

        if(isFirstRow){
            for(int i = 0; i < matrix[0].length; i++){
                matrix[0][i] = 0;
            }
        }
        if(isFirstColumn){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }

    }
}
