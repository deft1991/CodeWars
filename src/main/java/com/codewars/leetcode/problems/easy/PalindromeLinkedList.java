package com.codewars.leetcode.problems.easy;

import com.codewars.leetcode.handbook.ListNode;

import java.util.Stack;

/**
 * @author Sergey Golitsyn
 * created on 28.08.2022
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(1);
//        a.next = b;
//        b.next = c;
//        c.next = d;
        System.out.println(isPalindrome(a));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;

        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null){
            slow = slow.next;
        }

        ListNode rev = reverse(slow);

        while(rev != null){
            if(head.val != rev.val){
                return false;
            }
            rev = rev.next;
            head = head.next;
        }
        return true;
    }

    private static ListNode reverse(ListNode slow) {

        ListNode prev = null;
        ListNode cur = slow;
        ListNode next = slow.next;

        while(next != null){
            cur.next = prev;
            prev = cur;
            cur = next;
            next = next.next;
        }
        cur.next = prev;

        return cur;
    }

    public static boolean isPalindrome2(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            stack.add(slow);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null){
            slow = slow.next;
        }

        while(!stack.isEmpty()){
            ListNode pop = stack.pop();
            if (pop.val != slow.val){
                return false;
            }
            slow = slow.next;
        }

        return true;
    }
}
