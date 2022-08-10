package com.codewars.leetcode.days21;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Sergey Golitsyn
 * created on 29.03.2022
 */
public class PopulatingNextRightPointersInEachNodeII {

    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNodeII p = new PopulatingNextRightPointersInEachNodeII();

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
//        c.left = f;
        c.right = g;

        p.connect(a);
    }


    public Node connect(Node root) {

        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Node> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node n = q.poll();

                if (q.peek() != null){
                    n.next = q.peek();
                }

                if (n.left != null) {
                    list.add(n.left);
                }
                if (n.right != null) {
                    list.add(n.right);
                }
            }
            q.addAll(list);
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
}
