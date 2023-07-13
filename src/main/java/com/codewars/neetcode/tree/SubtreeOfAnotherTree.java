package com.codewars.neetcode.tree;

import com.codewars.leetcode.explore.TraverseATree.TreeNode;

/**
 * @author Sergey Golitsyn
 * created on 23.01.2023
 */
public class SubtreeOfAnotherTree {

    public static void main(String[] args) {

        SubtreeOfAnotherTree s = new SubtreeOfAnotherTree();

        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(5);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(2);

        TreeNode f = new TreeNode(8);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        System.out.println(s.isSubtree(a, b)); // t
        System.out.println(s.isSubtree(a, f)); // t

    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null){
            return false;
        }

        return isEqual(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isEqual(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (subRoot == null) {
            return false;
        }
        if (root.val != subRoot.val) {
            return false;
        }
        boolean isLeft = isEqual(root.left, subRoot.left);
        boolean isRight = isEqual(root.right, subRoot.right);
        return isLeft && isRight;
    }

}
