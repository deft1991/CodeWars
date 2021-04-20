package com.codewars.leetcode.problems.medium;


/**
 * @author Sergey Golitsyn
 * created on 13.04.2021
 */
public class FindCorrespondingNodeBinaryTreeCloneOfThatTree {

    public static void main(String[] args) {

    }

    TreeNode rez = null;

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        dfs(original, cloned, target);
        return rez;
    }

    private void dfs(TreeNode original, TreeNode cloned, TreeNode target) {
        if (original == null) {
            return;
        }

        if (original == target) {
            rez = cloned;
        }

        dfs(original.left, cloned.left, target);
        dfs(original.right, cloned.right, target);
    }
}
