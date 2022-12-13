package com.codewars.neetcode.arraysAndHashing;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 02.12.2022
 * <p>
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();

        String[] strings = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = ga.groupAnagrams(strings);
        System.out.println();
        strings = new String[]{""};
        List<List<String>> lists1 = ga.groupAnagrams(strings);
        System.out.println();
        strings = new String[]{"a"};
        List<List<String>> lists2 = ga.groupAnagrams(strings);
        System.out.println();


    }


    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = String.valueOf(chars);
            if (map.containsKey(sorted)) {
                map.get(sorted).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(sorted, list);
            }
        }

        return new ArrayList<>(map.values());
    }
}
