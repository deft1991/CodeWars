package com.codewars.neetcode.tree;

import com.codewars.leetcode.explore.TraverseATree.TreeNode;

/**
 * @author Sergey Golitsyn
 * created on 31.01.2023
 */
public class KthSmallestElementInABST {

    public static void main(String[] args) {
        KthSmallestElementInABST k = new KthSmallestElementInABST();
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(6);
        a.left = b;
        a.right = c;

        TreeNode d = new TreeNode(2);
        TreeNode e = new TreeNode(4);
        b.left = d;
        b.right = e;

        TreeNode f = new TreeNode(1);
        d.left = f;

        System.out.println(k.kthSmallest(a, 1)); // 1
        System.out.println(k.kthSmallest(a, 2)); // 2
        System.out.println(k.kthSmallest(a, 3)); // 3
        System.out.println(k.kthSmallest(a, 4)); // 4
        System.out.println(k.kthSmallest(a, 5)); // 5
        System.out.println(k.kthSmallest(a, 6)); // 6

    }

    int rez = -1;
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        rez = -1;
        count = 0;
        kth(root, k);
        return rez;
    }

    public void kth(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        kth(root.left, k);
        count++;
        if (count == k && rez == -1) {
            /*
            So we check if co is still -1 means,
            its value isn't set yet. so we set it otherwise we return it
             */
            rez = root.val;
        }
        kth(root.right, k);
    }
}
