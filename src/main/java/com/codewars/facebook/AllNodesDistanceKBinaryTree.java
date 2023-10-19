package com.codewars.facebook;


import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 29.08.2023
 */
public class AllNodesDistanceKBinaryTree {

    public static void main(String[] args) {
        AllNodesDistanceKBinaryTree all = new AllNodesDistanceKBinaryTree();

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

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> rez = new ArrayList<>();

        linkParent(root, null);
        Set<TreeNode> visited = new HashSet<>();
        distance(target, k, visited, rez);
        return rez;
    }

    private void distance(TreeNode node, int k, Set<TreeNode> visited, List<Integer> rez) {
        if(node != null && !visited.contains(node)){
            visited.add(node);
            if (k == 0){
                rez.add(node.val);
            } else {
                distance(node.left, k - 1, visited, rez);
                distance(node.right, k - 1, visited, rez);
                distance(node.parent, k - 1, visited, rez);
            }
        }
    }

    private void linkParent(TreeNode root, TreeNode parent) {
        if(root == null){
            return;
        }
        root.parent = parent;
        linkParent(root.left, root);
        linkParent(root.right, root);
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
