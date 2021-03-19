package com.codewars.leetcode.problems.easy;

/**
 * @author Sergey Golitsyn
 * created on 19.03.2021
 * <p>
 * Maximum Depth of Binary Tree
 */
public class MaximumDepthBinaryTree {

    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


    public class TreeNode {
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
