package com.codewars.leetcode.topInterviewQuestions.hard;

import com.codewars.leetcode.handbook.ListNode;

/*
 * Created by sgolitsyn on 8/26/20
 *
 Given an array of linked-lists lists,
 each linked list is sorted in ascending order.

Merge all the linked-lists into one sort linked-list and return it.



Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []


Constraints:

k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] is sorted in ascending order.
The sum of lists[i].length won't exceed 10^4.
 */
public class MergeKSortedLists {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;

        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(2);
        ListNode n6 = new ListNode(3);
        n4.next = n5;
        n5.next = n6;

        ListNode n7 = new ListNode(1);
        ListNode n8 = new ListNode(2);
        ListNode n9 = new ListNode(3);
        n7.next = n8;
        n8.next = n9;


        MergeKSortedLists m = new MergeKSortedLists();
        ListNode listNode = m.mergeKLists(new ListNode[]{n1, n4, n7});
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode rez = lists.length % 2 > 0 ? lists[lists.length - 1] : null;

        for (int i = 0; i < lists.length - 1; i += 2) {
            ListNode first = lists[i];
            ListNode second = lists[i + 1];

            ListNode tmp = merge(first, second);
            rez = merge(rez, tmp);
        }

        return rez;
    }

    private ListNode merge(ListNode first, ListNode second) {
        ListNode rez = new ListNode();
        ListNode head = rez;
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }

        while (first != null && second != null) {
            if (first.val >= second.val) {
                rez.next = second;
                second = second.next;
            } else {
                rez.next = first;
                first = first.next;
            }
            rez = rez.next;
        }
        while (first != null) {
            rez.next = first;
            first = first.next;
            rez = rez.next;
        }
        while (second != null) {
            rez.next = second;
            second = second.next;
            rez = rez.next;
        }
        return head.next;
    }
}
