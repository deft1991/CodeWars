package com.codewars.neetcode.tree;

import com.codewars.leetcode.explore.TraverseATree.TreeNode;

/**
 * @author Sergey Golitsyn
 * created on 02.11.2023
 */
public class BalancedBinaryTree2 {

    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        return getBalance(root) != -1;
    }

    private int getBalance (TreeNode node){
        if (node == null){
            return 0;
        }
        int left = getBalance(node.left);
        int right = getBalance(node.right);
        if (left == -1 || right == -1){
            return -1;
        }
        int diff = Math.abs(left - right);
        if (diff > 1){
            return -1;
        }

        return Math.max(left, right) + 1;
    }
}
