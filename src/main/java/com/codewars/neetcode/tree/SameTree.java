package com.codewars.neetcode.tree;

import com.codewars.leetcode.explore.TraverseATree.TreeNode;

/**
 * @author Sergey Golitsyn
 * created on 23.01.2023
 */
public class SameTree {

    public static void main(String[] args) {
        SameTree s = new SameTree();

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(1);

        a.left = b;
        a.right = c;

        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(1);
        TreeNode f = new TreeNode(1);

        d.left = e;
        d.right = f;

        TreeNode g = new TreeNode(1);
        TreeNode h = new TreeNode(1);
        TreeNode i = new TreeNode(2);

        g.left = h;
        g.right = i;

        System.out.println(s.isSameTree(a, a)); // t
        System.out.println(s.isSameTree(a, d)); // t
        System.out.println(s.isSameTree(a, g)); // f
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null) {
            return false;
        }
        if (q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }

        boolean isLeft = isSameTree(p.left, q.left);
        boolean isRight = isSameTree(p.right, q.right);

        return isLeft && isRight;
    }
}
