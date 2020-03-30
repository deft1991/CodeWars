package com.codewars.leetcode.explore.TraverseATree;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by sgolitsyn on 3/30/20
 */
public class BinaryTreeLevelOrderTraversal {

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

        BinaryTreeLevelOrderTraversal b = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> lists = b.levelOrder(root1);
        System.out.println(lists);
    }

    List<List<Integer>> rez = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        int height = getHeight(root);
        for (int i = 0; i < height; i++) {
            rez.add(new ArrayList<>());
        }
        levelOrder(root, 0, rez);
        return rez;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);

        if (leftH > rightH) {
            return leftH + 1;
        } else {
            return rightH + 1;
        }


    }

    public void levelOrder(TreeNode root, int level, List<List<Integer>> rez) {
        if (root != null) {
            List<Integer> levelNodes = rez.get(level);
            levelNodes.add(root.val);
            levelOrder(root.left, level + 1, rez);
            levelOrder(root.right, level + 1, rez);
        }
    }
}
