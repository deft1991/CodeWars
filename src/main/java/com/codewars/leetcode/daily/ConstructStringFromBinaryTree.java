package com.codewars.leetcode.daily;

import com.codewars.leetcode.explore.TraverseATree.TreeNode;

/**
 * @author Sergey Golitsyn
 * created on 08.12.2023
 */
public class ConstructStringFromBinaryTree {

    public static void main(String[] args) {
        ConstructStringFromBinaryTree con = new ConstructStringFromBinaryTree();
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);

        a.left = b;
        a.right = c;

        TreeNode d = new TreeNode(4);

        b.right = d;

        System.out.println(con.tree2str(a));

    }

    /**
     * Input: root = [1,2,3,4]
     * Output: "1(2(4))(3)"
     * <p>
     * Input: root = [1,2,3,null,4]
     * Output: "1(2()(4))(3)"
     */
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        tree2str(sb, root);
        return sb.toString();
    }

    private void tree2str(StringBuilder sb, TreeNode root) {
        if (root == null) {
            return;
        } else {
            sb.append(root.val);
            if (root.left == null && root.right == null) {
                return;
            } else {
                if (root.left == null) {
                    sb.append("()");
                    sb.append("(");
                    tree2str(sb, root.right);
                    sb.append(")");
                } else if (root.right == null) {
                    sb.append("(");
                    tree2str(sb, root.left);
                    sb.append(")");
                } else {
                    sb.append("(");
                    tree2str(sb, root.left);
                    sb.append(")");
                    sb.append("(");
                    tree2str(sb, root.right);
                    sb.append(")");
                }
            }
        }
    }

}
