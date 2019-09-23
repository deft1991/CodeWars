package com.codewars.hackerRank;

import java.util.Scanner;

public class MyNode {

    private static class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node insert(Node head, int data) {
        //Complete this method
        Node n = new Node(data);
        if (head == null) {
            head = n;
        } else {
            Node nextMy = head.next;
            if (head.next == null) {
                head.next = n;
            } else {
                Node prev = null;
                while (nextMy != null) {
                    prev = nextMy;
                    nextMy = nextMy.next;
                }
                prev.next = n;
            }

        }
        return head;
    }

    public static void display(Node head) {
        Node start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int N = sc.nextInt();

        while (N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head, ele);
        }
        display(head);
        sc.close();
    }
}
