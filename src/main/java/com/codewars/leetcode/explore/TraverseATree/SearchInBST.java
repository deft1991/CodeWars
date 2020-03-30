package com.codewars.leetcode.explore.TraverseATree;

/*
 * Created by sgolitsyn on 3/27/20
 */
public class SearchInBST {

    public static void main(String[] args) {
        SearchInBST searchInBST = new SearchInBST();
        TreeNode root1 = new TreeNode(7);
        TreeNode left1 = new TreeNode(3);
        TreeNode right1 = new TreeNode(15);
        TreeNode rightL = new TreeNode(9);
        TreeNode rightR = new TreeNode(20);
        root1.left = left1;
        root1.right = right1;
        right1.left = rightL;
        right1.right = rightR;
        System.out.println(searchInBST.searchBST(root1, 7));
        System.out.println(searchInBST.searchBST(root1, 3));
        System.out.println(searchInBST.searchBST(root1, 15));
        System.out.println(searchInBST.searchBST(root1, 9));
        System.out.println(searchInBST.searchBST(root1, 20));
        System.out.println(searchInBST.searchBST(null, 20));
        System.out.println(searchInBST.searchBST(root1, 21));
        System.out.println(searchInBST.searchBST(root1, 1));
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        int rootVal = root.val;
        if (val == rootVal) {
            return root;
        } else if (val > rootVal) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }
}
