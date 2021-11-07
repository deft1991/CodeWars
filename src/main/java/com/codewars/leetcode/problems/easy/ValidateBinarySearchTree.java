package com.codewars.leetcode.problems.easy;

/**
 * @author Sergey Golitsyn
 * created on 07.05.2021
 */
public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        ValidateBinarySearchTree v = new ValidateBinarySearchTree();

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(4, new TreeNode(3), new TreeNode(6));
        TreeNode c = new TreeNode(5, a, b);
        System.out.println(v.isValidBST(c));

        TreeNode one = new TreeNode(0);
        System.out.println(v.isValidBST(one));

        TreeNode two = new TreeNode(1, new TreeNode(1), null);
        System.out.println(v.isValidBST(two));
    }


    int lastVisited = Integer.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        lastVisited = Integer.MIN_VALUE;
        return dfs(root);
    }

    public boolean dfs(TreeNode node) {
        if (node == null) {
            return true;
        }

        if (!dfs(node.left)) {
            return false;
        }
        if (node.val <= lastVisited) {
            return false;
        }
        lastVisited = node.val;

        return dfs(node.right);
    }
}
