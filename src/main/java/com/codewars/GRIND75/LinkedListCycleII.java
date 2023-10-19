package com.codewars.GRIND75;

import com.codewars.leetcode.handbook.ListNode;

/**
 * @author Sergey Golitsyn
 * created on 11.09.2023
 */
public class LinkedListCycleII {

    public static void main(String[] args) {
        LinkedListCycleII l = new LinkedListCycleII();

        ListNode a = new ListNode(3);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(4);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = b;


    }

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow){
                break;
            }
        }
        if(fast == null || fast.next == null){
            return null;
        }
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }

        return fast;

    }
}
