package com.codewars.leetcode.daily;

import com.codewars.leetcode.handbook.ListNode;

/**
 * @author Sergey Golitsyn
 * created on 03.03.2024
 */
public class RemoveNthNodeFromEndofList {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        RemoveNthNodeFromEndofList r = new RemoveNthNodeFromEndofList();

        ListNode listNode = r.removeNthFromEnd(a, 2);
        while(listNode != null){
            System.out.print(listNode.val + " --> ");
            listNode = listNode.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode start = dummy;
        ListNode end = dummy;

        for(int i = 0; i < n; i++){
            if(end != null) {
                end = end.next;
            } else {
                return head;
            }
        }

        while(end.next != null){
            start = start.next;
            end = end.next;
        }

        start.next = start.next.next;
        return dummy.next;
    }
}
