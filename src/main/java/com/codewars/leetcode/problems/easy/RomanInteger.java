package com.codewars.leetcode.problems.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 25.07.2022
 */
public class RomanInteger {

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> dict = new HashMap<>();
        dict.put('I', 1);
        dict.put('V', 5);
        dict.put('X', 10);
        dict.put('L', 50);
        dict.put('C', 100);
        dict.put('D', 500);
        dict.put('M', 1000);

        char[] ch = s.toCharArray();

        if(ch.length <= 1) {
            return dict.get(ch[0]);
        }

        int rez = 0;
        for(int i = 0; i < ch.length; i++){
            Integer cur = dict.get(ch[i]);

            if(i + 1 < ch.length && dict.get(ch[i + 1]) > cur){
                int tmp = dict.get(ch[i + 1]) - cur;
                rez += tmp;
                i++;
            } else {
                rez += cur;
            }
        }
        return rez;
    }
}
