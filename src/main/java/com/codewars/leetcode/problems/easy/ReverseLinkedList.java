package com.codewars.leetcode.problems.easy;

import com.codewars.leetcode.handbook.ListNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Sergey Golitsyn
 * created on 11.08.2022
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(5);
        ListNode e = new ListNode(6);
        head.next = a;
//        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = e;
//        ListNode x = reverseList(head);
//        System.out.println(x);
        ListNode x1 = reverseList2(head);
        System.out.println(x1);
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = head;
        ListNode cur = head.next;
        prev.next = null;

        while (cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static ListNode reverseList2(ListNode head) {
        Queue<Integer> q = new LinkedList<>();
        if(head == null || head.next == null){
            return head;
        }

        Stack<ListNode> stack = new Stack<>();
        while (head != null){
            stack.push(head);
            head = head.next;
        }

        ListNode prev = stack.pop();
        prev.next = null;
        ListNode tmpHead = prev;
        while(!stack.isEmpty()){
            ListNode pop = stack.pop();
            prev.next = pop;
            pop.next = null;
            prev = pop;
        }
        return tmpHead;
    }
}
