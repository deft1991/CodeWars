package com.codewars.interviewTasks;

import com.codewars.leetcode.explore.TraverseATree.TreeNode;
import com.sun.source.tree.Tree;

/**
 * @author Sergey Golitsyn
 * created on 28.04.2023
 *
 * 5   Print the mirror of a Binary Tree
 *       5
 *     /  \
 *    4    6
 *   /     / \
 *  3     2   7
 * output-
 *       5
 *     /  \
 *    6    4
 *   /  \    \
 *  7    2    3
 *
 */
public class MirrorBinaryTree {

    public static void main(String[] args) {
        MirrorBinaryTree mirrorBinaryTree = new MirrorBinaryTree();

        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(6);
        a.left = b;
        a.right = c;

        TreeNode d = new TreeNode(3);
        b.left = d;

        TreeNode e = new TreeNode(2);
        TreeNode f = new TreeNode(7);

        c.left = e;
        c.right = f;




        TreeNode treeNode = mirrorBinaryTree.mirrorTree(a);

        System.out.println();

    }

    /*

    1. mirror tree --> swap left and right


     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root != null){
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = right;
            root.right = left;
            mirrorTree(root.left);
            mirrorTree(root.right);
        }
        return root;
    }
}
