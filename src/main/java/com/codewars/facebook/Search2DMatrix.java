package com.codewars.facebook;

/**
 * @author Sergey Golitsyn
 * created on 23.08.2023
 */
public class Search2DMatrix {

    public static void main(String[] args) {
        Search2DMatrix s = new Search2DMatrix();
        System.out.println(s.searchMatrix(new int[][]{
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        }, 3));
        System.out.println(s.searchMatrix(new int[][]{
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        }, 13));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length * matrix[0].length - 1;
        int m = matrix[0].length;
        int n = matrix.length;
        while(start <= end){
            int mid = start + (end - start) / 2;

            int i = mid / m;
            int j = mid % m;

            if (matrix[i][j] == target){
                return true;
            } else if(matrix[i][j] > target){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
