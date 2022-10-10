package com.codewars.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 28.09.2022
 */
public class PalindromePartitioning {

    public static void main(String[] args) {
        PalindromePartitioning pp = new PalindromePartitioning();

//        List<List<String>> list1 = pp.partition("a");
//        System.out.println();
//        List<List<String>> list2 = pp.partition("aa");
//        System.out.println();
        List<List<String>> list3 = pp.partition("aab");
        System.out.println();
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(0, result, new ArrayList<>(), s);
        return result;
    }

    private void backtrack(int start, List<List<String>> result, List<String> cur, String word) {

        if (start >= word.length()) {
            result.add(List.copyOf(cur));
        }

        for (int end = start; end < word.length(); end++) {
            if (isPalindrome(word, start, end)) {
                cur.add(word.substring(start, end + 1));
                backtrack(end + 1, result, cur, word);
                cur.remove(cur.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }
}
