package com.codewars.leetcode.dataStructure;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 07.04.2022
 */
public class RansomNote {

    public static void main(String[] args) {
        RansomNote r = new RansomNote();

        System.out.println(r.canConstruct("aa", "aa"));
        System.out.println(r.canConstruct("aa", "ab"));
        System.out.println(r.canConstruct("aa", "aab"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()){
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();

        for(char c : magazine.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(char c : ransomNote.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        for(int i : map.values()){
            if (i < 0){
                return false;
            }
        }
        return true;
    }
}
