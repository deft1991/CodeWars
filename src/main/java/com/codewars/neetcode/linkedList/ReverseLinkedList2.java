package com.codewars.neetcode.linkedList;

import com.codewars.leetcode.handbook.ListNode;

/**
 * @author Sergey Golitsyn
 * created on 12.07.2023
 */
public class ReverseLinkedList2 {

    public static void main(String[] args) {
        ReverseLinkedList2 r = new ReverseLinkedList2();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        ListNode listNode = r.reverseList(a);
        System.out.println();
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head.next;

        while (next != null){
            cur.next = prev;
            prev = cur;
            cur = next;
            next = next.next;
        }
        cur.next = prev;
        return cur;
    }
}
