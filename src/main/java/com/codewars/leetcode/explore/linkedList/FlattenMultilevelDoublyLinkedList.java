package com.codewars.leetcode.explore.linkedList;

/**
 * @author Sergey Golitsyn
 * created on 31.01.2021
 * <p>
 * You are given a doubly linked list which in addition to the next and previous pointers,
 * it could have a child pointer,
 * which may or may not point to a separate doubly linked list.
 * These child lists may have one or more children of their own,
 * and so on, to produce a multilevel data structure,
 * as shown in the example below.
 * <p>
 * Flatten the list so that all the nodes appear in a single-level,
 * doubly linked list. You are given the head of the first level of the list.
 */
public class FlattenMultilevelDoublyLinkedList {

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        a.next = b;
        b.prev = a;
        Node c = new Node(3);
        b.next = c;
        c.prev = b;

        Node d = new Node(4);
        Node e = new Node(5);
        d.next = e;
        e.prev = d;

        b.child = d;

        flatten(a);
    }

    public static Node flatten(Node head) {
        Node headTmp = head;
        if (head == null) {
            return head;
        }

        while (head != null) {
            Node child = head.child;
            Node next = head.next;

            if (child != null) {
                head.next = child;

                while (child.next != null) {
                    child = child.next;
                }
                child.next = next;
                next.prev = child;
            }
            head.child = null;
            head = head.next;
        }
        return headTmp;
    }
}
