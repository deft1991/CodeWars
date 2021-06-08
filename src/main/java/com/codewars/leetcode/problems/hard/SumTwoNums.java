package com.codewars.leetcode.problems.hard;

/**
 * @author Sergey Golitsyn
 * created on 07.06.2021
 */
public class SumTwoNums {


    public static void main(String[] args) {
        SumTwoNums stn = new SumTwoNums();

//        System.out.println(stn.sum(759, 674));
//        System.out.println(stn.sum(1, 2));
        System.out.println(stn.sum(9, 1));
    }

    int sum(int a, int b) {
        if (b == 0) {
            return a;
        }
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return sum(sum, carry);
    }
}
