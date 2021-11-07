package com.codewars.crackingcodeinterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 10.06.2021
 */
public class FindWordInText {

    public static void main(String[] args) {
        SuffixTree suffixTree = new SuffixTree("mississippi");
        System.out.println(suffixTree.getIndexes("is"));
        System.out.println(suffixTree.getIndexes("sip"));
        System.out.println(suffixTree.getIndexes("hi"));
        System.out.println(suffixTree.getIndexes("sis"));
        System.out.println(suffixTree.getIndexes("mis"));
        System.out.println(suffixTree.getIndexes("ppi"));
    }

    static class SuffixTree {
        TrieNode root = new TrieNode();

        SuffixTree(String s) {
            for (int i = 0; i < s.length(); i++) {
                String suffix = s.substring(i);
                root.insert(suffix, i);
            }
        }

        public List<Integer> getIndexes(String s) {
            return root.getIndexes(s);
        }
    }


    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        Character value;
        List<Integer> indexes = new ArrayList<>();

        TrieNode() {
        }

        TrieNode(Character val) {
            this.value = val;
            children = new HashMap<>();
        }


        public void insert(String suffix, int index) {
            indexes.add(index);
            if (suffix != null && suffix.length() > 0) {
                char firstChar = suffix.charAt(0);

                TrieNode child;
                if (children.containsKey(firstChar)) {
                    child = children.get(firstChar);
                } else {
                    child = new TrieNode(firstChar);
                    children.put(firstChar, child);
                }
                String remainder = suffix.substring(1);
                child.insert(remainder, index);
            }
        }

        public List<Integer> getIndexes(String s) {
            if (s == null || s.length() == 0) {
                return indexes;
            } else {
                char firstChar = s.charAt(0);
                if (children.containsKey(firstChar)) {
                    String remainder = s.substring(1);
                    return children.get(firstChar).getIndexes(remainder);
                }
            }
            return null;
        }
    }
}
