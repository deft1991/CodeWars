package com.codewars.leetcode.problems.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Sergey Golitsyn
 * created on 13.04.2021
 */
public class DeepestLeavesSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(54);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(98);
        TreeNode g = new TreeNode(6);
        TreeNode z = new TreeNode(34);

        root.left = null;
        root.right = b;

        b.left = e;
        b.right = g;

        g.right = z;

        DeepestLeavesSum dep = new DeepestLeavesSum();

        System.out.println(dep.deepestLeavesSum(root));

    }

    public int deepestLeavesSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();

        dfs(root, 0, map);
        Integer maxLevel = map.keySet()
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList()).get(0);
        return map.get(maxLevel);
    }

    private void dfs(TreeNode root, int level, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }

        map.put(level, map.getOrDefault(level, 0) + root.val);
        dfs(root.left, level + 1, map);
        dfs(root.right, level + 1, map);
    }

}
