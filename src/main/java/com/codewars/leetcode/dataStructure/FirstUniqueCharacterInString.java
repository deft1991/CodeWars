package com.codewars.leetcode.dataStructure;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 07.04.2022
 */
public class FirstUniqueCharacterInString {

    public static void main(String[] args) {
        FirstUniqueCharacterInString f = new FirstUniqueCharacterInString();
        System.out.println(f.firstUniqChar("leetcode")); // 0
        System.out.println(f.firstUniqChar("loveleetcode")); // 2
        System.out.println(f.firstUniqChar("aabb")); // -1
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] c = s.toCharArray();

        for (char value : c) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        for(int i = 0; i < c.length; i ++){
            if(map.get(c[i]) == 1){
                return i;
            }
        }
        return -1;
    }
}
