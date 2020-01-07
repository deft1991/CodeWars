package com.codewars.leetcode;

/*
 * Created by sgolitsyn on 1/6/20
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        PalindromeNumber pn = new PalindromeNumber();
//        System.out.println(pn.isPalindrome(121));
//        System.out.println(pn.isPalindrome(122));
//        System.out.println(pn.isPalindrome(-121));
//        System.out.println(pn.isPalindrome(1221));
//        System.out.println(pn.isPalindrome(1231));
//        System.out.println(pn.isPalindrome(1331));
//        System.out.println(pn.isPalindrome(-1331));
        System.out.println(pn.isPalindrome(121));
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        int revert = 0;
        while (x > revert){
            int pop = x % 10;
            revert = revert * 10 + pop;
            x /= 10;
        }
         return x == revert || x == revert / 10;


    }
}
