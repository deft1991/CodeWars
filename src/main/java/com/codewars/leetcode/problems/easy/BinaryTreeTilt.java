package com.codewars.leetcode.problems.easy;

/**
 * @author Sergey Golitsyn
 * created on 06.04.2021
 */
public class BinaryTreeTilt {

    public static void main(String[] args) {

    }


    private int totalTilt = 0;

    public int findTilt(TreeNode root) {
        valueSum(root);
        return totalTilt;
    }

    private int valueSum(TreeNode root) {
        if (root == null) {
            return 0;
        }


        int leftTilt = findTilt(root.left);
        int rightTilt = findTilt(root.right);
        totalTilt += Math.abs(leftTilt - rightTilt);
        return root.val + leftTilt + rightTilt;
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
