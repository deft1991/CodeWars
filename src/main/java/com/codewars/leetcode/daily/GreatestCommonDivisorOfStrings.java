package com.codewars.leetcode.daily;

/**
 * @author Sergey Golitsyn
 * created on 01.02.2023
 */
public class GreatestCommonDivisorOfStrings {

    public static void main(String[] args) {
        GreatestCommonDivisorOfStrings g = new GreatestCommonDivisorOfStrings();
        System.out.println(g.gcdOfStrings("ABCABC", "ABC")); // abc
        System.out.println(g.gcdOfStrings("ABABAB", "ABAB")); //abab
    }

    public String gcdOfStrings2(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();

        // Swap the paramters when needed
        if (l1 < l2){
            return gcdOfStrings(str2, str1);
        }

        // Since we swap
        if (l2 == 0){
            return str1;
        }

        // Check if str1 starts with str2
        if (!str1.startsWith(str2)) {
            return "";
        }

        return gcdOfStrings(str1.substring(l2), str2);
    }

    public String gcdOfStrings(String str1, String str2) {
        String longS;
        String shortS;
        if (str1.length() > str2.length()) {
            longS = str1;
            shortS = str2;
        } else {
            longS = str2;
            shortS = str1;
        }

        String longest = shortS;

        for (int i = shortS.length(); i >= 0; i--) {
            if (isValid(shortS, longS, i)) {
                return shortS.substring(0, i);
            }
        }

        return longest;
    }

    private static boolean isValid(String shortS, String longS, int endIdx) {
        if (shortS.length() % endIdx != 0 || longS.length() % endIdx != 0){
            return false;
        } else {
            String base = shortS.substring(0, endIdx);
            return shortS.replaceAll(base, "").isEmpty()
                    && longS.replaceAll(base, "").isEmpty();
        }

    }
}
