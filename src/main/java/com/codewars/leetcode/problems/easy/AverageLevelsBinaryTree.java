package com.codewars.leetcode.problems.easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Sergey Golitsyn
 * created on 21.08.2022
 */
public class AverageLevelsBinaryTree {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        TreeNode left1 = new TreeNode(9);
        TreeNode right1 = new TreeNode(20);
        TreeNode rightL = new TreeNode(15);
        TreeNode rightR = new TreeNode(7);
        root1.left = left1;
        root1.right = right1;
        right1.left = rightL;
        right1.right = rightR;

        System.out.println(averageOfLevels(root1));
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> rez = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            double sum = 0;
            int count = 0;
            Queue<TreeNode> tmp = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                sum += poll.val;
                count++;
                if (poll.left != null) {
                    tmp.add(poll.left);
                }
                if (poll.right != null) {
                    tmp.add(poll.right);
                }
            }
            queue = tmp;
            rez.add(sum/count);
        }
        return rez;
    }
}
