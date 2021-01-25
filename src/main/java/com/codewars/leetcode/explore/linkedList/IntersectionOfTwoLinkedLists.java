package com.codewars.leetcode.explore.linkedList;

import com.codewars.leetcode.problems.ListNode;

/**
 * @author Sergey Golitsyn
 * created on 24.01.2021
 *
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * For example, the following two linked lists:
 *
 *
 * begin to intersect at node c1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * Output: Reference of the node with value = 8
 * Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 *
 *
 * Example 2:
 *
 *
 * Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Reference of the node with value = 2
 * Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 *
 *
 * Example 3:
 *
 *
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: null
 * Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
 * Explanation: The two lists do not intersect, so return null.
 *
 *
 * Notes:
 *
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Each value on each linked list is in the range [1, 10^9].
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        // first of all lets check that our lists have intersection
        // and their size

        int sizeA = 0;
        int sizeB = 0;

        ListNode a = headA;
        while (a.next != null) {
            sizeA++;
            a = a.next;
        }

        ListNode b = headB;
        while (b.next != null) {
            sizeB++;
            b = b.next;
        }

        // if a and b have diff nodes in the end
        // that is mean that list have no intersection
        if (a != b) {
            return null;
        }

        a = headA;
        b = headB;

        // move longest list for make list size same
        if (sizeA > sizeB) {
            for (int i = 0; i < sizeA - sizeB; i++) {
                a = a.next;
            }
        } else {
            for (int i = 0; i < sizeB - sizeA; i++) {
                b = b.next;
            }
        }

        // find common node
        while (a != b) {
            a = a.next;
            b = b.next;
        }
        return a;
    }
}
