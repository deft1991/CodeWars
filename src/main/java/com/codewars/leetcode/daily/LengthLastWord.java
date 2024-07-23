package com.codewars.leetcode.daily;

/**
 * @author Sergey Golitsyn
 * created on 01.04.2024
 */
public class LengthLastWord {

    public static void main(String[] args) {
        LengthLastWord l = new LengthLastWord();
//        System.out.println(l.lengthOfLastWord("hello")); // 5
//        System.out.println(l.lengthOfLastWord("hello world")); // 5
//        System.out.println(l.lengthOfLastWord("  fly me   to   the moon  ")); // 4
//        System.out.println(l.lengthOfLastWord("luffy is still joyboy")); // 6
        System.out.println(l.lengthOfLastWord("a ")); // 1
    }

    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while(s.charAt(end) == ' '){
            end--;
        }
        int start = end;
        for(; start >= 0; start--) {
            if(s.charAt(start) == ' '){
                return end - start;
            }
        }
        return end - start;
    }
}
