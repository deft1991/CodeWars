package com.codewars.leetcode.explore.linkedList;

/**
 * @author Sergey Golitsyn
 * created on 31.01.2021
 */
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int val) {
        this.val = val;
    }

    public Node() {
    }
}
