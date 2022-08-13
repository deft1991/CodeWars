package com.codewars.leetcode.problems.easy;

import com.codewars.leetcode.handbook.ListNode;

/**
 * @author Sergey Golitsyn
 * created on 10.08.2022
 */
public class RemoveLinkedListElements {

    public static void main(String[] args) {
        ListNode head = new ListNode(7);
        ListNode a = new ListNode(7);
        ListNode b = new ListNode(7);
        ListNode c = new ListNode(7);
        ListNode d = new ListNode(7);
        ListNode e = new ListNode(7);
        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        System.out.println(removeElements(head, 7));
    }

    public static ListNode removeElements(ListNode head, int val) {

        ListNode dymmyHead = new ListNode();
        ListNode dymmyTail = dymmyHead;
        dymmyTail.next = head;

        while(dymmyTail != null){
            if (dymmyTail.next != null && dymmyTail.next.val == val){
                dymmyTail.next = dymmyTail.next.next;
            } else {
                dymmyTail = dymmyTail.next;
            }
        }
        return dymmyHead.next;
    }
}
