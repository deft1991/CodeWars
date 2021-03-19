package com.codewars.leetcode.problems.easy;

/**
 * @author Sergey Golitsyn
 * created on 19.03.2021
 */
public class MergeTwoBinaryTrees {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(2);
        a.left = b;
        a.right = c;
        TreeNode d = new TreeNode(5);
        b.left = d;

        TreeNode x = new TreeNode(2);
        TreeNode y = new TreeNode(1);
        TreeNode z = new TreeNode(3);
        x.left = y;
        x.right = z;
        TreeNode w = new TreeNode(4);
        y.right = w;
        TreeNode q = new TreeNode(7);
        z.right = q;

        MergeTwoBinaryTrees m = new MergeTwoBinaryTrees();
        TreeNode treeNode = m.mergeTrees(a, x);
        System.out.println();

    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root2 == null) {
            return root1;
        }
        if (root1 == null) {
            return root2;
        }

        root1.val += root2.val;

        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }


    public static class TreeNode {
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
