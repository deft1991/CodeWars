package com.codewars.leetcode.days21;

/**
 * @author Sergey Golitsyn
 * created on 24.03.2022
 */
public class SubtreeOfAnotherTree {

    public static void main(String[] args) {
        SubtreeOfAnotherTree s = new SubtreeOfAnotherTree();
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(5);
        TreeNode d = new TreeNode(1);

        TreeNode e = new TreeNode(2);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        TreeNode x = new TreeNode(4);
        TreeNode y = new TreeNode(1);
        TreeNode z = new TreeNode(2);
        x.left = y;
        x.right = z;


        System.out.println(s.isSubtree(a, x));

//        TreeNode q = new TreeNode(1);
//        TreeNode w = new TreeNode(1);
//        q.left = w;
//        System.out.println(s.isSubtree(q, w));

    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null){
            return true;
        } else if (root == null){
            return false;
        }

        return isEqual(root, subRoot)
                || isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot);
    }

    private boolean isEqual(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null){
            return true;
        }
        if (root == null || subRoot == null){
            return false;
        }
        if (root.val != subRoot.val){
            return false;
        }

        return isEqual(root.left, subRoot.left) && isEqual(root.right, subRoot.right);
    }

    public static class TreeNode {
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
