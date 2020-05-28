package com.codewars.leetcode.strings;

/*
 * Created by sgolitsyn on 5/28/20
 */
public class ImplementStrStr {
    public static void main(String[] args) {
        ImplementStrStr implementStrStr = new ImplementStrStr();
        System.out.println(implementStrStr.strStr("a", "a"));
//        System.out.println(implementStrStr.strStr("hello", "ll"));
//        System.out.println(implementStrStr.strStr("aaaaa", "bba"));
    }

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        int m = haystack.length();
        int n = needle.length();

        if (n > m){
            return -1;
        }

        char[] cur = haystack.toCharArray();
        char[] find = needle.toCharArray();

        for (int i = 0; i <= m-n; i++) {
            if (cur[i] == find[0]) {
                int j;
                for (j = 0; j < n; j++) {
                    if (cur[i + j] != find[j]){
                        break;
                    }
                }
                if (j == n){
                    return i;
                }
            }
        }
        return -1;
    }
}
