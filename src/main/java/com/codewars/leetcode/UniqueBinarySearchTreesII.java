package com.codewars.leetcode;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 05.08.2023
 */
public class UniqueBinarySearchTreesII {

    public static void main(String[] args) {
        UniqueBinarySearchTreesII u = new UniqueBinarySearchTreesII();

        List<TreeNode> treeNodes = u.generateTrees(3);

        System.out.println(Arrays.toString(treeNodes.toArray()));
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> rez = new ArrayList<>();
        Set<Integer> used = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            TreeNode head = new TreeNode(i);
            used.add(i);
            backtrack(rez, used, head, head, 1, n);
            used.remove(i);
        }

        return rez;

    }

    public void backtrack(List<TreeNode> rez, Set<Integer> used, TreeNode head, TreeNode cur, int startIdx, int endIdx) {
        if (used.size() == endIdx) {
            TreeNode clone = clone(head);
            rez.add(clone);
        } else {
            for (int i = 1; i <= endIdx; i++) {
                if (used.contains(i)) {
                    continue;
                }
                TreeNode tmp = new TreeNode(i);
                used.add(i);
                if (cur.val < i) {
                    cur.right = tmp;
                    backtrack(rez, used, head, tmp, i + 1, endIdx);
                } else {
                    cur.left = tmp;
                    backtrack(rez, used, head, cur, i + 1, endIdx);
                }
                used.remove(i);
            }
        }
    }

    private TreeNode clone(TreeNode head){
        if(head != null){
            TreeNode tmp = new TreeNode(head.val);
            tmp.left = clone(head.left);
            tmp.right = clone(head.right);
            return tmp;
        }
        return null;
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
