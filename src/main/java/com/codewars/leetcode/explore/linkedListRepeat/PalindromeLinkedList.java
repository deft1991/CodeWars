package com.codewars.leetcode.explore.linkedListRepeat;

import com.codewars.leetcode.problems.ListNode;

/**
 * @author Sergey Golitsyn
 * created on 29.11.2021
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null){
            return true;
        }

        ListNode slow = getSecondPartOfList(head);

        ListNode cur = reverseSecondPart(slow);

        while (cur != null && cur.val != -1) {
            if (cur.val != head.val){
                return false;
            }
            cur = cur.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverseSecondPart(ListNode slow) {
        ListNode empty = new ListNode(-1);
        empty.next = slow;

        ListNode prev = empty;
        ListNode cur = slow;
        ListNode next = slow.next;

        while(next != null) {
            cur.next = prev;
            prev = cur;
            cur = next;
            next = next.next;
        }
        cur.next = prev;
        return cur;
    }

    private ListNode getSecondPartOfList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }
        return slow;
    }
}
