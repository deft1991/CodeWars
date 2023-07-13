package com.codewars.neetcode.tree;

import com.codewars.leetcode.explore.TraverseATree.TreeNode;

/**
 * @author Sergey Golitsyn
 * created on 10.07.2023
 */
public class InvertBinaryTree2 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        a.left = b;
        a.right = c;

        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        b.left = d;
        b.right = e;

        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        c.left = f;
        c.right = g;


        InvertBinaryTree2 i = new InvertBinaryTree2();
        TreeNode treeNode = i.invertTree(a);
        System.out.println();
    }

    public TreeNode invertTree(TreeNode root) {
        if (root != null){
            TreeNode tmp = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(tmp);
        }
        return root;
    }
}
