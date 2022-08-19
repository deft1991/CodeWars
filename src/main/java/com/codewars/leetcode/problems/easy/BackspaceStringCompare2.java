package com.codewars.leetcode.problems.easy;

/**
 * @author Sergey Golitsyn
 * created on 17.08.2022
 */
public class BackspaceStringCompare2 {

    public static void main(String[] args) {
//        System.out.println(backspaceCompare("ab#c", "ad#c"));
//        System.out.println(backspaceCompare("ab##", "c#d#"));
//        System.out.println(backspaceCompare("a#c", "b"));
        System.out.println(backspaceCompare("y#fo##f", "y#f#o##f"));
    }

    public static boolean backspaceCompare(String s, String t) {
        String sbS = prepareString(s);
        String sbT = prepareString(t);
        return sbS.equals(sbT);
    }

    private static String prepareString(String s) {
        StringBuilder sb = new StringBuilder();
        int reader = 0;

        while (reader < s.length()) {
            char cur = s.charAt(reader);
            if (cur == '#') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1); // delete last
                }
            } else {
                sb.append(cur);
            }
            reader++;
        }
        return sb.toString();
    }
}
