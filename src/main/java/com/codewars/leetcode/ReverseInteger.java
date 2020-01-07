package com.codewars.leetcode;

/*
 * Created by sgolitsyn on 1/6/20
 */
public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Math.pow(2,31-1));
        System.out.println(ri.reverse(123));
    }

    public int reverse(int x) {

        int rez = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rez > Integer.MAX_VALUE/10  || (rez == Integer.MAX_VALUE/10 && pop > 7)){
                return 0;
            }
            if (rez < Integer.MIN_VALUE/10  || (rez == Integer.MIN_VALUE/10 && pop < -8)){
                return 0;
            }
            rez = rez * 10 + pop;
        }
        return rez;
    }
}
