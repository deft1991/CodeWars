package com.codewars.leetcode.problems.easy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
 * Created by sgolitsyn on 4/8/20
 *
 * Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.


 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"dog", "dogma", "doctrina"}));
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));

    }

    public String longestCommonPrefix2(String[] strs) {
        Node node = prepareNode(strs);
        return getCommonPrefix(node.maxNode, node.maxNode.count);
    }

    private String getCommonPrefix(Node maxNode, int count) {
        String pref = String.valueOf(maxNode.nodeValue);
        Node current = maxNode;
        boolean isChanged = false;
        while (!current.nodes.values().isEmpty()) {
            isChanged = false;
            Collection<Node> values = current.nodes.values();
            for (Node n : values) {
                if (n.count == count) {
                    pref += n.nodeValue;
                    current = n;
                    isChanged = true;
                    break;
                }
            }
            if (!isChanged) {
                break;
            }
        }
        return pref;
    }


    private Node prepareNode(String[] strs) {
        Node baseNode = new Node(null);
        baseNode.maxNode = baseNode;
        for (String str : strs) {
            Node current = baseNode;
            for (Character c : str.toCharArray()) {
                Node node = new Node(c);
                node.count = 1;
                if (current.nodes.isEmpty()) {
                    current.nodes.put(c, node);
                    current = node;
                    baseNode.maxNode = baseNode.maxNode.count > current.count ? baseNode.maxNode : current;
                }
                while (!current.nodes.isEmpty()) {
                    if (current.nodes.containsKey(c)) {
                        current = current.nodes.get(c);
                        current.count += 1;
                    } else {
                        current.nodes.put(c, node);
                        current = node;
                    }
                    baseNode.maxNode = baseNode.maxNode.count >= current.count ? baseNode.maxNode : current;
                    break;
                }
            }
        }
        return baseNode;
    }

    class Node {
        Map<Character, Node> nodes = new HashMap();
        Character nodeValue;
        int count;
        Node maxNode;

        public Node() {
        }

        public Node(Character nodeValue) {
            this.nodeValue = nodeValue;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return nodeValue.equals(node.nodeValue);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nodeValue);
        }
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

}
