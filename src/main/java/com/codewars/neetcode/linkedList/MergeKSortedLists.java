package com.codewars.neetcode.linkedList;

import com.codewars.leetcode.handbook.ListNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Sergey Golitsyn
 * created on 24.01.2023
 */
public class MergeKSortedLists {

    public static void main(String[] args) {
        MergeKSortedLists m = new MergeKSortedLists();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode listNode = m.mergeKLists(new ListNode[]{a, b, c, d});
        System.out.println();
    }

    public ListNode mergeKLists(ListNode[] lists) {

        Queue<ListNode> queue = new LinkedList<>(Arrays.asList(lists));

        while (!queue.isEmpty() && queue.size() > 1){
            ListNode a = queue.poll();
            ListNode b = queue.poll();
            ListNode c = merge(a, b);
            queue.add(c);
        }
        return queue.poll();
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode c = new ListNode();
        ListNode headC = c;
        while (a != null && b != null){
            if (a.val <= b.val){
                c.next = a;
                a = a.next;
            } else {
                c.next = b;
                b = b.next;
            }
            c = c.next;
        }
        while (a != null){
            c.next = a;
            a = a.next;
            c = c.next;
        }
        while (b != null){
            c.next = b;
            b = b.next;
            c = c.next;
        }
        return headC.next;
    }
}
