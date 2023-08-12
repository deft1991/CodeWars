package com.codewars.GRIND75;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 01.08.2023
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams g = new GroupAnagrams();
        List<List<String>> lists = g.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> dict = new HashMap<>();

        for(String s : strs){
            char[] chars = new char[26];

            for (char c : s.toCharArray()){
                chars[c - 'a']++;
            }
            String word = String.valueOf(chars);
            if (dict.containsKey(word)){
                dict.get(word).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                dict.put(word, list);
            }
        }
        return new ArrayList<>(dict.values());
    }
}
