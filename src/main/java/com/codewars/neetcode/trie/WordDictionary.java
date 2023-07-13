package com.codewars.neetcode.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 07.02.2023
 */
public class WordDictionary {

    public static void main(String[] args) {
        WordDictionary w = new WordDictionary();
//        w.addWord("bad");
//        w.addWord("mad");
//        w.addWord("wykzbvwdsoyfowqicymzd");
//        w.addWord("xajbtjyjuwgoynjgu");
//        w.addWord("xgvk");
        w.addWord("a");
//        System.out.println(w.search("pad")); // false
//        System.out.println(w.search("bad")); // true
//        System.out.println(w.search(".ad")); // true
//        System.out.println(w.search("b.d")); // true
//        System.out.println(w.search("...")); // true
//        System.out.println(w.search("wykzbvwdso..owqicymzd")); // true
        System.out.println(w.search(".a")); // true
        System.out.println(w.search(".")); // true
        System.out.println(w.search("..")); // true
    }

    private TrieNode node;

    public WordDictionary() {
        node = new TrieNode('*');
    }

    public void addWord(String word) {
        TrieNode head = node;
        for (char c : word.toCharArray()) {
            if (head.nodes.containsKey(c)) {
                head = head.nodes.get(c);
            } else {
                TrieNode trieNode = new TrieNode(c);
                head.nodes.put(c, trieNode);
                head = trieNode;
            }
        }
        head.isLast = true;
    }

    public boolean search(String word) {
        return search(node, word);
    }

    public boolean search(TrieNode trieNode, String word) {
        TrieNode head = trieNode;
        TrieNode lastChecked = trieNode;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '.') {
                if (i == chars.length - 1) {
                    // last char
                    return head.nodes.values().stream().anyMatch(cc -> cc.isLast);
                }
                for (TrieNode tmp : head.nodes.values()) {
                    boolean isMatch = search(tmp, word.substring(i + 1));
                    if (isMatch){
                        return true;
                    }
                }
                return false;
            } else {
                if (head.nodes.containsKey(c)) {
                    lastChecked = head.nodes.get(c);
                    head = head.nodes.get(c);
                } else {
                    return false;
                }
            }
        }
        return lastChecked.isLast;

    }

    private class TrieNode {
        char val;
        Map<Character, TrieNode> nodes;

        boolean isLast;

        TrieNode(char val) {
            this.val = val;
            this.nodes = new HashMap<>();
        }
    }
}
