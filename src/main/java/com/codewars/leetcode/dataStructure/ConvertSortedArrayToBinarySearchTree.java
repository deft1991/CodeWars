package com.codewars.leetcode.dataStructure;

/**
 * @author Sergey Golitsyn
 * created on 29.03.2022
 */
public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        ConvertSortedArrayToBinarySearchTree c = new ConvertSortedArrayToBinarySearchTree();

        c.sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }

    public TreeNode sortedArrayToBST(int[] nums) {

        return helper(nums, 0, nums.length - 1);

    }

    private TreeNode helper(int[] nums, int lo, int hi){
        if(lo > hi){
            return null;
        }
        int mid = lo + (hi - lo) / 2;
        TreeNode n = new TreeNode(nums[mid]);

        n.left = helper(nums, lo, mid - 1);
        n.right = helper(nums, mid + 1, hi);
        return n;
    }

    public class TreeNode {
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
}
