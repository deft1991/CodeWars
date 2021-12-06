package com.codewars.leetcode.explore.linkedListRepeat;

import com.codewars.leetcode.handbook.ListNode;

/**
 * @author Sergey Golitsyn
 * created on 22.11.2021
 */
public class LinkedListCycleII {

    public static void main(String[] args) {
        LinkedListCycleII l = new LinkedListCycleII();

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;
        ListNode c = new ListNode(3);
        b.next = c;
        ListNode d = new ListNode(4);
        c.next = d;

        d.next = b;

        l.detectCycle(a);
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;

        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
