package com.codewars.leetcode.problems.easy;

/**
 * @author Sergey Golitsyn
 * created on 24.08.2022
 */
public class DiameterBinaryTree {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);
        TreeNode rightL = new TreeNode(4);
        TreeNode rightR = new TreeNode(5);

        root1.left = left1;
        root1.right = right1;
        left1.left = rightL;
        left1.right = rightR;

        System.out.println(diameterOfBinaryTree(root1));
    }

    public static int MAX = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return MAX;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        MAX = Math.max(MAX, left + right);
        return Math.max(left, right) + 1;
    }
}
