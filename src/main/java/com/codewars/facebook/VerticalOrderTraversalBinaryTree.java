package com.codewars.facebook;

import javax.imageio.ImageTranscoder;
import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 23.08.2023
 */
public class VerticalOrderTraversalBinaryTree {

    public static void main(String[] args) {
        VerticalOrderTraversalBinaryTree v = new VerticalOrderTraversalBinaryTree();

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);

        a.left = b;
        a.right = c;

        b.left = d;
        b.right = e;

        c.left = f;
        c.right = g;
        List<List<Integer>> lists = v.verticalTraversal(a);
        System.out.println();
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static class Node{
        int val;
        int col;
        int row;
        int min;
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Node>> map = new HashMap<>();
        verticalTraversal(root, 0, 0, map);
        List<List<Integer>> rez = new ArrayList<>();

        int min = Integer.MAX_VALUE;

        for (Integer levels : map.keySet()){
            min = Math.min(min, levels);
        }

        while (map.containsKey(min)){
            List<Node> list = map.get(min);
            list.sort((a, b) -> {
                if (a.row == b.row && a.col == b.col) {
                    return Integer.compare(a.val, b.val);
                } else if (a.row == b.row) {
                    return Integer.compare(a.col, b.col);
                } else {
                    return Integer.compare(a.row, b.row);
                }
            });
            min++;
            List<Integer> tmp = new ArrayList<>();
            for(Node n : list){
                tmp.add(n.val);
            }
            rez.add(tmp);
        }

        return rez;
    }

    private void verticalTraversal(TreeNode root, int row, int column, Map<Integer, List<Node>> map){
        if(root == null){
            return;
        }
        int min = Math.min(row, column);
        Node n = new Node();
        n.val = root.val;
        n.row = row;
        n.col = column;
        n.min = min;
        if (map.containsKey(min)){
            map.get(min).add(n);
        } else {
            List<Node> list = new ArrayList<>();
            list.add(n);
            map.put(min, list);
        }

        verticalTraversal(root.left, row + 1, column - 1, map);
        verticalTraversal(root.right, row + 1, column + 1, map);
    }

}
