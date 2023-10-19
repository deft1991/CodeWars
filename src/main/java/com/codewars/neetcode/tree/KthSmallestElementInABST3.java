package com.codewars.neetcode.tree;

import com.codewars.leetcode.explore.TraverseATree.TreeNode;

/**
 * @author Sergey Golitsyn
 * created on 02.10.2023
 */
public class KthSmallestElementInABST3 {

    public static void main(String[] args) {
        KthSmallestElementInABST3 k = new KthSmallestElementInABST3();
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(6);

        a.left = b;
        a.right = c;

        TreeNode d = new TreeNode(2);
        b.left = d;
        TreeNode e = new TreeNode(1);
        d.left = e;

        TreeNode f = new TreeNode(4);
        b.right = f;

        System.out.println(k.kthSmallest(a, 3));
    }

    int count = 0;
    int rez = -1;
    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        rez = -1;
        dfs(root, k);
        return rez;
    }

    private void dfs(TreeNode root, int k){
        if(root == null || rez != -1){
            return;
        }
        dfs(root.left, k);
        count++;
        if(count == k && rez == -1){
            rez = root.val;
            return;
        }
        if(rez == -1){
            dfs(root.right, k);
        }
    }
}
