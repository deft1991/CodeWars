package com.codewars.neetcode.tree;

import com.codewars.leetcode.explore.TraverseATree.TreeNode;

/**
 * @author Sergey Golitsyn
 * created on 27.01.2023
 */
public class CountGoodNodesInBinaryTree {

    public static void main(String[] args) {
        CountGoodNodesInBinaryTree count = new CountGoodNodesInBinaryTree();
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(4);
        a.left = b;
        a.right = c;

        TreeNode d = new TreeNode(3);
        b.left = d;

        TreeNode e = new TreeNode(1);
        TreeNode f = new TreeNode(5);
        c.left = e;
        c.right = f;

        System.out.println(count.goodNodes(a)); // 4

        TreeNode aa = new TreeNode(2);
        TreeNode ab = new TreeNode(4);
        aa.right = ab;

        TreeNode ac = new TreeNode(10);
        TreeNode ad = new TreeNode(8);
        ab.left = ac;
        ab.right = ad;

        TreeNode ae = new TreeNode(4);
        ac.right = ae;

        System.out.println(count.goodNodes(aa)); // 4

        TreeNode aaa = new TreeNode(9);
        TreeNode aab = new TreeNode(3);
        TreeNode aac = new TreeNode(6);
        aaa.right = aab;
        aab.left = aac;

        System.out.println(count.goodNodes(aaa)); // 1
    }

    public int goodNodes(TreeNode root) {
        return goodNodes(root, root);
    }

    public int goodNodes(TreeNode root, TreeNode node){
        if (node == null){
            return 0;
        }
        int count  = 0;

        if (root.val <= node.val){
            count ++;
        }

        TreeNode big = root;
        if (root.val < node.val){
            big = node;
        }
        int leftCount = goodNodes(big, node.left);
        int rightCount = goodNodes(big, node.right);
        return leftCount + rightCount + count;
    }
}
