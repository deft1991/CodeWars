package com.codewars.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        dfs(0, result, new ArrayList<>(), s);
        return result;
    }

    void dfs(int start, List<List<String>> result, List<String> currentList, String s) {
        if (start >= s.length()){
            result.add(new ArrayList<>(currentList));
        }
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                // add current substring in the currentList
                currentList.add(s.substring(start, end + 1));
                dfs(end + 1, result, currentList, s);
                // backtrack and remove the current substring from currentList
                currentList.remove(currentList.size() - 1);
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
