package com.codewars.neetcode.linkedList;

import com.codewars.leetcode.handbook.ListNode;

/**
 * @author Sergey Golitsyn
 * created on 04.01.2023
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ReverseLinkedList r = new ReverseLinkedList();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;
        ListNode c = new ListNode(3);
        b.next = c;

        ListNode listNode = ReverseLinkedList.reverseList(a);
        System.out.println(listNode);


    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }

        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head;
        while (next != null){
            cur = next;
            next = cur.next;
            cur.next = prev;
            prev = cur;
        }
        return cur;
    }
}
