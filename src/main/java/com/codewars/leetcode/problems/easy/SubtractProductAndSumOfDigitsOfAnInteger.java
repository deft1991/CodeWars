package com.codewars.leetcode.problems.easy;

/**
 * @author Sergey Golitsyn
 * created on 13.02.2021
 */
public class SubtractProductAndSumOfDigitsOfAnInteger {

    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(705));
        System.out.println(subtractProductAndSum(234));
        System.out.println(subtractProductAndSum(4421));
    }

    public static int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;

        while (n > 0){
            int cur = n % 10;
            sum += cur;
            product *= cur;
            n = n / 10;
        }
        return product - sum;
    }

}
