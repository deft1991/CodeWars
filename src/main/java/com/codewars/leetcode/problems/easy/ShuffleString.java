package com.codewars.leetcode.problems.easy;

/**
 * @author Sergey Golitsyn
 * created on 23.02.2021
 */
public class ShuffleString {

    public static void main(String[] args) {
        ShuffleString ss = new ShuffleString();

//        System.out.println(ss.restoreString("abc", new int[]{0,1,2}));
        System.out.println(ss.restoreString2("codeleet", new int[]{4,5,6,7,0,2,1,3}));
    }

    public String restoreString(String s, int[] indices) {
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < indices.length; i++){
            sb.replace(indices[i], indices[i] + 1, String.valueOf(s.charAt(i)));
        }
        return sb.toString();
    }

    public String restoreString2(String s, int[] indices) {

        char[] rez = new char[indices.length];
        char[] chars = s.toCharArray();
        for (int i = 0; i < indices.length; i++){
            int index = indices[i];
            rez[index] = chars[i];
        }
        return String.valueOf(rez);
    }
}
