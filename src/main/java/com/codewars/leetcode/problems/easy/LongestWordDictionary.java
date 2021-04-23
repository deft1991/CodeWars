package com.codewars.leetcode.problems.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 23.04.2021
 */
public class LongestWordDictionary {

    public static void main(String[] args) {

        LongestWordDictionary l = new LongestWordDictionary();

        System.out.println(l.longestWord(new String[]{"w", "wo", "wor", "worl", "world"}));
        System.out.println(l.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
        System.out.println(l.longestWord(new String[]{"ogz", "eyj", "e", "ey", "hmn", "v", "hm", "ogznkb", "ogzn", "hmnm", "eyjuo", "vuq", "ogznk", "og", "eyjuoi", "d"}));
    }

    public String longestWord(String[] words) {

        Arrays.sort(words);

        Trie root = new Trie(null);

        for (String s : words) {
            Trie current = root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (current.contains(c)) {
                    current = current.get(c);
                } else {
                    if (i == s.length() - 1) {
                        current.add(c);
                    }
                    break;
                }
            }
        }

        return findLongest(root).trim();
    }

    private String findLongest(Trie root) {

        if (root.child.isEmpty()) {
            return root.value.toString();
        }


        String rez = "";
        String longest = "";
        for (Trie trie : root.child.values()) {
            String childsVal = findLongest(trie);
            if (childsVal.length() > longest.length()) {
                longest = childsVal;
            } else if (childsVal.length() == longest.length() && childsVal.compareTo(longest) < 0) {
                longest = childsVal;
            }
        }
        rez += (root.value == null ? "" : root.value) + longest;
        return rez;
    }

    class Trie {

        Character value;
        Map<Character, Trie> child;

        Trie(Character val) {
            value = val;
            child = new HashMap<>();
        }

        public boolean contains(Character c) {
            return child.containsKey(c);
        }

        public Trie get(Character c) {
            return child.get(c);
        }

        public void add(Character c) {
            child.put(c, new Trie(c));
        }
    }
}
