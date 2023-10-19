package com.codewars.interview;
import java.io.*;
        import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 18.09.2023
 */


// Main class should be named 'Solution'

class Trie {
    Map<Character, TrieNode> child;

    Trie() {
        this.child = new HashMap<>();
        TrieNode tmp = new TrieNode('-');
        child.put('-', tmp);
    }
}

class TrieNode {
    char val;
    Map<Character, TrieNode> child;

    TrieNode(char val){
        this.val = val;
        child = new HashMap<>();
    }
}

class Gusto {
    public static void main(String[] args) {
         System.out.println("Starting test");
         boolean passes_0 = embolden(
             "123",
             List.of("123")
         ).equals("<b>123</b>");
         System.out.println("Example 1: " + (passes_0 ? "passes" : "fails"));



        boolean passes_1 = embolden(
                "abcxyz",
                new ArrayList<>()
        ).equals("abcxyz");
        System.out.println("Example 1: " + (passes_1 ? "passes" : "fails"));

        // Example 2
        List<String> substrings = new ArrayList<>() {{
            add("abc");
        }};
        boolean passes_2 = embolden("abcxyz", substrings).equals("<b>abc</b>xyz");
        System.out.println("Example 2: " + (passes_2 ? "passes" : "fails"));

        // Example 3
        substrings = new ArrayList<>() {{
            add("abc");
            add("123");
        }};
        boolean passes_3 = embolden("abcxyz123", substrings).equals("<b>abc</b>xyz<b>123</b>");
        System.out.println("Example 3: " + (passes_3 ? "passes" : "fails"));
    }

    public static String embolden(String text, List<String> substrings) {
        Trie trie = prepareTrie(substrings);
        TrieNode root = trie.child.get('-');
        StringBuilder sb = new StringBuilder();

        int start = 0;
        for(int i = 0; i < text.length(); i++){
            int end = i;
            char cur = text.charAt(i);

            if(root.child.containsKey(cur)){
                while(root.child.containsKey(cur)){
                    TrieNode node = root.child.get(cur);
                    if(node.child.isEmpty()){ // last node
                        sb.append("<b>");

                        sb.append(text.substring(start, end+ 1));
                        start = end+1;
                        sb.append("</b>");
                        i = end;
                        node = trie.child.get('-');
                    }
                    root = node;
                    // go to the next character
                    end++;

                    cur = text.charAt(end >= text.length() ? text.length()-1: end);

                }
            } else {
                start++;
                sb.append(cur);
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    private static Trie prepareTrie(List<String> substrings){
        Trie trie = new Trie();
        TrieNode node = trie.child.get('-');
        trie.child.put('-', node);

        for(String str : substrings){
            node = trie.child.get('-');
            for(char c : str.toCharArray()){
                if(node.child.containsKey(c)){
                    node = node.child.get(c);
                } else {
                    TrieNode tmp = new TrieNode(c);
                    node.child.put(c, tmp);
                    node = tmp;
                }
            }
        }
        return trie;
    }
}
