package com.codewars.leetcode.explore.TraverseATree;

/*
 * Created by sgolitsyn on 3/31/20
 *
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Note: Time complexity should be O(height of tree).

Example:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

Given key to delete is 3. So we find the node with value 3 and delete it.

One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

    5
   / \
  4   6
 /     \
2       7

Another valid answer is [5,2,6,null,4,null,7].

    5
   / \
  2   6
   \   \
    4   7
    *
    * 1) Node to be deleted is leaf: Simply remove from the tree.
    * 2) Node to be deleted has only one child: Copy the child to the node and delete the child
    * 3) Node to be deleted has two children: Find inorder successor of the node.
    *    Copy contents of the inorder successor to the node and delete the inorder successor.
    *    Note that inorder predecessor can also be used.
 */
public class DeleteNodeBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(3);
        TreeNode leftL = new TreeNode(2);
        TreeNode leftR = new TreeNode(4);
        TreeNode right = new TreeNode(6);
        TreeNode rightR = new TreeNode(7);
        root.left = left;
        root.right = right;
        left.left = leftL;
        left.right = leftR;
        right.right = rightR;

        DeleteNodeBST deleteNodeBST = new DeleteNodeBST();
        System.out.println(deleteNodeBST.deleteNode(root, 3).val);

    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        } else {
            if (key < root.val) {
                root.left = deleteNode(root.left, key);
            } else if (key > root.val) {
                root.right = deleteNode(root.right, key);
            } else {
                // 1) Node to be deleted is leaf: Simply remove from the tree.
                // 2) Node to be deleted has only one child: Copy the child to the node and delete the child
                if (root.left == null || root.right == null) {
                    return (root.left == null) ? root.right : root.left;
                } else {
                    // 3) Node to be deleted has two children: Find inorder successor of the node.
                    //    Copy contents of the inorder successor to the node and delete the inorder successor.
                    //    Note that inorder predecessor can also be used.
                    TreeNode successor = getSuccessor(root);
                    root.val = successor.val;
                    root.right = deleteNode(root.right, successor.val);
                    return root;
                }
            }
        }
        return root;
    }

    /*
     * Find min node in right subTree
     */
    private TreeNode getSuccessor(TreeNode root) {
        if (root == null) {
            return null;
        } else {
            TreeNode tmp = root.right;

            while (tmp.left != null) {
                tmp = tmp.left;
            }
            return tmp;
        }
    }

}
