package com.codewars.faangtalk;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 11.09.2023
 */
public class ImplementTrie {

    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("word");
        System.out.println(t.search("word"));
        System.out.println(t.search("qwe"));
        System.out.println(t.startsWith("wo"));
        System.out.println(t.startsWith("wd"));
    }
}

class Trie {

    private Character val;
    private boolean isEnd;
    private Map<Character, Trie> map;

    public Trie() {
        this.val = ' ';
        this.map = new HashMap<>();
    }

    public Trie(Character ch){
        this.val = ch;
        this.map = new HashMap<>();
    }

    public void insert(String word) {
        Trie cur = this;
        for(char c : word.toCharArray()){
            if(cur.map.containsKey(c)){
                cur = map.get(c);
            } else {
                Trie t = new Trie(c);
                cur.map.put(c, t);
                cur = t;
            }
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        Trie cur = this;
        for(char c : word.toCharArray()){
            if(cur.map.containsKey(c)){
                cur = cur.map.get(c);
            } else {
                return false;
            }
        }
        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie cur = this;
        for(char c : prefix.toCharArray()){
            if(cur.map.containsKey(c)){
                cur = cur.map.get(c);
            } else {
                return false;
            }
        }
        return true;
    }


}
