package com.codewars.leetcode.daily;

import com.codewars.leetcode.handbook.ListNode;

/**
 * @author Sergey Golitsyn
 * created on 22.03.2024
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {
        PalindromeLinkedList p = new PalindromeLinkedList();

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(2);
        ListNode f = new ListNode(1);

        a.next = b;
        b.next = c;
//        b.next = d;
        c.next = d;
        d.next = e;
        e.next = f;

        System.out.println(p.isPalindrome(a));
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null){
            slow = slow.next;
        }
        ListNode reverse = getReverse(slow);

        while(reverse != null){
            if(head.val != reverse.val){
                return false;
            }
            reverse = reverse.next;
            head = head.next;
        }

        return true;
    }

    private ListNode getReverse(ListNode slow){
        ListNode prev = null;
        ListNode cur = slow;
        ListNode next = slow.next;

        while(next != null && next != slow){
            cur.next = prev;
            prev = cur;
            cur = next;
            next = next.next;
        }
        cur.next = prev;
        return cur;
    }
}
