package com.codewars.neetcode.tree;

import com.codewars.leetcode.explore.TraverseATree.TreeNode;

/**
 * @author Sergey Golitsyn
 * created on 30.01.2023
 */
public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        ValidateBinarySearchTree v = new ValidateBinarySearchTree();

        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(3);
        a.left = b;
        a.right = c;

        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(7);
//        c.left = d;
//        c.right = e;

        System.out.println(v.isValidBST(a));
    }

    public boolean isValidBST(TreeNode root) {
        TreeNode dmax = null;
        TreeNode dmin = null;
        return isValidBST(root, dmax,  dmin);
    }

    private boolean isValidBST(TreeNode root, TreeNode leftBound, TreeNode rightBound){
        if (root == null){
            return true;
        }

        if (leftBound != null && root.val <= leftBound.val){
            return false;
        }
        if (rightBound != null && root.val > rightBound.val){
            return false;
        }
        return isValidBST(root.left, leftBound, root)
                && isValidBST(root.right, root, rightBound);
    }
}
