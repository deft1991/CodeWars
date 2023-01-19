package com.codewars.neetcode.linkedList;

import com.codewars.leetcode.explore.linkedListRepeat.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Sergey Golitsyn
 * created on 09.01.2023
 */
public class CopyListWithRandomPointer {

    public static void main(String[] args) {
        Node head = new Node(7);
        Node a = new Node(13);
        Node b = new Node(11);
        Node c = new Node(10);
        Node d = new Node(1);

        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = null;

        head.random = null;
        a.random = head;
        b.random = d;
        c.random = b;
        d.random = a;

        CopyListWithRandomPointer cl = new CopyListWithRandomPointer();
        Node rez = cl.copyRandomList(head);
        System.out.println(rez);
    }

    public Node copyRandomList(Node head) {

        Node dummy = new Node(0);
        Node dummyHead = dummy;
        Map<Node, Node> map = new HashMap<>();
        Node tmp = head;

        while (tmp != null){
            Node n = new Node(tmp.val);
            dummy.next = n;
            dummy = dummy.next;
            map.put(tmp, n);

            tmp = tmp.next;
        }

        dummy = dummyHead.next;

        while (head != null){
            if (head.random != null){
                dummy.random = map.get(head.random);
            }
            head = head.next;
            dummy = dummy.next;
        }
        return dummyHead.next;
    }
}
