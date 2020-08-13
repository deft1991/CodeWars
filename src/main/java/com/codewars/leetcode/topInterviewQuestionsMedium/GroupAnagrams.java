package com.codewars.leetcode.topInterviewQuestionsMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
 * Created by sgolitsyn on 8/13/20
 *
Given an array of strings, group anagrams together.

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
        lists.forEach(list -> System.out.println(Arrays.toString(list.toArray())));
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String s :
                strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);

            List<String> strings = map.get(String.valueOf(chars));
            if (strings != null){
                strings.add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(String.valueOf(chars), list);
            }
        }

        return new ArrayList<>(map.values());

    }
}
