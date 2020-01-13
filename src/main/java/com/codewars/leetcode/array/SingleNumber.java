package com.codewars.leetcode.array;

/*
 * Created by sgolitsyn on 1/9/20
 */
public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(2^2^1);
    }

    public int singleNumber(int[] nums) {
        int rez = 0;
        for(int i : nums){
            rez^=i;
        }
        return rez;
    }
}
