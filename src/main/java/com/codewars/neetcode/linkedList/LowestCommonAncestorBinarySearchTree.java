package com.codewars.neetcode.linkedList;

import com.codewars.leetcode.explore.TraverseATree.TreeNode;

/**
 * @author Sergey Golitsyn
 * created on 24.01.2023
 */
public class LowestCommonAncestorBinarySearchTree {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(6);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(8);

        a.left = b;
        a.right = c;

//        TreeNode d = new TreeNode(0);
//        TreeNode e = new TreeNode(4);

//        b.left = d;
//        b.right = e;

//        TreeNode f = new TreeNode(7);
//        TreeNode g = new TreeNode(9);

//        c.left = f;
//        c.right = g;

//        TreeNode h = new TreeNode(3);
//        TreeNode i = new TreeNode(5);

//        e.left = h;
//        e.right = i;

        LowestCommonAncestorBinarySearchTree l = new LowestCommonAncestorBinarySearchTree();

//        TreeNode treeNode1 = l.lowestCommonAncestor(a, b, c);
//        TreeNode treeNode2 = l.lowestCommonAncestor(a, b, e);
//        TreeNode treeNode3 = l.lowestCommonAncestor(a, d, i);
        TreeNode treeNode4 = l.lowestCommonAncestor(a, b, c);
        System.out.println();

    }

    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);

        while (root != null) {
            if (root.val < min) {
                root = root.right;
            } else if (root.val > max) {
                root = root.left;
            } else {
                return root;
            }
        }
        return null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode min;
        TreeNode max;
        if (p.val > q.val) {
            min = q;
            max = p;
        } else {
            min = p;
            max = q;
        }

        return lowestCommonAncestor2(root, min, max);
    }

    private TreeNode lowestCommonAncestor2(TreeNode root, TreeNode min, TreeNode max) {
        if (root == min || root == max) {
            return root;
        }

        if (root.val > max.val) {
            root = lowestCommonAncestor2(root.left, min, max);
        }
        if (root.val < min.val) {
            root = lowestCommonAncestor2(root.right, min, max);
        }

        return root;
    }
}
