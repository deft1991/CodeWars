package com.codewars.codility;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 04.09.2023
 */
public class Solution2 {

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        String codeSignal = s.solution("CodeSignal", 3);
        System.out.println(codeSignal);
    }

    String solution(String message, int n) {
        char[] dict = new char[]{'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};

        char[] dictUpper = new char[]{'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z'};
        Map<Character, Integer> dictMap = new HashMap<>();
        Map<Character, Integer> dictMapUpper = new HashMap<>();

        for(int i = 0; i < dict.length; i++){
            dictMap.put(dict[i], i);
        }

        for(int i = 0; i < dictUpper.length; i++){
            dictMapUpper.put(dictUpper[i], i);
        }
        char [] chars = message.toCharArray();
        int count = 0;
        for(int i = 0; i < chars.length; i++){
            char cur = chars[i];
            if(dictMap.containsKey(cur)){
                count++;

                if(count % n == 0){
                    int idx = dictMap.get(cur);
                    int nextIdx = (idx+1) % dict.length;
                    chars[i] = dict[nextIdx];
                }
            } else if(dictMapUpper.containsKey(cur)){
                count++;

                if(count % n == 0){
                    int idx = dictMapUpper.get(cur);
                    int nextIdx = (idx+1) % dictUpper.length;
                    chars[i] = dictUpper[nextIdx];
                }
            }
        }
        return new String(chars);
    }

}
