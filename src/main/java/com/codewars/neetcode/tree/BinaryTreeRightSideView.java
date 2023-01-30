package com.codewars.neetcode.tree;

import com.codewars.leetcode.explore.TraverseATree.TreeNode;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 25.01.2023
 */
public class BinaryTreeRightSideView {

    public static void main(String[] args) {
        BinaryTreeRightSideView bin = new BinaryTreeRightSideView();

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        a.left = b;
        a.right = c;
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        b.right = d;
//        c.right = e;

        System.out.println(Arrays.toString(bin.rightSideView(a).toArray()));
        System.out.println(Arrays.toString(bin.rightSideViewDFS(a).toArray()));
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> rez = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (rez.size() <= level) {
                    rez.add(node.val);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
            }
            level++;
        }
        return rez;
    }

    public List<Integer> rightSideViewDFS(TreeNode root) {
        List<Integer> rez = new ArrayList<>();
        dfs(root, rez, 0);
        return rez;
    }

    private void dfs(TreeNode root, List<Integer> rez, int level) {
        if (root == null) {
            return;
        }

        if (rez.size() <= level) {
            rez.add(root.val);
        }
        dfs(root.right, rez, level + 1);
        dfs(root.left, rez, level + 1);
    }
}
