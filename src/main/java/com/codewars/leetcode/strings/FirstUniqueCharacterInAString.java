package com.codewars.leetcode.strings;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by sgolitsyn on 1/13/20
 *
 *
 Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
 */
public class FirstUniqueCharacterInAString {

    public static void main(String[] args) {
        FirstUniqueCharacterInAString f = new FirstUniqueCharacterInAString();
        System.out.println(f.firstUniqChar("loveleetcode"));
    }

    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (char aChar : chars) {
            map.put(aChar, map.getOrDefault(aChar,0) + 1);
        }

        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}
