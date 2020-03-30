package com.codewars.leetcode.explore.TraverseATree;

/*
 * Created by sgolitsyn on 3/27/20
 *
 *
 * Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert the value into the BST. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

For example,

Given the tree:
        4
       / \
      2   7
     / \
    1   3
And the value to insert: 5
You can return this binary search tree:

         4
       /   \
      2     7
     / \   /
    1   3 5
This tree is also valid:

         5
       /   \
      2     7
     / \
    1   3
         \
          4
 */
public class InsertInBST {

    public static void main(String[] args) {
        InsertInBST insertInBST = new InsertInBST();
        TreeNode root1 = insertInBST.insertIntoBST(null, 5);
        TreeNode left1 = insertInBST.insertIntoBST(root1, 2);
        TreeNode right1 = insertInBST.insertIntoBST(root1, 7);
        TreeNode rightL = insertInBST.insertIntoBST(root1, 3);
        TreeNode rightR = insertInBST.insertIntoBST(root1, 6);
        System.out.println(root1);
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        int rootVal = root.val;
        if (val < rootVal) {
            if (root.left == null) {
                root.left = new TreeNode(val);
                return root;
            }
            insertIntoBST(root.left, val);
        } else {
            if (root.right == null) {
                root.right = new TreeNode(val);
                return root;
            }
            insertIntoBST(root.right, val);
        }
        return root;
    }
}
