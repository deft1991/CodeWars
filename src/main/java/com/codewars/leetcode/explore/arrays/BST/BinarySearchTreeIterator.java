package com.codewars.leetcode.explore.arrays.BST;

import java.util.Deque;
import java.util.LinkedList;

/*
 * Created by sgolitsyn on 3/26/20
 */
public class BinarySearchTreeIterator {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(7);
        TreeNode left1 = new TreeNode(3);
        TreeNode right1 = new TreeNode(15);
        TreeNode rightL = new TreeNode(9);
        TreeNode rightR = new TreeNode(20);
        root1.left = left1;
        root1.right = right1;
        right1.left = rightL;
        right1.right = rightR;

        BSTIterator bstIterator = new BSTIterator(root1);
        while(bstIterator.hasNext()){
            System.out.println(bstIterator.next());
        }
    }
}

class BSTIterator {
    Deque<Integer> iterList = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        checkSubTree(root, iterList);
    }

    private void checkSubTree(TreeNode node, Deque<Integer> iterList) {
        if (node != null) {
            checkSubTree(node.left, iterList);
            iterList.add(node.val);
            checkSubTree(node.right, iterList);
        }
    }

    /**
     * @return the next smallest number
     */
    @SuppressWarnings("ConstantConditions")
    public int next() {
        return iterList.pollFirst();
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return iterList.peek() != null;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
