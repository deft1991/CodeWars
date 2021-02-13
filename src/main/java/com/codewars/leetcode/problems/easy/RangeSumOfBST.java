package com.codewars.leetcode.problems.easy;

/**
 * @author Sergey Golitsyn
 * created on 12.02.2021
 *
 * Given the root node of a binary search tree, return the sum of values of all nodes with a value in the range [low, high].
 *
 * Example 1:
 *
 * Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
 * Output: 32
 * Example 2:
 *
 * Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * Output: 23§
 */
public class RangeSumOfBST {

    public static void main(String[] args) {

        String s = new String("qwe");
        s.hashCode();

        TreeNode a = new TreeNode(10);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(15);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(7);
        TreeNode f = new TreeNode(18);

        a.left = b;
        a.right = c;

        b.left = d;
        b.right = e;

        c.right = f;

//        System.out.println(rangeSumBST(a, 7, 15));

        a = new TreeNode(10);
        b = new TreeNode(5);
        c = new TreeNode(15);
        a.left = b;
        a.right = c;
        d = new TreeNode(3);
        e = new TreeNode(7);
        b.left = d;
        b.right = e;
        f = new TreeNode(1);
        d.left = f;
        f = new TreeNode(6);
        e.left = f;
        TreeNode g = new TreeNode(13);
        TreeNode h = new TreeNode(18);

        c.left = g;
        c.right = h;

        System.out.println(rangeSumBST(a, 6, 10));
    }

    public static int rangeSumBST(TreeNode root, int low, int high) {

        if (root == null){
            return 0;
        }

        int val = root.val;

        if (val < low){
            return rangeSumBST(root.right, low, high);
        }
        if (val > high){
            return rangeSumBST(root.left, low, high);
        }

        return val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
