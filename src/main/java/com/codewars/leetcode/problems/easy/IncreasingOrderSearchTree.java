package com.codewars.leetcode.problems.easy;

/**
 * @author Sergey Golitsyn
 * created on 07.04.2021
 */
public class IncreasingOrderSearchTree {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(6);

        a.left = b;
        a.right = c;

        TreeNode d = new TreeNode(2);
        TreeNode e = new TreeNode(4);

        b.left = d;
        b.right = e;

        TreeNode f = new TreeNode(1);

        d.left = f;

        TreeNode g = new TreeNode(8);

        c.right = g;

        TreeNode h = new TreeNode(7);
        TreeNode i = new TreeNode(9);

        g.left = h;
        g.right = i;

        IncreasingOrderSearchTree inc = new IncreasingOrderSearchTree();

        TreeNode treeNode = inc.increasingBST(a);
        System.out.println();

    }

    TreeNode cur;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        cur = ans;
        inOrder(root);
        return ans.right;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);

        root.left = null;
        cur.right = root;
        cur = root;
        inOrder(root.right);


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
