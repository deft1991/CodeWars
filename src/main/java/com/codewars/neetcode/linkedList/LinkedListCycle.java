package com.codewars.neetcode.linkedList;

import com.codewars.leetcode.handbook.ListNode;

/**
 * @author Sergey Golitsyn
 * created on 09.01.2023
 */
public class LinkedListCycle {

    public static void main(String[] args) {
        LinkedListCycle l = new LinkedListCycle();
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(4);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = b;

        System.out.println(l.hasCycle(a));
    }

    public boolean hasCycle(ListNode head) {

        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null){
            if (slow == fast){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
