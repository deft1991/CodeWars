package com.codewars.neetcode.trie;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 09.10.2023
 */
public class WordSearchII {

    public static void main(String[] args) {
        WordSearchII w = new WordSearchII();

        List<String> words = w.findWords(
                new char[][]{
                        {'a', 'a'},
                },
                List.of("aaa").toArray(new String[0])
        );
        System.out.println(Arrays.toString(words.toArray()));
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode trie = new TrieNode();
        trie.buildTrie(words);

        Set<String> rez = new HashSet<>();
        Set<Pair> visited = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(i, j, board, trie, "", rez, visited);
            }
        }
        return new ArrayList<>(rez);
    }

    private void dfs(int row, int col, char[][] board, TrieNode trie, String curWord, Set<String> rez, Set<Pair> visited) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return;
        }
        char cur = board[row][col];
        Pair pair = new Pair(row, col);
        if (!trie.children.containsKey(cur) || visited.contains(pair)) {
            return;
        }

        trie = trie.children.get(cur);
        curWord += cur;
        if (trie.isEnd) {
            rez.add(curWord);
        }

        visited.add(pair);

        dfs(row - 1, col, board, trie, curWord, rez, visited);
        dfs(row + 1, col, board, trie, curWord, rez, visited);
        dfs(row, col - 1, board, trie, curWord, rez, visited);
        dfs(row, col + 1, board, trie, curWord, rez, visited);

        visited.remove(pair);

    }

    static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public int hashCode() {
            return row + col;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Pair p) {
                return p.col == this.col && p.row == this.row;
            }
            return false;
        }
    }

    static class TrieNode {
        char val;
        boolean isEnd;
        Map<Character, TrieNode> children;

        TrieNode() {
            this.children = new HashMap<>();
        }

        TrieNode(char val) {
            this.val = val;
            this.children = new HashMap<>();
        }

        public void buildTrie(String[] words) {
            for (String word : words) {
                TrieNode head = this;
                for (char c : word.toCharArray()) {
                    if (head.children.containsKey(c)) {
                        head = head.children.get(c);
                    } else {
                        TrieNode node = new TrieNode(c);
                        head.children.put(c, node);
                        head = node;
                    }
                }
                head.isEnd = true;
            }
        }

    }
}
