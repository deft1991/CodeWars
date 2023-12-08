package com.codewars.leetcode.daily;

/**
 * @author Sergey Golitsyn
 * created on 04.12.2023
 */
public class Largest3SameDigitNumberString {

    public static void main(String[] args) {
        Largest3SameDigitNumberString l = new Largest3SameDigitNumberString();
        System.out.println(l.largestGoodInteger2("2300019"));
        System.out.println(l.largestGoodInteger2("677713333999"));
        System.out.println(l.largestGoodInteger2("42352338"));
    }

    public String largestGoodInteger(String num) {

        int start = 0;
        int end = 0;
        String rez = "";
        while (end < num.length()) {
            if (num.charAt(start) == num.charAt(end)) {
                if (end - start == 2) {
                    String tmp = num.substring(start, end + 1);
                    if (tmp.compareTo(rez) > 0) {
                        rez = tmp;
                    }
                    start++;
                }
                end++;
            } else {
                start++;
                end = start;
            }

        }
        return rez;
    }

    public String largestGoodInteger2(String num) {

        char max = '\0';
        for (int i = 0; i <= num.length() - 3; i++) {
           if (num.charAt(i) == num.charAt(i+1) && num.charAt(i) == num.charAt(i+2)){
               max = (char) Math.max(max, num.charAt(i));
           }
        }
        return max == '\0' ? "" : new String(new char[]{max, max, max});
    }
}
