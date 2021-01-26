package com.codewars.leetcode.explore.linkedList;

import com.codewars.leetcode.problems.ListNode;

/**
 * @author Sergey Golitsyn
 * created on 25.01.2021
 * <p>
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * <p>
 * Follow up: Could you do this in one pass?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 * <p>
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 * <p>
 * Input: head = [1,2], n = 1
 * Output: [1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        one.next = two;
        ListNode three = new ListNode(3);
        two.next = three;
        ListNode four = new ListNode(4);
        three.next = four;
        ListNode five = new ListNode(5);
        four.next = five;

        ListNode listNode = removeNthFromEnd(one, 2);

        two.next = null;
        listNode = removeNthFromEnd(one, 1);

        one.next = two;
        two.next = null;
        listNode = removeNthFromEnd(one, 2);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || (head.next == null && n == 1)) {
            return null;
        }

        int deep = 0;
        int remove = remove(head, n, deep);
        remove ++;
        if (remove == n + 1){
            head = head.next;
        }
        return head;
    }

    public static int remove(ListNode node, int n, int deep) {
        if (node == null || deep == -1) {
            return deep;
        }
        deep = remove(node.next, n, deep);
        if (deep == -1){
            return deep;
        }
        deep++;
        if (deep == n + 1) {
            node.next = node.next.next;
            deep = -1;
            return deep;
        }
        return deep;
    }
}

//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode first = dummy;
//        ListNode second = dummy;
//        // Advances first pointer so that the gap between first and second is n nodes apart
//        for (int i = 1; i <= n + 1; i++) {
//            first = first.next;
//        }
//        // Move first to the end, maintaining the gap
//        while (first != null) {
//            first = first.next;
//            second = second.next;
//        }
//        second.next = second.next.next;
//        return dummy.next;
//    }
