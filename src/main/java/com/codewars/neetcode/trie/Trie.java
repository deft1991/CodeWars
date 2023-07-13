package com.codewars.neetcode.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 30.01.2023
 */
public class Trie {

    private final TrieNode head;

    public Trie() {
        head = new TrieNode('-');
    }

    public void insert(String word) {
        char[] chars = word.toCharArray();
        TrieNode node = head;
        for (char c : chars) {
            if (node.set.containsKey(c)) {
                node = node.set.get(c);
            } else {
                TrieNode trieNode = new TrieNode(c);
                node.set.put(c, trieNode);
                node = trieNode;
            }
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();

        TrieNode node = head;
        for (char c : chars) {
            if (node.set.containsKey(c)) {
                node = node.set.get(c);
            } else {
                return false;
            }
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();

        TrieNode node = head;
        for (char c : chars) {
            if (node.set.containsKey(c)) {
                node = node.set.get(c);
            } else {
                return false;
            }
        }
        return true;
    }

    private static class TrieNode {
        private char value;
        private Map<Character, TrieNode> set;
        private boolean isEnd;

        TrieNode(char value) {
            this.value = value;
            set = new HashMap<>();
        }
    }
}
