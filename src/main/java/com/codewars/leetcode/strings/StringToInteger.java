package com.codewars.leetcode.strings;

/*
 * Created by sgolitsyn on 5/25/20
 */
public class StringToInteger {
    public static void main(String[] args) {
//        System.out.println(myAtoi("42"));
//        System.out.println(myAtoi("   -42"));
//        System.out.println(myAtoi("4193 with words"));
//        System.out.println(myAtoi("words and 987"));
//        System.out.println(myAtoi("-91283472332"));
//        System.out.println(myAtoi("91283472332"));
//        System.out.println(myAtoi("3.14159"));
        System.out.println(myAtoi("+1"));
    }

    public static int myAtoi(String str) {
        str = str.trim();
        if (str.isEmpty() || Character.isAlphabetic(str.charAt(0))){
            return 0;
        }
        boolean isNegative = false;
        if (str.charAt(0) == '-'){
            isNegative = true;
            str = str.substring(1);
        } else if (str.charAt(0) == '+'){
            str = str.substring(1);
        }
        int count = 0;
        if (str.isEmpty() || !Character.isDigit(str.charAt(0))){
            return 0;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))){
                break;
            }
            count++;
        }
        try{
            int rez = Integer.parseInt(str.substring(0, count));
            return isNegative ? -rez : rez;
        } catch (NumberFormatException e){
            return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

    }
}
