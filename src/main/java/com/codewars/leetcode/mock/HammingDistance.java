package com.codewars.leetcode.mock;

/*
 * Created by sgolitsyn on 1/10/20
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {

        int rez = x ^ y;
        int countOfZero = 0;
        while (rez != 0){
            countOfZero += rez  & 1;
            rez = rez >> 1;
        }
        return countOfZero;
    }
}
