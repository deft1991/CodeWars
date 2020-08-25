package com.codewars.leetcode.topInterviewQuestions.easy;

import com.codewars.leetcode.handbook.ListNode;

/*
 * Created by sgolitsyn on 8/20/20
 */
public class LinkedListCycle {

    public static void main(String[] args) {
        LinkedListCycle cicle = new LinkedListCycle();

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;

        System.out.println(cicle.hasCycle(l1));
    }

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            if (slow == fast){
                return true;
            } else {
                slow = slow.next;
            }
        }
        return false;
    }
}
