package com.codewars.leetcode.daily;

/**
 * @author Sergey Golitsyn
 * created on 13.03.2024
 */
public class FindPivotInteger {

    public static void main(String[] args) {
        FindPivotInteger f = new FindPivotInteger();
        System.out.println(f.pivotInteger(8));
        System.out.println(f.pivotInteger(1));
        System.out.println(f.pivotInteger(4));
    }

    public int pivotInteger(int n) {
        int totalSum = 0;

        for(int i = 1; i <= n; i++){
            totalSum += i;
        }

        int rightSum = 0;
        while (totalSum > 0 && totalSum > rightSum){
            rightSum += n;

            if (rightSum == totalSum){
                return n;
            }

            totalSum -= n;
            n--;
        }
        return -1;
    }
}
