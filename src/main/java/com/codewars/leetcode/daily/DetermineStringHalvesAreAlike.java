package com.codewars.leetcode.daily;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Sergey Golitsyn
 * created on 12.01.2024
 */
public class DetermineStringHalvesAreAlike {

    public static void main(String[] args) {
        DetermineStringHalvesAreAlike d = new DetermineStringHalvesAreAlike();
        System.out.println(d.halvesAreAlike("book"));
//        System.out.println(d.halvesAreAlike("textbook"));
    }

    public boolean halvesAreAlike(String s) {
        int rez = 0;
        Set<Character> dict = new HashSet<>();
        dict.add('a');
        dict.add('e');
        dict.add('i');
        dict.add('o');
        dict.add('u');

        for(int i = 0; i < s.length(); i++){
            char cur = Character.toLowerCase(s.charAt(i));
            if(dict.contains(cur)){
                if(i >= s.length() / 2){
                    rez--;
                } else{
                    rez++;
                }
            }
        }
        return rez == 0;
    }
}
