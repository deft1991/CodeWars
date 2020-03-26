package com.codewars.leetcode.explore.arrays.binaryTree;

/*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * Created by sgolitsyn on 3/25/20
 */
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        ValidateBinarySearchTree v = new ValidateBinarySearchTree();

        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        System.out.println(v.isValidBST(root));


        TreeNode root1 = new TreeNode(5);
        TreeNode left1 = new TreeNode(1);
        TreeNode right1 = new TreeNode(4);
        TreeNode rightL = new TreeNode(3);
        TreeNode rightR = new TreeNode(6);
        root1.left = left1;
        root1.right = right1;
        right1.left = rightL;
        right1.right = rightR;
        System.out.println(v.isValidBST(root1));

        TreeNode root2 = new TreeNode(1);
        TreeNode left2 = new TreeNode(1);
        root2.left = left2;
        System.out.println(v.isValidBST(root2));

    }

    public boolean isValidBST(TreeNode root) {

        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }

        int val = root.val;

        if (lower != null && lower >= val) return false;
        if (upper != null && upper <= val) return false;

        if (!helper(root.left, lower, val)) {
            return false;
        }
        if (!helper(root.right, val, upper)) {
            return false;
        }
        return true;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
