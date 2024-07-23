package com.codewars.leetcode.daily;

import com.codewars.leetcode.explore.TraverseATree.TreeNode;

/**
 * @author Sergey Golitsyn
 * created on 17.04.2024
 */
public class SmallestStringStartingFromLeaf {

    public static void main(String[] args) {
        SmallestStringStartingFromLeaf s = new SmallestStringStartingFromLeaf();

        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(0);
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(1);

        a.left = b;
        a.right = c;

        b.right = d;

        System.out.println(s.smallestFromLeaf(a));
    }

    public String smallestFromLeaf(TreeNode root) {
        return small(root);
    }

    private String small(TreeNode root) {
        if (root == null) {
            return "ZZZ";
        }
        if (root.left == null && root.right == null) {
            return "" + (char) (root.val + 'a');
        }
        String left = small(root.left);
        String right = small(root.right);
        String cur = "" + (char) (root.val + 'a');

        if (left.equals("ZZZ")) {
            return right + cur;
        }
        if (right.equals("ZZZ")) {
            return left + cur;
        }

        return left.compareTo(right) <= 0 ? left + cur : right + cur;
    }
}
