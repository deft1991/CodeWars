package com.codewars.leetcode.daily;

import com.codewars.leetcode.handbook.ListNode;

/**
 * @author Sergey Golitsyn
 * created on 23.03.2024
 */
public class ReorderList {

    public static void main(String[] args) {
        ReorderList r = new ReorderList();

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        r.reorderList(a);
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null){
            return;
        }
        ListNode mid = getMid(head);
        ListNode rev = getRev(mid);
        ListNode merged = merge(head, rev);
        head = merged;
    }

    /*
       .
    123456
          .
     */
    private ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null){
            slow = slow.next;
        }
        return slow;
    }

    private ListNode getRev(ListNode head){
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
    private ListNode merge(ListNode one, ListNode two){
        ListNode head = one;
        while (two != null){
            ListNode temp = one.next;

            one.next = two;
            one = one.next;
            two = temp;
        }
        one.next = null;
        return head;
    }

}
