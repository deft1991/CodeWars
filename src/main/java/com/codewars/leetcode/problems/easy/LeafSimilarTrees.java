package com.codewars.leetcode.problems.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 12.04.2021
 */
public class LeafSimilarTrees {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(7);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(2, a, b);
        TreeNode d = new TreeNode(6);
        TreeNode e = new TreeNode(5, d, c);
        TreeNode f = new TreeNode(9);
        TreeNode g = new TreeNode(8);
        TreeNode h = new TreeNode(1, f, g);
        TreeNode i = new TreeNode(3, e, h);

        LeafSimilarTrees l = new LeafSimilarTrees();

        System.out.println(l.leafSimilar(i, i));

        TreeNode x = new TreeNode(1);
        TreeNode y = new TreeNode(2);
        System.out.println(l.leafSimilar(x, y));

    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafs1 = new ArrayList<>();
        List<Integer> leafs2 = new ArrayList<>();

        dfs(root1, leafs1);
        dfs(root2, leafs2);

        return leafs1.equals(leafs2);
    }

    private void dfs(TreeNode node, List<Integer> leafs) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            leafs.add(node.val);
            return;
        }

        dfs(node.left, leafs);
        dfs(node.right, leafs);
    }
}
