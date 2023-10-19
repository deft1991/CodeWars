package com.codewars.facebook;


import com.codewars.leetcode.topInterviewQuestions.TreeNode;

import java.util.PriorityQueue;

/**
 * @author Sergey Golitsyn
 * created on 25.08.2023
 */
public class KthSmallestElementBST {

    public static void main(String[] args) {

        KthSmallestElementBST k = new KthSmallestElementBST();
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(2);
        TreeNode e = new TreeNode(1);

        a.left = c;
        c.right = b;
        c.left = d;
        d.left = e;

        System.out.println(k.kthSmallest(a, 3));
    }

    int rez = -1;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        rez = -1;
        count = 0;
        dfs(root, k);
        return rez;
    }

    private void dfs(TreeNode root, int k){
        if(root == null){
            return;
        }

        dfs(root.left, k);
        count ++;
        if(count == k && rez == -1){
            rez = root.val;
        }

        if(rez == -1){
            dfs(root.right, k);
        }

    }
}
