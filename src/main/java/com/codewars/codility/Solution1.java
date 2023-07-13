package com.codewars.codility;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 19.04.2023
 */
class Solution1 {

    public static void main(String[] args) {
        Solution1 s = new Solution1();

        System.out.println(s.solution(new int[]{1000000000, 1, 2, 2, 1000000000, 1, 1000000000}));
    }
    public int solution(int[] A) {
        // Implement your solution here
        Arrays.sort(A);

        int end = 0;
        int start = A.length - 1;

        long rez = 0;
        while(start > end){
            if(A[start] > A[end]){
                rez -= A[end ++];
                rez += A[start --];
            }
        }

        if (A.length % 2 == 0){
            rez += A[--end];
        }
        return (int) rez;
    }
}
