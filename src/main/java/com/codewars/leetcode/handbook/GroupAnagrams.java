package com.codewars.leetcode.handbook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Created by sgolitsyn on 6/8/20
 *
 *
 *
 * Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();

        List<List<String>> lists = groupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});

        lists.forEach(System.out::println);
    }


    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> anagrams = new HashMap<>();

        for(String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = String.valueOf(chars);
            if(!anagrams.containsKey(sorted)){
                anagrams.put(sorted, new ArrayList<>());
            }
            anagrams.get(sorted).add(s);
        }
        return new ArrayList<>(anagrams.values());
    }
}
