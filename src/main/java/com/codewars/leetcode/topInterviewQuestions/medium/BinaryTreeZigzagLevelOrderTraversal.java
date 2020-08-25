package com.codewars.leetcode.topInterviewQuestions.medium;

import com.codewars.leetcode.topInterviewQuestions.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Created by sgolitsyn on 8/21/20

 Given a binary tree,
 return the zigzag level order traversal of its nodes' values.
 (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]

 And second example
 [1,2,3,4,null,null,5] --> expected [[1],[3,2],[4,5]]
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal zigzag = new BinaryTreeZigzagLevelOrderTraversal();

        TreeNode root = new TreeNode(1);

        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        root.left = l1;
        root.right = r1;

        TreeNode l2 = new TreeNode(4);
        TreeNode r2 = new TreeNode(5);
        l1.left = l2;
        r1.right = r2;


        TreeNode l3 = new TreeNode(3);
        TreeNode r3 = new TreeNode(3);

        List<List<Integer>> lists = zigzag.zigzagLevelOrder(root);

        lists.forEach(list -> System.out.println(Arrays.toString(new List[]{list})));


    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> rez = new ArrayList<>();

        int height = getHeight(root);
        for (int i = 0; i < height; i++) {
            rez.add(new ArrayList<>());
        }

        zigzagOrder(root, 0, rez);
        return rez;
    }

    private void zigzagOrder(TreeNode root, int height, List<List<Integer>> rez) {
        if (root != null) {
            List<Integer> integers = rez.get(height);


            if (height % 2 != 0) {
                integers.add(0, root.val);
            } else {
                integers.add(root.val);
            }
            zigzagOrder(root.left, height + 1, rez);
            zigzagOrder(root.right, height + 1, rez);
        }
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
