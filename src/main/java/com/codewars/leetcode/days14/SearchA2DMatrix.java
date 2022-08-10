package com.codewars.leetcode.days14;

/**
 * @author Sergey Golitsyn
 * created on 02.03.2022
 */
public class SearchA2DMatrix {

    public static void main(String[] args) {
        SearchA2DMatrix s = new SearchA2DMatrix();

//        System.out.println(s.searchMatrix(new int[][]{{1,3,5,7}, {10,11,16,20}, {23,30,34,60}}, 7)); // true
//        System.out.println(s.searchMatrix(new int[][]{{1,3,5,7}, {10,11,16,20}, {23,30,34,60}}, 8)); // false
//        System.out.println(s.searchMatrix(new int[][]{{1}}, 8)); // false
//        System.out.println(s.searchMatrix(new int[][]{{1, 1}}, 8)); // false
//        System.out.println(s.searchMatrix(new int[][]{{1, 1}}, 1)); // true
//        System.out.println(s.searchMatrix(new int[][]{{1}}, 1)); // true
//        System.out.println(s.searchMatrix(new int[][]{{1}, {3}}, 1)); // true
//        System.out.println(s.searchMatrix(new int[][]{{1}, {3}}, 0)); // false
//        System.out.println(s.searchMatrix(new int[][]{{1}, {3}}, 1)); // true
        System.out.println(s.searchMatrix(new int[][]{{1}, {3}}, 3)); // true
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        int start = 0;
        int cols = matrix[0].length;
        int end = matrix.length * cols  - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid / cols][mid % cols] == target) {
                return true;
            } else {
                if (matrix[mid / cols][mid % cols] >= target) {
                   end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return false;
    }
}
