package com.codewars.pramp;

/**
 * @author Sergey Golitsyn
 * created on 14.07.2023
 */
public class LargestSmallerBST {

    public static void main(String[] args) {
        LargestSmallerBST s = new LargestSmallerBST();
        Node a = new Node(8);
        Node b = new Node(6);
        Node c = new Node(12);

        Node d = new Node(4);
        Node e = new Node(5);

        Node f = new Node(10);
        Node g = new Node(13);
        a.left = b;
        a.right = c;

        b.left = d;
        b.right = e;

        c.left = f;
        c.right = g;
        System.out.println(s.findSmallestNode(a, 11)); // 10
        System.out.println(s.findSmallestNode(a, 12)); // 0
        System.out.println(s.findSmallestNode(a, 13)); // 12

        System.out.println(s.findSmallestNode(a, 10)); // 12
        System.out.println(s.findSmallestNode(a, 8)); // 6
        System.out.println(s.findSmallestNode(a, 7)); // 8

//        System.out.println(s.findSmallestNode(a, 5)); // 4
//        System.out.println(s.findSmallestNode(a, 4)); // -1
    }

    /*

    smalest node bigger that target

      8
   6    12
 4   10   13
1 4.5
target = 6 -> 1
target = 7 -> 6
target = 11 -> 10


prev
if target > root
 move right
if target < root
 move left

     */

    public int findSmallestNode(Node root, int target) {
        return findSmallestNode(root, target, false);
    }

    public int findSmallestNode(Node root, int target, boolean isLeft) {

        int rez = -1;

        while (root != null){
            if (root.val >= target){
                root = root.left;
            } else {
                rez = Math.max(rez, root.val);
                root = root.right;
            }
        }
        return rez;
    }


    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

}
