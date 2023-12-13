package com.codewars.leetcode.daily;

/**
 * @author Sergey Golitsyn
 * created on 13.12.2023
 */
public class SpecialPositionsBinaryMatrix {

    public static void main(String[] args) {

    }

    public int numSpecial(int[][] mat) {

        int[] rows = new int[mat.length];
        int[] cols = new int[mat[0].length];

        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[i].length; j++){
                if(mat[i][j] == 1){
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        int rez = 0;

        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[i].length; j++){
                if(mat[i][j] == 1 && rows[i] == 1 && cols[j] == 1){
                    rez++;
                }
            }
        }
        return rez;
    }
}
