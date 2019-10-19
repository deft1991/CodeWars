package com.codewars.crackingcodeinterview;

/*
 * Created by sgolitsyn on 9/23/19
 */
public class RotateMatrix {



    public static void main(String[] args) {
        int[][] mat = new int[3][3];
        mat[0][0] = 0;
        mat[0][1] = 1;
        mat[0][2] = 2;
        mat[1][0] = 3;
        mat[1][1] = 4;
        mat[1][2] = 5;
        mat[2][0] = 6;
        mat[2][1] = 7;
        mat[2][2] = 8;

        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[i].length; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

}
