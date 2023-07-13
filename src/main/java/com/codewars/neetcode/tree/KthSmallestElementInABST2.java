package com.codewars.neetcode.tree;

import com.codewars.leetcode.explore.TraverseATree.TreeNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author Sergey Golitsyn
 * created on 31.01.2023
 */
public class KthSmallestElementInABST2 {

    public static void main(String[] args) {
        KthSmallestElementInABST2 k = new KthSmallestElementInABST2();
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
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> set = new HashSet<>();
        stack.push(root);
        set.add(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if (cur.left != null && !set.contains(cur.left)){
                stack.push(cur);
                stack.push(cur.left);
                set.add(cur.left);
                continue;
            }
            count++;
            if (count == k){
                return cur.val;
            }
            if (cur.right != null && !set.contains(cur.right)){
                stack.push(cur.right);
                set.add(cur.right);
            }
        }
        return rez;
    }

}
