package com.codewars.facebook;


import com.codewars.leetcode.explore.TraverseATree.TreeNode;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 02.09.2023
 */
public class AllNodesDistanceKBinaryTree2 {

    public static void main(String[] args) {
        AllNodesDistanceKBinaryTree2 all = new AllNodesDistanceKBinaryTree2();

        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(1);

        a.left = b;
        a.right = c;

        TreeNode d = new TreeNode(6);
        TreeNode e = new TreeNode(2);
        b.left = d;
        b.right = e;

        TreeNode f = new TreeNode(7);
        TreeNode g = new TreeNode(4);

        e.left = f;
        e.right = g;

        TreeNode h = new TreeNode(0);
        TreeNode i = new TreeNode(8);

        c.left = h;
        c.right = i;

        List<Integer> integers = all.distanceK(a, b, 2);

        System.out.println(Arrays.toString(integers.toArray()));
    }

    /*
    1
   2 3
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        buildGraph(graph, root, null);

        int count = 0;
        Set<Integer> visited = new HashSet<>();
        List<Integer> rez = new ArrayList<>();

        visited.add(target.val);
        dfs(graph, rez, target.val, visited, count, k);

        return rez;
    }

    private void dfs(Map<Integer, List<Integer>> graph, List<Integer> rez, int node, Set<Integer> visited, int dist, int k) {
        if (dist == k) {
            rez.add(node);
            return;
        }
        for (int neighbour : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbour)) {
                visited.add(neighbour);
                dfs(graph, rez, neighbour, visited, dist + 1, k);
            }
        }
    }

    private void buildGraph(Map<Integer, List<Integer>> graph, TreeNode node, TreeNode parent) {
        if (node != null && parent != null) {
            graph.putIfAbsent(node.val, new ArrayList<>());
            graph.putIfAbsent(parent.val, new ArrayList<>());

            graph.get(node.val).add(parent.val);
            graph.get(parent.val).add(node.val);
        }
        if(node != null && node.left != null){
            buildGraph(graph, node.left, node);
        }
        if (node != null && node.right != null){
            buildGraph(graph, node.right, node);
        }
    }

}
