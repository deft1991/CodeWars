package com.codewars.neetcode.tree;

import com.codewars.leetcode.explore.TraverseATree.TreeNode;

/**
 * @author Sergey Golitsyn
 * created on 03.10.2023
 */
public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {
        BinaryTreeMaximumPathSum bin = new BinaryTreeMaximumPathSum();

        TreeNode a = new TreeNode(-1);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(-6);
        TreeNode d = new TreeNode(3);
        a.right = b;
        b.left = c;
        b.right = d;

        System.out.println(bin.maxPathSum(a));
    }

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        int dfs = dfs(root);
        max = Math.max(max, dfs);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        int leftMax = Math.max(left, 0);
        int rightMax = Math.max(right, 0);

        int endSum = root.val + left + right;
        max = Math.max(max, endSum);

        return root.val + Math.max(leftMax, rightMax);
    }
}
