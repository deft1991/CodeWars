package com.codewars.neetcode.tree;

import com.codewars.leetcode.explore.TraverseATree.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @author Sergey Golitsyn
 * created on 06.10.2023
 */
public class SerializeDeserializeBinaryTree {

    public static void main(String[] args) {
        SerializeDeserializeBinaryTree s = new SerializeDeserializeBinaryTree();

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        a.left = b;
        a.right = c;

        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(5);
        c.left = f;
        c.right = g;

        String serialize = s.serialize(a);
        System.out.println(serialize);

        TreeNode deserialize = s.deserialize("1,2,null,null,3,4,null,null,5,null,null");
        System.out.println();
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        preorder(root, sb);

        return sb.substring(0, sb.lastIndexOf(","));
    }

    private void preorder (TreeNode root,  StringBuilder sb){
        if(root != null){
            sb.append(root.val);

            preorder(root.left, sb);
            preorder(root.right, sb);
        } else {
            sb.append("null");
        }
        sb.append(",");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        idx = 0;
        return dfs(split);
    }

    int idx = 0;
    private TreeNode dfs(String[] split){
        if(split[idx].equals("null")){
            idx++;
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.parseInt(split[idx]));
            idx++;
            node.left = dfs(split);
            node.right = dfs(split);
            return node;
        }
    }
}
