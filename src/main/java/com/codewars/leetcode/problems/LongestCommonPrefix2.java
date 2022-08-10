package com.codewars.leetcode.problems;

/**
 * @author Sergey Golitsyn
 * created on 26.07.2022
 */
public class LongestCommonPrefix2 {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"cir", "car"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        if (strs.length == 1){
            return strs[0];
        }

        String rez = strs[0];
        for(int i = 1; i < strs.length; i ++){
            String cur = strs[i];
            int reader = 0;
            int lastCommon = 0;
            while(reader < rez.length() && reader < cur.length()){
                if(rez.charAt(reader) == cur.charAt(reader)){
                    lastCommon ++;
                } else {
                    break;
                }
                reader++;
            }
            rez = rez.substring(0, lastCommon);
        }
        return rez;
    }
}
