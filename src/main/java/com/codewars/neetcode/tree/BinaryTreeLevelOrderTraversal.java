package com.codewars.neetcode.tree;

import com.codewars.leetcode.explore.TraverseATree.TreeNode;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 25.01.2023
 */
public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {

        BinaryTreeLevelOrderTraversal bin = new BinaryTreeLevelOrderTraversal();

        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        a.left = b;
        a.right = c;
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);
        c.left = d;
        c.right = e;

        List<List<Integer>> lists = bin.levelOrder(a);
        List<List<Integer>> listsDFS = bin.levelOrderDFS(a);
        System.out.println(Arrays.toString(lists.toArray()));
        System.out.println(Arrays.toString(listsDFS.toArray()));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> rez = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                tmp.add(node.val);
            }
            rez.add(tmp);
        }
        return rez;
    }
    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> rez = new ArrayList<>();
        dfs(root, rez, 0);
        return rez;
    }

    private void dfs(TreeNode root, List<List<Integer>> rez, int level){
        if (root == null){
            return;
        }
        if (level >= rez.size()){
            rez.add(new ArrayList<>());
        }
        rez.get(level).add(root.val);
        dfs(root.left, rez, level + 1);
        dfs(root.right, rez, level + 1);
    }
}
