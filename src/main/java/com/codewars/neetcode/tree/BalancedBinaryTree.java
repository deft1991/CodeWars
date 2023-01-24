package com.codewars.neetcode.tree;

import com.codewars.leetcode.explore.TraverseATree.TreeNode;

/**
 * @author Sergey Golitsyn
 * created on 19.01.2023
 */
public class BalancedBinaryTree {

    public static void main(String[] args) {
        BalancedBinaryTree bal = new BalancedBinaryTree();

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(3);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(4);

        a.left = b;
        a.right = c;

        b.left = d;
        b.right = e;

        d.left = f;
        d.right = g;

        System.out.println(bal.isBalanced(a));
    }

    public boolean isBalanced(TreeNode root) {
        int balance = getBalance(root);
        return balance != -1;
    }

    private int getBalance(TreeNode root) {
        if (root == null){
            return 0;
        }

        int leftBalance = getBalance(root.left);
        if (leftBalance == -1){
            return -1;
        }
        int rightBalance = getBalance(root.right);
        if (rightBalance == -1){
            return -1;
        }

        if (Math.abs(leftBalance - rightBalance) > 1){
            return - 1;
        }

        return Math.max(leftBalance, rightBalance) + 1;
    }

}
