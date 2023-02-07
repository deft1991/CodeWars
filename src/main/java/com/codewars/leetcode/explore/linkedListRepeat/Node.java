package com.codewars.leetcode.explore.linkedListRepeat;

/**
 * @author Sergey Golitsyn
 * created on 03.12.2021
 */
public class Node {
   public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
