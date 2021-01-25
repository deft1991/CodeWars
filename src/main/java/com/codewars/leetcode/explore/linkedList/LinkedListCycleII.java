package com.codewars.leetcode.explore.linkedList;

import com.codewars.leetcode.problems.ListNode;

/**
 * @author Sergey Golitsyn
 * created on 24.01.2021
 * <p>
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * <p>
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * <p>
 * Notice that you should not modify the linked list.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * Example 2:
 * <p>
 * <p>
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 * Example 3:
 * <p>
 * <p>
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of the nodes in the list is in the range [0, 104].
 * -105 <= Node.val <= 105
 * pos is -1 or a valid index in the linked-list.
 * <p>
 * <p>
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?
 */
public class LinkedListCycleII {

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
        ListNode six = new ListNode(6);
        five.next = six;
        ListNode seven = new ListNode(7);
        six.next = seven;
        ListNode eight = new ListNode(8);
        seven.next = eight;
        eight.next = three;

//        ListNode listNode = detectCycle(one);
//        System.out.println(listNode.val);

        one = new ListNode(3);
        two = new ListNode(2);
        one.next = two;
        three = new ListNode(0);
        two.next = three;
        four = new ListNode(-4);
        three.next = four;
        four.next = two;

        ListNode listNode = detectCycle(one);
        System.out.println(listNode.val);
    }

    public static ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow.val == fast.val) {
                break;
            }
        }

        slow = head;
        while (slow != fast) {
            if (fast == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
