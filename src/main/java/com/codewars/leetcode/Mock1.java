package com.codewars.leetcode;

/*
 * Created by sgolitsyn on 1/10/20
 */
public class Mock1 {
    public static void main(String[] args) {
        Mock1 m1 = new Mock1();

        System.out.println(m1.canWinNim(6));
    }

    public boolean canWinNim(int n) {

        if (n <= 0) {
            return false;
        }
        if (n <= 3) {
            return true;
        } else {
            return !(n % 4 == 0);
        }
    }
}
