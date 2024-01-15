package com.codewars.leetcode.daily;

import com.codewars.leetcode.explore.TraverseATree.TreeNode;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 10.01.2024
 */
public class AmountTimeBinaryTreeBeInfected {

    public static void main(String[] args) {

    }

    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        convert(root, 0, graph);

        Queue<Integer> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        q.add(start);
        int time = 0;
        while (!q.isEmpty()) {
            time++;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                for (int child : graph.get(cur)) {
                    if (!visited.contains(child)) {
                        visited.add(child);
                        q.add(child);
                    }
                }
            }
        }
        return time - 1;
    }

    private void convert(TreeNode root, int parent, Map<Integer, Set<Integer>> graph) {
        if (root == null) {
            return;
        }
        if (!graph.containsKey(root.val)) {
            graph.put(root.val, new HashSet<>());
        }
        Set<Integer> adjacentSet = graph.get(root.val);
        if (parent != 0) {
            adjacentSet.add(parent);
        }
        if (root.left != null) {
            adjacentSet.add(root.left.val);
            convert(root.left, root.val, graph);
        }
        if (root.right != null) {
            adjacentSet.add(root.right.val);
            convert(root.right, root.val, graph);
        }

    }
}
