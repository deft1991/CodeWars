package com.codewars.neetcode.binarySearch;

/**
 * @author Sergey Golitsyn
 * created on 12.07.2023
 */
public class Search2DMatrix {

    public static void main(String[] args) {
        Search2DMatrix s = new Search2DMatrix();
        System.out.println(s.searchMatrix(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
        }, 1));
        System.out.println(s.searchMatrix(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
        }, 2));
        System.out.println(s.searchMatrix(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
        }, 3));
        System.out.println(s.searchMatrix(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
        }, 4));
        System.out.println(s.searchMatrix(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
        }, 5));
        System.out.println(s.searchMatrix(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
        }, 0));
        System.out.println(s.searchMatrix(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
        }, 7));
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        int start = 0;

        int n = matrix.length;
        int m = matrix[0].length;
        int length = n * m;
        int end = n * m;

        while (start <= end && start < length && end >= 0) {
            int mid = start + (end - start) / 2;

            int row = mid / m;
            int column = mid % m;
            int cur = matrix[row][column];

            if (cur == target) {
                return true;
            } else if (cur > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
