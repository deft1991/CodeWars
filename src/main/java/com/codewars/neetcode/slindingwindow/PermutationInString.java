package com.codewars.neetcode.slindingwindow;

/**
 * @author Sergey Golitsyn
 * created on 15.12.2022
 */
public class PermutationInString {

    public static void main(String[] args) {
        PermutationInString p = new PermutationInString();
        System.out.println(p.checkInclusion("ab", "ab")); // true
        System.out.println(p.checkInclusion("ab", "abc")); // true
        System.out.println(p.checkInclusion("ab", "cabc")); // true
        System.out.println(p.checkInclusion("ab", "cbac")); // true
        System.out.println(p.checkInclusion("ab", "cbc")); // false
        System.out.println(p.checkInclusion("ab", "eidbaooo")); // true
        System.out.println(p.checkInclusion("ab", "eidboaoo")); // false
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] dict = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            int s1Idx = s1.charAt(i) - 'a';
            int s2Idx = s2.charAt(i) - 'a';
            dict[s1Idx]++;
            dict[s2Idx]--;
        }

        int left = 0;
        int right = s1.length();


        while (right < s2.length()){
            if (isEmpty(dict)){
                return true;
            }
            int leftIdx = s2.charAt(left) - 'a';
            int rightIdx = s2.charAt(right) - 'a';
            dict[leftIdx]++;
            dict[rightIdx] --;
            left++;
            right++;
        }
        return isEmpty(dict);
    }

    private boolean isEmpty(int[] dict) {
        for (int i : dict){
            if (i != 0){
                return false;
            }
        }
        return true;
    }

}
