package com.codewars.neetcode.binarySearch;

/**
 * @author Sergey Golitsyn
 * created on 24.11.2023
 */
public class Search2DMatrix2 {

    public static void main(String[] args) {
        Search2DMatrix2 s = new Search2DMatrix2();
//        System.out.println(s.searchMatrix(new int[][]{
//                {1,2,3},
//                {4,5,6},
//                {7,8,9}
//        }, 1));
//        System.out.println(s.searchMatrix(new int[][]{
//                {1,2,3},
//                {4,5,6},
//                {7,8,9}
//        }, 0));
        System.out.println(s.searchMatrix(new int[][]{
                {1}
        }, 2));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length * matrix[0].length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            int i = mid / matrix[0].length;
            int j = mid % matrix[0].length;

            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
