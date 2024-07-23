package com.codewars.leetcode.daily;

/**
 * @author Sergey Golitsyn
 * created on 24.04.2024
 */
public class NthTribonacciNumber {

    public static void main(String[] args) {
        NthTribonacciNumber n = new NthTribonacciNumber();
//        System.out.println(n.tribonacci(2));
//        System.out.println(n.tribonacci(3));
        System.out.println(n.tribonacci(4));
        System.out.println(n.tribonacci(5));
    }

    /*
T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

T_0 = 0
T_1 = 1
T_2 = 1
T_3 = 0 + 1 + 1 = 2
T_4 = 0 + 1 + 1 + 2 = 4
t_5 = 0 + 1 + 1 + 2 + 4 =

[0, 1, 1, 2, 4, ]

     */
    public int tribonacci(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;


        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }
}
