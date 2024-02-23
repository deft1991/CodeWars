package com.codewars.leetcode.daily;

/**
 * @author Sergey Golitsyn
 * created on 07.02.2024
 */
public class SortCharactersByFrequency {

    public static void main(String[] args) {
        SortCharactersByFrequency s = new SortCharactersByFrequency();
        System.out.println(s.frequencySort("tree"));
        System.out.println(s.frequencySort("cccaaa"));
    }

    public String frequencySort(String s) {
        int[] freq = new int[128];

        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            freq[c]++;
        }
        for (int i = 0; i < s.length();) {
            char cmax = ',';
            for (int j = 0; j < 128; j++) {
                if (freq[j] > freq[cmax]) {
                    cmax = (char) j;
                }
            }
            while(freq[cmax]>0){
                charArray[i++]=cmax;
                freq[cmax]--;
            }
        }
        return new String(charArray);
    }

}
