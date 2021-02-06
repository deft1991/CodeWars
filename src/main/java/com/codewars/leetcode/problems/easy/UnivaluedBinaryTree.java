package com.codewars.leetcode.problems.easy;


/**
 * @author Sergey Golitsyn
 * created on 04.02.2021
 */
public class UnivaluedBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(2);

        root.left = a;
        root.right = b;

        a.left = c;
        a.right = d;

        d.left = e;

        UnivaluedBinaryTree u = new UnivaluedBinaryTree();
        System.out.println(u.isUnivalTree(root));

    }

    public boolean isUnivalTree(TreeNode root) {

        if (root == null) {
            return true;
        }

        int rootVal = root.val;

        return isUnivalTree(root, rootVal);
    }

    private boolean isUnivalTree(TreeNode root, int val) {
        if (root == null) {
            return true;
        }

        if (root.val != val) {
            return false;
        }

        boolean isRight = isUnivalTree(root.right, val);

        if (isRight) {
            return isUnivalTree(root.left, val);
        } else {
            return false;
        }
    }
}
