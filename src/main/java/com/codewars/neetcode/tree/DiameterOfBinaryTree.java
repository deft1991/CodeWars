package com.codewars.neetcode.tree;

import com.codewars.leetcode.explore.TraverseATree.TreeNode;

/**
 * @author Sergey Golitsyn
 * created on 17.01.2023
 */
public class DiameterOfBinaryTree {

    public static void main(String[] args) {

    }

    private int MAX = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return MAX;
    }

    private int maxDepth(TreeNode root){
        if (root == null){
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        MAX = Math.max(MAX, left + right);
        return Math.max(left, right) + 1;
    }
}
