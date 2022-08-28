package com.codewars.leetcode.problems.easy;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Sergey Golitsyn
 * created on 23.08.2022
 */
public class MinimumDepthBinaryTree {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);
        TreeNode rightL = new TreeNode(4);
        TreeNode rightR = new TreeNode(5);

        TreeNode rightLL = new TreeNode(6);
        TreeNode rightRR = new TreeNode(7);
        root1.left = left1;
        root1.right = right1;
        left1.left = rightL;
        right1.right = rightR;

        System.out.println(minDepth(root1));
    }

    public static int minDepth(TreeNode root) {

        Queue<TreeNode> q = new ArrayDeque<>();

        q.add(root);
        int level = 1;
        while (!q.isEmpty()) {

            Queue<TreeNode> tmp = new ArrayDeque<>();

            while (!q.isEmpty()) {
                TreeNode cur = q.poll();

                if (cur.left == null && cur.right == null) {
                    return level;
                }
                if (cur.left == null) {
                    tmp.add(cur.right);
                }
                if (cur.right == null) {
                    tmp.add(cur.left);
                }

            }
            q = tmp;
            level++;
        }
        return level;
    }
}
