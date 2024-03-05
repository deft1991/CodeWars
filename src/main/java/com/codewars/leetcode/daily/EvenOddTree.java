package com.codewars.leetcode.daily;

import com.codewars.leetcode.explore.TraverseATree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Sergey Golitsyn
 * created on 29.02.2024
 */
public class EvenOddTree {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(10);
        TreeNode c = new TreeNode(4);
        a.left = b;
        a.right = c;
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(7);
        TreeNode f = new TreeNode(9);
        b.left = d;
        c.left = e;
        c.right = f;
        TreeNode g = new TreeNode(12);
        TreeNode h = new TreeNode(8);
        TreeNode i = new TreeNode(6);
        TreeNode j = new TreeNode(2);

        d.left = g;
        d.right = h;

        e.left = i;
        f.right = j;

        EvenOddTree ev = new EvenOddTree();
        System.out.println(ev.isEvenOddTree(a));

    }

    public boolean isEvenOddTree(TreeNode root) {
        if(root.val % 2 == 0){
            return false;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        boolean isOdd = true;

        while(!q.isEmpty()){
            int size = q.size();
            int prevEven = Integer.MAX_VALUE;
            int prevOdd = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();

                if((isOdd && cur.val % 2 == 0) || (!isOdd && cur.val % 2 != 0)){
                    return false;
                }
                if(!isOdd){
                    // even
                    if(prevEven <= cur.val){
                        return false;
                    }
                    prevEven = cur.val;
                } else {
                    // odd
                    if(prevOdd >= cur.val){
                        return false;
                    }
                    prevOdd = cur.val;
                }
                if(cur.left != null){
                    q.add(cur.left);
                }
                if (cur.right != null){
                    q.add(cur.right);
                }
            }
            isOdd = !isOdd;
        }
        return true;
    }
}
