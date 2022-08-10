package com.codewars.leetcode.days21;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Sergey Golitsyn
 * created on 24.03.2022
 */
public class PopulatingNextRightPointersInEachNode {

    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNode p = new PopulatingNextRightPointersInEachNode();

        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);

        a.left = b;
        a.right = c;

        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        p.connect(a);
    }

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> q = new ArrayDeque<>();

        q.add(root);

        while (!q.isEmpty()) {

            List<Node> tmp = new ArrayList<>();
            while (!q.isEmpty()) {
                Node cur = q.poll();
                if (q.peek() != null) {
                    cur.next = q.peek();
                }
                if (cur.left != null) {
                    tmp.add(cur.left);
                    tmp.add(cur.right);
                }
            }
            q.addAll(tmp);
        }
        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;
}
