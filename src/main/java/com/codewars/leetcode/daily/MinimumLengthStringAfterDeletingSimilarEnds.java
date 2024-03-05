package com.codewars.leetcode.daily;

/**
 * @author Sergey Golitsyn
 * created on 05.03.2024
 */
public class MinimumLengthStringAfterDeletingSimilarEnds {

    public static void main(String[] args) {
        MinimumLengthStringAfterDeletingSimilarEnds m = new MinimumLengthStringAfterDeletingSimilarEnds();

        System.out.println(m.minimumLength("ca"));
        System.out.println(m.minimumLength("cabaabac"));
        System.out.println(m.minimumLength("aabccabba"));
    }

    public int minimumLength(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            char st = s.charAt(start);
            char en = s.charAt(end);
            if (st != en) {
                return end - start + 1;
            }
            while (start + 1 < end && st == s.charAt(start + 1)) {
                start++;
            }
            while (start < end - 1 && en == s.charAt(end - 1)) {
                end--;
            }

            start++;
            end--;
        }
        return end - start + 1;
    }
}
