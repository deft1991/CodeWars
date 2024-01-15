package com.codewars.leetcode.daily;

import com.codewars.leetcode.explore.TraverseATree.TreeNode;

/**
 * @author Sergey Golitsyn
 * created on 11.01.2024
 */
public class MaximumDifferenceBetweenNodeAncestor {

    public static void main(String[] args) {

    }

    int diff = 0;
    public int maxAncestorDiff(TreeNode root) {

        dfs(root, root.val, root.val);

        return diff;
    }

    private void dfs(TreeNode root, int min, int max){
        if (root == null){
            return;
        }

        int maxDiff = Math.max(Math.abs(min - root.val), Math.abs(max - root.val));
        diff = Math.max(diff, maxDiff);
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);

        dfs(root.left, min, max);
        dfs(root.right, min, max);
    }
}
