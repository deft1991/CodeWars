package com.codewars.neetcode.tree;

import com.codewars.leetcode.explore.TraverseATree.TreeNode;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 07.02.2023
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal c = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
//        TreeNode x = c.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        TreeNode x = c.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(x);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(0, preorder.length, preorder, 0, inorder.length, inorder);
    }

    public TreeNode buildTree(int startP, int endP, int[] preorder, int startI, int endI, int[] inorder) {
        if (startP >= preorder.length || startP > endP || startI > endI){
            return null;
        }
        TreeNode root = new TreeNode(preorder[startP]);
        int mid = findChar(preorder[startP], inorder);
        root.left = buildTree(startP + 1, mid, preorder, startI, mid - 1, inorder);
        root.right =  buildTree(mid+1, endP, preorder, mid + 1, endI, inorder);;
        return root;
    }

    private int findChar(int curChar, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (curChar == inorder[i]){
                return i;
            }
        }
        return -1;
    }

}
