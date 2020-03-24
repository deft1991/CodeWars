package com.codewars.leetcode.explore.binarysearch;

/*
 * Created by sgolitsyn on 1/25/20
 */
public class SqrtX {
    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }

    public static int mySqrt(int x) {
        int start = 1;
        int end = x;
        if(x == 0){
            return 0;
        }
        if(x < 4){
            return 1;
        }
        while (start <= end){
            int mid = start + (end - start)/2;
            if (mid * mid == x){
                return mid;
            } else {
                if (mid * mid > x){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return end;
    }
}
