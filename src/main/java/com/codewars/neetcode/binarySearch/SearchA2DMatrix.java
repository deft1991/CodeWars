package com.codewars.neetcode.binarySearch;

/**
 * @author Sergey Golitsyn
 * created on 28.12.2022
 */
public class SearchA2DMatrix {

    public static void main(String[] args) {
        SearchA2DMatrix s = new SearchA2DMatrix();
//        System.out.println(s.searchMatrix(new int[][]{{1}}, 1)); // true
//        System.out.println(s.searchMatrix(new int[][]{{1}}, 2)); // false
//        System.out.println(s.searchMatrix(new int[][]{{1,2}, {3,4}}, 3)); // true
        System.out.println(s.searchMatrix(new int[][]{{1, 3}}, 3)); // true
        System.out.println(s.searchMatrix(new int[][]{{1, 3}}, 1)); // true
        System.out.println(s.searchMatrix(new int[][]{{1, 3}}, 5)); // false
        System.out.println(s.searchMatrix(new int[][]{{1}, {3}, {5}}, 5)); // true
//        System.out.println(s.searchMatrix(new int[][]{{1, 2, 3}, {4, 5, 6}}, 3)); // true
//        System.out.println(s.searchMatrix(new int[][]{{1,3,5,7}, {10,11,16,20}, {23,30,34,60}}, 3)); // true
//        System.out.println(s.searchMatrix(new int[][]{{1,3,5,7}, {10,11,16,20}, {23,30,34,60}}, 13)); // false
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        int start = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int length = n * m;
        int end = length;

        while (start <= end & start < length && end >= 0) {
            int mid = start + (end - start) / 2;

            int i = mid / m;
            int j = mid % m;

            if (target == matrix[i][j]) {
                return true;
            } else if (matrix[i][j] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
