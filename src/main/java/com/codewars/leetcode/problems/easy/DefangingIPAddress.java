package com.codewars.leetcode.problems.easy;

/**
 * @author Sergey Golitsyn
 * created on 06.02.2021
 * <p>
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.
 * <p>
 * A defanged IP address replaces every period "." with "[.]".
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: address = "1.1.1.1"
 * Output: "1[.]1[.]1[.]1"
 * Example 2:
 * <p>
 * Input: address = "255.100.50.0"
 * Output: "255[.]100[.]50[.]0"
 */
public class DefangingIPAddress {

    public static void main(String[] args) {
        System.out.println(defangIPaddr("1.1.1.1"));
        System.out.println(defangIPaddr("255.100.50.0"));
    }

    public static String defangIPaddr(String address) {
        char[] charArray = address.toCharArray();
        char[] chars = new char[charArray.length + 6];

        int writer = 0;
        for(char c : charArray){
            if (c == '.'){
                chars[writer++] = '[';
                chars[writer++] = '.';
                chars[writer++] = ']';
            } else {
                chars[writer++] = c;
            }
        }
        return String.valueOf(chars);

    }
}
