package com.codewars.leetcode.problems.easy;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 11.03.2021
 */
public class SearchInBinarySearchTree {

    public static void main(String[] args) {

    }

    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null){
            return null;
        }

        if (val > root.val){
            return searchBST(root.right, val);
        } else if (val < root.val){
            return searchBST(root.left, val);
        } else {
            return root;
        }
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
