package com.codewars.neetcode.linkedList;

import com.codewars.leetcode.handbook.ListNode;

/**
 * @author Sergey Golitsyn
 * created on 04.01.2023
 */
public class ReorderList {

    public static void main(String[] args) {
        ReorderList r = new ReorderList();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;

        r.reorderList(a);
        System.out.println();
    }

    public void reorderList(ListNode head) {
        if (head != null) {
            ListNode middle = getMiddleNode(head);
            ListNode swapHead = getReverseList(middle);
            ListNode result = mergeNodes(head, swapHead);
            head = result;
        }
    }

    private ListNode mergeNodes(ListNode head, ListNode swapHead) {
        ListNode rez = head;

        while (swapHead != null){
            ListNode next = head.next;
            ListNode next2 = swapHead.next;

            head.next = swapHead;
            swapHead.next = next;

            head = next;
            swapHead = next2;

        }
        head.next = null;
        return rez;
    }

    private ListNode getReverseList(ListNode middle) {

        ListNode prev = null;
        ListNode cur = middle;
        ListNode next = middle;
        while(next != null){
            cur = next;
            next = cur.next;
            cur.next = prev;
            prev = cur;
        }
        return cur;
    }

    private ListNode getMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }
        return slow;
    }
}
