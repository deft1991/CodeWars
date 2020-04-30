package com.codewars.leetcode.problems.easy;

/*
 * Created by sgolitsyn on 4/9/20
 */
public class DefanginganIPAddress {
    public static void main(String[] args) {
        DefanginganIPAddress defanginganIPAddress = new DefanginganIPAddress();
        System.out.println(defanginganIPAddress.defangIPaddr("1.1.1.1"));
        System.out.println(defanginganIPAddress.defangIPaddr("255.100.50.0"));
    }

    public String defangIPaddr(String address) {
        char[] chars = address.toCharArray();
        int coutDot = getCountDot(chars);
        char[] charsModif = new char[chars.length + coutDot * 2];

        int j = 0;
        for (char aChar : chars) {
            if ('.' == aChar) {
                charsModif[j++] = '[';
                charsModif[j++] = '.';
                charsModif[j++] = ']';
            } else {
                charsModif[j++] = aChar;
            }
        }
        return String.valueOf(charsModif);
    }

    private int getCountDot(char[] chars) {
        int countDot = 0;
        for (Character c : chars) {
            if ('.' == c) {
                countDot++;
            }
        }
        return countDot;
    }
}
